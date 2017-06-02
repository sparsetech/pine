# Pine
[![Build Status](https://travis-ci.org/sparsetech/pine.svg)](https://travis-ci.org/sparsetech/pine)

Pine is a functional HTML5 library for the Scala platform. It supports parsing, manipulating and rendering of HTML. Pine provides type-safe bindings for HTML5 generated from [MDN](https://developer.mozilla.org/en-US/docs/Web/HTML/Element). It implements an immutable tree which can be created directly from compile-time or runtime HTML content. The tree may be manipulated and rendered back as HTML or as a browser node.

## Features
* Immutable and typed trees
* Type-safe bindings, generated from MDN
* HTML parser (recursive descent)
* Macros for compile-time HTML string/file parsing
* Tree manipulation
* Rendering as HTML strings
* DSL for common operations
* Unit and property-based tests
* Few dependencies

### JavaScript backend
* Rendering as DOM nodes
* Updating nodes in DOM
* DSL for attaching/detaching events

## Compatibility
| Back end   | Scala versions | Remarks             |
|:-----------|:---------------|:--------------------|
| JVM        | 2.11, 2.12     | Fully supported     |
| JavaScript | 2.11, 2.12     | Fully supported (1) |
| LLVM       | 2.11           | Experimental (2)    |

* (1) Adds support for browser DOM
* (2) Presently, Scala Native does not support running ScalaTest/ScalaCheck test suites

## Example
```scala
import pine._

val url  = "http://github.com/"
val root = html"<a href=$url>GitHub</a>"

println(root.toHtml)  // <a href="http://github.com/">GitHub</a>
```

## Dependency
```scala
libraryDependencies += "tech.sparse" %%  "pine" % "0.1.0"  // JVM
libraryDependencies += "tech.sparse" %%% "pine" % "0.1.0"  // JavaScript, LLVM
```

## Links
* [Documentation](docs/)
* [ScalaDoc](https://www.javadoc.io/doc/tech.sparse/pine_2.12/)

## Licence
Pine is licensed under the terms of the Apache v2.0 licence.

## Contributors
* Tim Nieradzik
* Matt Hicks
* Anatoliy Kmetyuk
