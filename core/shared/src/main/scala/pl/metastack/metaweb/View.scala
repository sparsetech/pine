package pl.metastack.metaweb

object View {
  trait Implicits {
    implicit def NumericToTree[T](value: T)
                                 (implicit num: Numeric[T]): tree.Node =
      tree.Text(value.toString)

    implicit def BooleanToTree(value: Boolean): tree.Node =
      tree.Text(value.toString)

    implicit def StringToTree(value: String): tree.Node = tree.Text(value)
  }
}
