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
val result = node.update(
  spanAge  := 42
, spanName := "Joe"
)
```

The changes `update()` takes are called _diffs_, more on that later.

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
val result = node.update(
  spanAge .replace(42)
, spanName.replace("Joe")
)
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
root.update(
  root := List(
    html"<div>Hello, </div>",
    html"<div>world!</div>"
  )
)
```

But if you would like to later access those child nodes they should have an ID. This is particularly useful if you render your HTML on the server and then want to modify it in JavaScript.

First, we need to define a data type we would like to render:

```scala
case class Item(id: Int, name: String)
```

Next, we will implement Pine's `Id` type class:

```scala
implicit def itemId: Id[Item] = Id(_.id.toString)
```

We define a function that returns a node. Also, those nodes we want to access later, such as the root node, have an ID:

```scala
def render(item: Item): Tag = {
  val node     = html"""<div id="child"><span id="name"></span></div>"""
  val spanName = TagRef[tag.Span]("name")
  node.update(spanName := item.name)
}
```

The `set` method resolves our `Id` typeclass and appends our custom `ID` where needed:

```scala
val items  = List(Item(0, "Joe"), Item(1, "Jeff"))
val result = node.update(root.set(items, render))
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

Now, we can reference child nodes using the `apply` method of `TagRef`:

```scala
val child = TagRef[tag.Div]("child")
child(items.head)  // TagRef[tag.Child]("child0")
```

## Updating attributes
As our `TagRef` objects are typed, we can provide implicits for supported attributes.

```scala
val node = html"""<a id="lnk">GitHub</a>"""
node.update(
  NodeRef[tag.A]("lnk").href := "https://github.com/"
)
```

## Diffs
Diffs encapsulate changes. The operations you have seen before like `:=` (`set`), `replace` etc. are immutable objects describing the change you would like to perform.

So far, these changes were performed directly on the tree. However, for the JavaScript back end, we have an additional processing unit that can apply those changes to the DOM. This will be explained in the next chapter.

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
