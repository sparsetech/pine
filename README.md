# MetaWeb
[![Build Status](https://travis-ci.org/MetaStack-pl/MetaWeb.svg)](https://travis-ci.org/MetaStack-pl/MetaWeb)

MetaWeb is a functional low-level web framework for Scala and Scala.js.

It provides type-safe bindings for HTML5 generated from [MDN](https://developer.mozilla.org/en-US/docs/Web/HTML/Element). MetaWeb implements an immutable document tree that can be materialised as DOM nodes or HTML. Trees can be created from statically or dynamically loaded HTML content.

MetaWeb advocates web development in an FP style and tries to reduce state and side-effects to a minimum. Pages are split into reusable components, called _views_. A view models changes of nodes in terms of _diffs_ that are interpreted by a separate processing unit. This allows us to render a pre-populated version of the page (i.e. server-side rendering), such that upon browser load only the event handlers need to be attached and the diffs will get applied directly to the DOM.

Please refer to the [example application](https://github.com/MetaStack-pl/MetaWeb/tree/master/example) for an introduction.

## sbt
```scala
libraryDependencies += "pl.metastack" %%  "metaweb" % "0.2.0"  // Scala
libraryDependencies += "pl.metastack" %%% "metaweb" % "0.2.0"  // Scala.js
```

## Example
An excerpt from the example application:

```scala
import pl.metastack.metaweb._
import pl.metastack.metaweb.dsl._
import pl.metastack.metaweb.diff._
import pl.metastack.metaweb.macros.Js

class ItemView(book: BookListItem) extends View {
  var hidden = true

  override implicit def id = ViewId(book.id.toString)

  val root = NodeRef[tag.Li]("book")
  val title = NodeRef[tag.A]("title")
  val btnRemove = NodeRef[tag.Button]("remove")
  val btnRenameToggle = NodeRef[tag.Button]("rename-toggle")
  val divRenameBox = NodeRef[tag.Div]("rename-box")
  val txtRename = NodeRef[tag.Input]("rename-text")
  val btnRenameSave = NodeRef[tag.Button]("rename-save")

  override def node(): Future[tree.Node] =
    Templates.Books.map(_.byId[tree.Tag]("book"))

  override def populate(): Diff =
    Diff(
      title := book.title,
      title.href := s"/book/${book.id}",
      txtRename.value := book.title,
      divRenameBox.hide(hidden)
    )

  @Js override def register(): Diff =
    btnRemove.click.subscribe(_ => destroy()) :+
    btnRenameToggle.click.subscribe { _ =>
      hidden = !hidden
      divRenameBox.hide(hidden) :+ Diff.Effect {
        if (!hidden) txtRename.dom.focus()
      }
    } :+
    txtRename.onEnter(rename) :+
    btnRenameSave.click.subscribe(_ => rename(txtRename.dom.value))

  @Js def rename(value: String): Diff = {
    hidden = true
    Diff(
      title := value,
      divRenameBox.hide(hidden)
    )
  }
}
```

## Tree
MetaWeb offers a tree allowing to create documents defined in terms of immutable objects:

```scala
val a = tag.A()
  .href("http://github.com/")
  .set(tree.Text("GitHub"))

a.toHtml  // <a href="http://github.com/">GitHub</a>
```

The bindings are derived from the MDN documentation. For all attributes, we provide getters and setters. `set()` replaces the children of a node.

## Macros
MetaWeb defines several compile-time macros for increased comfort or performance.

### Js
The `@Js` annotation replaces the body of methods by a no-op diff when compiled for JVM. If applied to objects, classes, traits, the body will be removed. If applied to variables, the declaration will be removed entirely.

For example, `@Js` is used in the view for the `register()` method. If the method is overridden, it will invariably need JavaScript functionality which would not be available in the JVM.

This annotation effectively allows to define the logic of a view and its JavaScript side-effects within the same file without resorting to [Scala.js' cross-project structure](https://www.scala-js.org/doc/project/cross-build.html).

### Inline HTML
Inline HTML can include placeholders referring to Scala values:

```scala
val url   = "http://github.com/"
val title = "GitHub"
val root  = html"""<a href=$url>$title</a>"""

root.toHtml  // <a href="http://github.com/">GitHub</a>
```

A placeholder may also reference `Seq[Node]` values:

```scala
val spans = Seq(
  html"<span>test</span>",
  html"<span>test2</span>"
)

val div = html"<div>$spans</div>"
div.toHtml  // <div><span>test</span><span>test2</span></div>
```

### External HTML
For loading external HTML files during compile-time, a constant file name must be passed:

```scala
val tpl = html("test.html")
tpl.toHtml  // <html>...</html>
```

## Runtime HTML parser
MetaWeb provides an HTML parser backed by the DOM in Scala.js, but uses [scala-xml](https://github.com/scala/scala-xml) for the JVM.

```scala
val html = """<div id="a"><span>42</span></div>"""
val node = HtmlParser.fromString(html)
node.toHtml == html  // true
```

HTML code is parsed during compile-time and then translated to an immutable or stateful tree. This reduces any runtime overhead. HTML can be specified inline or loaded from external files.

## Diffs
Diffs encapsulate changes and need to be returned from most `View` functions like `populate()` or `register()`. Diffs are rendered by an external processing unit.

We define two types of diffs.

_Execution flow:_
* **Noop:** Don't perform an action
* **Sequence:** Define a sequential execution of diffs
* **Effect:** Pass function that performs side-effects, used for JavaScript functionality
* **Map:** Perform action and continue with another diff
* **Async:** Perform action asynchronously

_Node updates:_
* **SetAttribute:** Set attribute on a node
* **RemoveAttribute:** Remove attribute from a node
* **ReplaceChildren:** Replace children of a node
* **PrependChild:** Prepends child to a node
* **AppendChild:** Appends child to a node
* **RemoveChild:** Removes a child

### Examples
- *Replacing children*
```scala
title := book.title
```

- *Setting attributes*
```scala
title.href := s"/book/${book.id}"
```

- *Combining diffs:* There are two ways of creating a sequence of diffs. `Diff()` can take one or more diffs.

```
Diff(
  title := book.title,
  title.href := s"/book/${book.id}"
)
```

- *Combining diffs:* The `:+` operator may be more convenient than `Diff()` in some cases.
```scala
btnRemove.click.subscribe(_ => destroy()) :+
btnRenameToggle.click.subscribe { _ =>
```

## Views
A view is defined by this simplified trait:

```scala
trait View {
  val root: NodeRef[tree.Tag]
  implicit def id: ViewId

  def node(): Future[tree.Node]
  def populate(): Diff
  def register(): Diff
  def destroy(): Diff
}
```

Every view must must be identifiable such that we can remove it in `destroy()`. Therefore, `root` must reference the ID of the root node.

Furthermore, there may be several instances of a view. As elements have a global ID in the DOM, we need to give each view a unique name. This is done by overriding `id`, which will be used as the suffix for all ID attributes in the tree. The ID will also be used to re-identify elements on the client that have been rendered on the server.

### Life cycle
A view has the following life cycle:

1. `node()`: Creates an immutable tree node
2. `populate()`: Populates the tree with content
3. `register()`: Registers event handlers, only called in JavaScript
4. `destroy()`: Removes node from the document tree

## DSL
To facilitate interaction with nodes, MetaWeb provides helper methods in the `dsl` package object:

```scala
import pl.metastack.metaweb.dsl._

val div: NodeRef[tag.Div] =  ...
div.hide(true)  // Sets `style` attribute to hide the element in the browser
```

## Rendering
### Nodes
A node defines two rendering methods:

- **HTML:** `toHtml` is defined on every node and will return the tree as a string
- **DOM:** `toDom` is only available in Scala.js; it renders a node in the browser DOM

### Views
A view defines the following rendering methods:

- `toTree: Future[tree.Node]` Populates the view and returns its tree as a snapshot
- `toHtml: Future[String]` Same as `toTree`, but returns snapshot as HTML
- `toDom: Future[dom.Node]` Only available in Scala.js; populates the view and registers event handlers, returns a node that can be inserted into the body of the DOM

## Links
* [ScalaDoc](https://www.javadoc.io/doc/pl.metastack/metaweb_2.11/)

## License
MetaWeb is licensed under the terms of the Apache v2.0 license.

## Authors
* Tim Nieradzik
* Matt Hicks
