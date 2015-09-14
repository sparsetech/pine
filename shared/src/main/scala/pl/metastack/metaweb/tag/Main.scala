package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The <em>HTML Main Element</em> (<strong>&lt;main&gt;</strong>) can be used as a container for the dominant contents of the document. The main content area consists of content that is directly related to, or expands upon the central topic of a section or the central functionality of an application. This content should be unique to the document, excluding any content that is repeated across a set of documents such as sidebars, navigation links, copyright information, site logos, and search forms (unless, of course, the document's main function is as a search form). Unlike <a href="/en-US/docs/Web/HTML/Element/article" title="The HTML Article Element (<article>) represents a self-contained composition in a document, page, application, or site, which is intended to be independently distributable or reusable, e.g., in syndication. This could be a forum post, a magazine or newspaper article, a blog entry, or any other independent item of content. Each <article> should be identified, typically by including a heading (h1-h6 element) as a child of the <article> element."><code>&lt;article&gt;</code></a> and <a href="/en-US/docs/Web/HTML/Element/section" title="The HTML Section Element (<section>) represents a generic section of a document, i.e., a thematic grouping of content, typically with a heading. Each <section> should be identified, typically by including a heading (<h1>-<h6> element) as a child of the <section> element."><code>&lt;section&gt;</code></a>, this element does not contribute to the document outline.
 */
class Main extends state.Tag("main") with HTMLTag {
}
