package object pine
  extends Node.Implicits
     with NodeRender.Implicits
     with macros.InlineHtml.Implicit
     with macros.ExternalHtml.Method
     with tag.Attributes
     with dsl.Imports {
  type SString = String with Singleton
}
