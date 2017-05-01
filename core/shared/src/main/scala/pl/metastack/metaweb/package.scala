package pl.metastack

package object metaweb
  extends Node.Implicits
     with NodeRender.Implicits
     with macros.InlineHtml.Implicit
     with macros.ExternalHtml.Method
     with tag.TagRefAttributes
     with dsl.Imports
