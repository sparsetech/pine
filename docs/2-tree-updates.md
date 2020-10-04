# Tree updates
## Operations
A `Node` is equipped with a variety of functions to easily manipulate trees such as `prepend`, `append`, `remove`, `clearAll`, `filter`, `flatMap`, `map` and others. See the [source code](https://github.com/sparsetech/pine/blob/master/shared/src/main/scala/pine/Node.scala) for an overview.

## Referencing nodes
While the operations from the previous section allow you to modify the tree, they operate on either the root node or are applied recursively to all children.

If you would like to update a specific child further down in the hierarchy, Pine introduces the concept of tag references (`TagRef`s). These have the advantage that changes can be batched and applied efficiently.

In order to do so, you need to make the nodes you would like to reference identifiable, for example by setting the `id` attributes:

```scala
val node = html"""
  <div id="child">
    <span id="age"></span>
    <span id="name"></span>
  </div>
"""
```

Now you can reference these nodes using `TagRef`s. A `TagRef` takes the referenced tag's ID and HTML type:

```scala
val spanAge  = TagRef[tag.Span]("age")
val spanName = TagRef[tag.Span]("name")
```

There are more ways to reference nodes such as by class name or tag type. See section "Tag references".

## Updating nodes
You can use the `update()` method to change the node:

```scala
val result = node.update { implicit ctx =>
  spanAge  := 42
  spanName := "Joe"
}
```

The changes (_diffs_) take an implicit rendering context. When you call `update()`, the changes will be queued up in the rendering context and processed in a batch.

`result` will be equivalent to:

```html
<div id="child">
  <span id="age">42</span>
  <span id="name">Joe</span>
</div>
```

## Replacing nodes
If you would like to replace the node itself, you can use `replace()`:

```scala
val result = node.update { implicit ctx =>
  spanAge .replace(42)
  spanName.replace("Joe")
}
```

`result` will be equivalent to:

```html
<div id="child">
  42
  Joe
</div>
```

## Updating children
```scala
val node = html"""<div id="page"></div>"""
val root = TagRef[tag.Div]("page")
```

In order to render a list, you can use the `:=` function (alias for `set`):

```scala
root.update { implicit ctx =>
  root := List(
    html"<div>Hello, </div>",
    html"<div>world!</div>"
  )
}
```

But if you would like to later access those child nodes they need unique IDs. This is particularly useful when you render your HTML on the server and want to access it in JavaScript, e.g. in order to attach event handlers.

First, we define a data type we would like to render:

```scala
case class Item(id: Int, name: String)
```

Next, we define a function that returns a child node given an item.

```scala
val itemView = html"""<div id="child"><span id="name"></span></div>"""
def idOf(item: Item): String = item.id.toString
def renderItem(item: Item): Tag[_] = {
  val id   = idOf(item)
  val node = itemView.suffixIds(id)
  val spanName = TagRef[tag.Span]("name", id)
  node.update(implicit ctx => spanName := item.name)
}
```

Finally, we render a list of items using the `set` method.

```scala
val items  = List(Item(0, "Joe"), Item(1, "Jeff"))
val result = node.update(implicit ctx => root.set(items.map(renderItem)))
```

`result` will be equivalent to:

```html
<div id="page">
  <div id="child0">
    <span id="name0">Joe</span>
  </div>
  <div id="child1">
    <span id="name1">Jeff</span>
  </div>
</div>
```

Now, we can reference child nodes using a `TagRef`:

```scala
TagRef[tag.Div]("child", idOf(items.head))  // TagRef[tag.Child]("child0")
```

## Updating attributes
As our `TagRef` objects are typed, we can provide implicits for supported attributes.

```scala
val node = html"""<a id="lnk">GitHub</a>"""
node.update(implicit ctx =>
  NodeRef[tag.A]("lnk").href := "https://github.com/"
)
```

## Tag references
Tags can be referenced using:

* ID attribute: `TagRef[tag.A]("id")`
* Tag type: `TagRef[tag.A]`
* Class name: `TagRef.byClass[tag.A]("class-name")`

A `TagRef` exposes methods for manipulating nodes and their attributes. See its [source code](https://github.com/sparsetech/pine/tree/master/src/main/scala/pine/TagRef.scala) for a full list of operations.

## Diffs
A `Diff` is an immutable object which describes tree changes. It is instantiated for example by the `TagRef` operations you have seen before such as `:=` (`set`), `replace` etc.

So far, these changes were performed directly on the tree. However, for the JavaScript back end, we have an additional rendering context that can apply those changes to the DOM. This will be explained in the next chapter.

The full list of supported diffs can be found [here](https://github.com/sparsetech/pine/tree/master/src/main/scala/pine/Diff.scala).

### Multiple occurrences
If you would like to perform a change on all occurrences of a `TagRef`, use the `each` function:

```scala
val div = html"""<div><span></span><span></span></div>"""
div.update(implicit ctx =>
  TagRef["span"].each += html"<b>Hello</b>").toHtml
// <div><span><b>Hello</b></span><span><b>Hello</b></span></div>
```

`each` can also be used in conjunction with any other diff type, such as attribute updates:

```scala
val div  = html"""<div><a href="/a">A</a><a href="/b">B</a></div>"""
val html = div.update(implicit ctx =>
  TagRef["a"].each.href.update(_.map(url => s"$url/test"))).toHtml
// <div><a href="/a/test">A</a><a href="/b/test">B</a></div>
```

## HTML/CSS extensions
Pine's DSL provides extensions to facilitate interaction with HTML/CSS. For toggling the visibility of a node, you can use `hide()`:

```scala
div.hide(true)  // Sets `style` attribute to hide the element in the browser
```

## Token list attributes
There are certain HTML attributes whose values are encoded as space-separated tokens. `class` and `rel` are the most prominent examples.

These attributes have a special mapping in Pine that models their underlying sequential nature:

```scala
tag.Div.`class`("a", "b")           // Sets the classes "a" and "b"
tag.Div.`class`.set(Seq("a", "b"))  // Same as before
tag.Div.`class`.get                 // Returns the list of classes
tag.Div.`class`.add("a")            // Adds the class "a"
tag.Div.`class`.remove("a")         // Removes the class "a"
tag.Div.`class`.clear()             // Removes all classes
tag.Div.`class`.toggle("a")         // Toggles the class "a"
tag.Div.`class`.state(value, "a")   // Adds the class "a" if value is true, remove otherwise
tag.Div.`class`.update(_ :+ "a")    // Updates the classes
```

The same functionality is available on `TagRef`s.

## Custom attributes
If you would like to support custom attributes, you can extend the functionality of any tag by defining an implicit class. This is the same approach which Pine uses internally to define attributes for HTML elements.

For example, to define attributes on anchor nodes, you would write:

```scala
implicit class TagRefAttributesA(tagRef: TagRef[tag.A]) {
  val dataTooltip = TagRefAttribute[tag.A, String](tagRef, "data-tooltip")
  val dataShow    = TagRefAttribute[tag.A, Boolean](tagRef, "data-show")
}
```
