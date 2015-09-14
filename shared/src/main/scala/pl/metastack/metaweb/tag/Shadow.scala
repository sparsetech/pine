package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The <strong><a href="/en-US/docs/Web/HTML">HTML</a>&nbsp;<code>&lt;shadow&gt;</code></strong>&nbsp;element is used as a shadow DOM <a class="new glossaryLink" href="/en-US/docs/Glossary/insertion_point" title="The definition of that term (insertion point) has not been written yet; please consider contributing it!">insertion point</a>. You might use it if you have created multiple shadow roots under a shadow host. It is not useful in ordinary HTML. It is used with <a href="/en-US/docs/Web/Web_Components">Web Components</a>.
 */
class Shadow extends state.Tag("shadow") with HTMLTag {
}
