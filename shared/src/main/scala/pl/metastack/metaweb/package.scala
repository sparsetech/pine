package pl.metastack

package object metaweb
  extends View.Implicits
  with tag.NodeRefAttributes
  with diff.render.Tree.Implicit
  with tree.render.HTML.Implicit
  with macros.InlineHtml.Implicit
  with macros.ExternalHtml.Method
  with PlatformSupport
