# Tree updates
## References
Pine lets you perform node updates. In order to do so, you need to set the `id` attribute on the nodes you would like to reference:

```scala
val node = html"""
  <div id="child">
    <span id="age"></span>
    <span id="name"></span>
  </div>
"""
```

You can reference nodes using `TagRef`. It takes the referenced tag's ID and HTML type:

```scala
val spanAge  = TagRef[tag.Span]("age")
val spanName = TagRef[tag.Span]("name")
```

## Updating nodes
You can use the `update()` method to change the node:

```
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

```
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
def renderItem(item: Item): Tag = {
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

## Diffs
Diffs encapsulate changes. The operations you have seen before like `:=` (`set`), `replace` etc. create immutable objects describing the change you would like to perform.

So far, these changes were performed directly on the tree. However, for the JavaScript back end, we have an additional rendering context that can apply those changes to the DOM. This will be explained in the next chapter.

A full list of supported diffs can be found [here](https://github.com/sparsetech/pine/tree/master/core/shared/src/main/scala/Diff.scala).

## DSL
To facilitate interaction with nodes, Pine provides a small DSL with extensions.

For example, to toggle one or multiple CSS tags, use `css()`:

```scala
val div = TagRef[tag.Div]("div")
div.css(false, "a", "b")  // Remove the CSS tags "a" and "b" from div
```

For toggling the visibility of a node, use `hide()`:

```scala
div.hide(true)  // Sets `style` attribute to hide the element in the browser
```
