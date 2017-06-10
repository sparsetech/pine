# Web development
Pine may be used for web development. You can use it in various architectures, for example:

* Client-side rendered pages (SPA, single-page applications)
* Server-side rendered pages without client logic
* Server-side rendered pages with client logic
* Server-side rendered pages with client logic and client-side rendering

Please refer to our [sample project](https://github.com/sparsetech/pine-example) which implements the last architecture.

_Server_ refers to either the JVM or LLVM back end, whereas _client_ refers to JavaScript.

All examples require a prior `import pine.dom._`.

## Architectures
Pine advocates web development in the FP style. You are advised to split your HTML rendering into composable functions and share the code across platforms. Pine does not provide any abstractions for pages or components to maximise its use cases.

The fourth architecture is the most sophisticated and allows for the best user experience. For this, you have to define a shared protocol for the data layer as well as shared code for populating the templates. On the client, you evaluate which page the server rendered and then attach the event handlers. Also, when the user clicks an internal page link, instead of redirecting to it, you can use the shared template layer to perform the rendering directly in the browser.

This architecture has the following life cycle for a page `p`, which you could define in terms of four functions:

1. `node(p)`: Creates an immutable tree node (`shared` project)
2. `populate(p)`: Populates the tree with content (`shared` project)
3. `attach(p)`: Attach event handlers, only called in JavaScript (`js` project)
4. `detach(p)`: Detach event handlers, only called in JavaScript (`js` project)

## Render JavaScript node
To render a Pine node as a JavaScript node, use the function `toDom`:

```scala
val div    = html"""<div><input type="text" /><input type="test" /></div>""".as[tag.Div]
val jsNode = div.toDom  // dom.html.Div
```

`toDom` returns the correct JavaScript type depending on your node type:

```scala
Text("test").toDom  // dom.raw.Text
```

You need to add the JavaScript node manually to the DOM to be able to access it via a `TagRef`:

```scala
dom.document.body.appendChild(jsNode)
```

## Access DOM node
Use `dom` on a `TagRef` to access the underlying DOM node:

```scala
val text = TagRef[tag.Div]("text")
text.dom  // Returns browser node, of type org.scalajs.dom.html.Div
```

If you would like to retrieve all matching nodes, use `each` and `domAll` instead:

```scala
val input = TagRef[tag.Input].each
input.domAll  // List[org.scalajs.dom.html.Input]
```

## Access DOM attribute
```scala
val text = TagRef[tag.Div]("text")
text.`class`.get  // Retrieves 'class' attribute from DOM node, of type Option[String]
```

Note that in JavaScript, DOM attributes may not represent the current state of a node. If this is the case, you can retrieve the value via `dom`:

```scala
val name = TagRef[tag.Input]("name")
name.value.get  // Returns value the DOM node was initialised with
name.dom.value  // Returns current value
```

## Diffs
Previously, we used `update` to perform the changes on the nodes. To carry out the changes in the DOM, we have to use `DOM.render`:

```scala
DOM.render(implicit ctx => text := "Hello, world!")
```

### Events
As an extension to content updates, you can set event handlers. In JavaScript projects, a `TagRef` exposes all event handlers which the underlying DOM element supports. These changes are side-effecting and therefore do not require a rendering context. The motivation is that event handlers do not change the visual page content. Therefore, instantiating `Diff`s and performing a batch execution would be redundant.

```scala
val btnRemove = TagRef[tag.Button]("remove")
btnRemove.click := println("Remove click")
```

It is possible to attach an event to all matching elements using `each`:

```scala
val input = TagRef[tag.Div].each
input.click := println("Any div was clicked")
```

See also `dom.Window` and `dom.Document` for global events.

## Troubleshooting
### Dangling rendering context
If you encounter a *Dangling rendering context* exception, this may be reminiscent of a dangling pointer in C. The underlying problem is the same: You set up a rendering context passing it a function, which adds diffs to the context. After this function returns, the diffs are processed. Now, the rendering context should not be used anymore.

Most likely an asynchronous event took place which re-used the implicit context from the scope and added a diff to it. One such example is:

```scala
DOM.render { implicit ctx =>
  button.click := box.hide(true)
}
```

When the button was clicked, `hide` will re-use `ctx`. The following fixes the situation:

```scala
button.click := DOM.render(implicit ctx => box.hide(true))
```

You can safely nest multiple `DOM.render` blocks. The inner-most block will always use the context from the immediate scope. It is advisable to limit the rendering context only to functions that change the DOM and take an implicit context. This could prevent problems as above since an implicit context would not have been found in the first place.

### IntelliJ support
When loading the sample projects in IntelliJ, some references in the `shared` module may not be resolved properly. This happens because IntelliJ doesn't add a dependency from platform-specific modules (i.e. `jvm` and `js`) to the `shared` module.

To fix this, please go to `File -> Project Structure... -> Modules -> project-Sources -> Dependencies`. Then, add a module dependency to `projectJVM`/`projectNative` and `projectJS`.
