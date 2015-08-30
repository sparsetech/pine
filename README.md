# MetaWeb
[![Build Status](https://travis-ci.org/MetaStack-pl/MetaWeb.svg)](https://travis-ci.org/MetaStack-pl/MetaWeb)

MetaWeb provides Scala and Scala.js bindings for HTML5.

It implements a DOM as an immutable tree. This tree can be transformed into a stateful tree. There are three different state trees:

- Zero-way: Initially just a copy of the immutable tree. Attributes and children can be updated, but don't trigger changes.
- One-way: Value updates will trigger changes.
- Two-way: Value updates in the rendered tree (browser DOM e.g.) will be propagated back.

This allows for more fine-grained control as one-way and two-way binding have a slightly higher memory and performance footprint.

MetaWeb has two rendering methods:

- HTML: ``toHtml`` is defined on every state node and will return a snapshot of the state as a string
- DOM: ``toDom`` is only available in Scala.js; it renders a node in the browser DOM

HTML code is parsed during compile-time and then translated to an immutable or stateful tree. This reduces any runtime overhead. HTML can be specified inline or loaded from external files.

Additionally, we generate type-safe bindings for HTML directly from [MDN](https://developer.mozilla.org/en-US/docs/Web/HTML/Element).

This project is still WIP.

## License
MetaWeb is licensed under the terms of the Apache v2.0 license.

## Authors
* Tim Nieradzik
* Matt Hicks
