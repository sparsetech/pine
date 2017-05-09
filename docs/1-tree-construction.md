# Tree construction
Unless otherwise stated, all code samples require a prior `import pine._`.

## DSL
Pine offers a DSL that allows to create trees in terms of immutable objects:

```scala
val a = tag.A()
  .href("http://github.com/")
  .set(Text("GitHub"))

a.toHtml  // <a href="http://github.com/">GitHub</a>
```

The bindings are derived from the MDN documentation. For all attributes, we provide getters and setters. `set()` replaces the children of a node.

## Macros
Pine defines a couple of compile-time macros for increased comfort or performance.

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
Pine provides an HTML parser backed by the DOM in JavaScript, but uses its own parser for other back ends.

```scala
val html = """<div id="a"><span>42</span></div>"""
val node = HtmlParser.fromString(html)
node.toHtml == html  // true
```

HTML code is parsed during compile-time and then translated to an immutable tree. This reduces any runtime overhead. HTML can be specified inline or loaded from external files.

## Rendering
A node defines two rendering methods:

- **HTML:** `toHtml` is defined on every node and will return the tree as a string
- **DOM:** `toDom` is only available in JavaScript; it renders the tree as a browser node, which can be inserted into the DOM
