package pl.metastack

package object metaweb
  extends View.Implicits
  with tag.NodeRefAttributes
  with diff.render.Tree.Implicit
  with tree.render.HTML.Implicit
  with tree.render.Text.Implicit
  with macros.InlineHtml.Implicit
  with macros.ExternalHtml.Method
  with PlatformSupport
