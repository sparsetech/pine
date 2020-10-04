# <img src="http://sparse.tech/icons/pine.svg" width="50%">
[![Build Status](https://travis-ci.org/sparsetech/pine.svg?branch=master)](https://travis-ci.org/sparsetech/pine)
[![Build Status](http://ci.sparse.tech/api/badges/sparsetech/pine/status.svg)](http://ci.sparse.tech/sparsetech/pine)
[![Maven Central](https://img.shields.io/maven-central/v/tech.sparse/pine_2.12.svg)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22tech.sparse%22%20AND%20a%3A%22pine_2.12%22)

Pine is a functional HTML5 and XML library for the Scala platform. It supports parsing, manipulating and rendering of HTML. Pine provides type-safe bindings for HTML5 generated from [MDN](https://developer.mozilla.org/en-US/docs/Web/HTML/Element). It implements an immutable tree which can be created directly from compile-time or runtime HTML/XML content. The tree may be manipulated and rendered back as HTML or as a browser node.

## Features
* Immutable and typed trees
* Type-safe bindings, generated from MDN
* Support for custom elements and attributes
* HTML5 and XML parser (recursive descent)
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
| Back end       | Scala versions   |
|:---------------|:-----------------|
| JVM            | 2.11, 2.12, 2.13 |
| JavaScript (1) | 2.11, 2.12, 2.13 |
| LLVM           | 2.11             |

* (1) Adds support for browser DOM

## Examples
```scala
import pine._

val url  = "http://github.com/"
val root = html"<a href=$url>GitHub</a>"

println(root.toHtml)  // <a href="http://github.com/">GitHub</a>
```

### JavaScript
```scala
import pine.dom._
println(root.toDom)  // [object HTMLAnchorElement]
```

## sbt
Pine makes use of a language extension called *literal types*, see [SIP-23](http://docs.scala-lang.org/sips/pending/42.type.html). For Scala 2.11 and 2.12, only [Typelevel Scala](https://github.com/typelevel/scala) implements this feature. However, it is available in Lightbend Scala from 2.13 onwards.

### 2.13 onwards
```scala
scalaVersion := "2.13.0"
libraryDependencies += scalaOrganization.value % "scala-reflect" % scalaVersion.value
```

### < 2.13
```scala
scalaVersion      := "2.12.4-bin-typelevel-4"  // or "2.11.11-bin-typelevel-4"
scalaOrganization := "org.typelevel"
scalacOptions     += "-Yliteral-types"

libraryDependencies += scalaOrganization.value % "scala-reflect" % scalaVersion.value
```

#### Scala.js settings
```scala
libraryDependencies := libraryDependencies.value.filterNot(_.name == "scalajs-compiler") 
addCompilerPlugin("org.scala-js" % "scalajs-compiler" % scalaJSVersion cross CrossVersion.patch)
```

#### Scala Native settings
```scala
libraryDependencies := libraryDependencies.value.filterNot(_.name == "nscplugin")
addCompilerPlugin("org.scala-native" % "nscplugin" % nativeVersion cross CrossVersion.patch)
```

### Dependencies
```scala
libraryDependencies += "tech.sparse" %%  "pine" % "0.1.3"  // JVM
libraryDependencies += "tech.sparse" %%% "pine" % "0.1.3"  // JavaScript, LLVM
```

## Links
* [Documentation](http://sparse.tech/docs/pine.html)
* [ScalaDoc](https://www.javadoc.io/doc/tech.sparse/pine_2.12/)

## Licence
Pine is licensed under the terms of the Apache v2.0 licence.

## Contributors
* Tim Nieradzik
* Matt Hicks
* Anatoliy Kmetyuk
* Keven Wright
