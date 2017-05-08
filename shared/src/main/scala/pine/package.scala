package object pine
  extends Node.Implicits
     with NodeRender.Implicits
     with macros.InlineHtml.Implicit
     with macros.ExternalHtml.Method
     with tag.TagRefAttributes
     with dsl.Imports
