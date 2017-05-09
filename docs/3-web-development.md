# Web development
Pine may be used for web development. You can use it in various architectures, for example:

* Client-side rendered pages (SPA, single-page applications)
* Server-side rendered pages without client logic
* Server-side rendered pages with client logic
* Server-side rendered pages with client logic and client-side rendering

_Server_ refers to either the JVM or LLVM back end, whereas _client_ refers to JavaScript.

We will add sample projects for some of the architectures to let you get started quickly.

## Architectures
Pine advocates web development in the FP style. You are advised to split your HTML rendering into composable functions and share the code across platforms. Pine does not provide any abstractions for pages or components to maximise its use cases.

The fourth architecture is the most sophisticated and allows for the best user experience. For this, you have to define a shared protocol for the data layer as well as shared code for populating the templates. On the client, you evaluate which page the server rendered and then attach the event handlers. Also, when the user clicks an internal page link, instead of redirecting to it, you can use the shared template layer to perform the rendering directly in the browser.

This architecture has the following life cycle for a page `p`, which you could define in terms of four functions:

1. `node(p)`: Creates an immutable tree node (`shared` project)
2. `populate(p)`: Populates the tree with content (`shared` project)
3. `attach(p)`: Attach event handlers, only called in JavaScript (`js` project)
4. `detach(p)`: Detach event handlers, only called in JavaScript (`js` project)

## Access DOM node
```scala
val text = TagRef[tag.Div]("text")
DOM.get(text)  // Returns browser node, of type org.scalajs.dom.html.Div
```

## Diffs
Previously, we used `update` to perform the changes on the nodes. To carry out the changes in the DOM, we have to use `DOM.render`:

```scala
DOM.render(text := "Hello, world!")
```

As an extension to regular server-side diffs, there are DOM-specific diffs for events that need to be rendered using `renderDom`:

```scala
val btnRemove = TagRef[tag.Button]("remove")
DOM.renderDom(
  btnRemove.click := println("Remove click")
)
```

See also `dom.Window` and `dom.Document` for global events.

## IntelliJ support
When loading the sample projects in IntelliJ, some references in the `shared` module may not be resolved properly. This happens because IntelliJ doesn't add a dependency from platform-specific modules (i.e. `jvm` and `js`) to the `shared` module.

To fix this, please go to `File -> Project Structure... -> Modules -> project-Sources -> Dependencies`. Then, add a module dependency to `projectJVM`/`projectNative` and `projectJS`.
