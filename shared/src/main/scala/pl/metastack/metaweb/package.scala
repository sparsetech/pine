package pl.metastack

package object metaweb
  extends View.Implicits
  with diff.render.Tree.Implicit
  with tree.render.HTML.Implicit
  with macros.InlineHtml.Implicit
  with macros.ExternalHtml.Method
  with PlatformSupport
