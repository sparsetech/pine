package object pine
  extends Node.Implicits
     with TagRender.Implicits
     with macros.InlineHtml.Implicit
     with macros.ExternalHtml.Method
     with tag.Attributes
     with dsl.Imports
