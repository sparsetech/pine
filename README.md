# MetaWeb
[![Build Status](https://travis-ci.org/MetaStack-pl/MetaWeb.svg)](https://travis-ci.org/MetaStack-pl/MetaWeb)

MetaWeb provides reactive Scala and Scala.js bindings for HTML5.

We implemented the DOM as two trees:

- `tree`: This tree is immutable and non-reactive (no changes are triggered when attributes are updated). Every node has a method `state` to obtain a stateful version that can be modified.
- `state`: This tree is mutable and reactive. Value updates will trigger changes. Two-way binding is supported, so that value updates in the rendered tree (i.e. browser DOM) will be propagated back.

`tree` and `state` nodes can be used interchangeably. This allows for more fine-grained control as `state` nodes have a slightly higher memory/performance footprint and cannot be reused.

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
