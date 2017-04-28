package pl.metastack.metaweb.diff.render

import pl.metastack.metaweb._
import pl.metastack.metaweb.diff._

object Tree {
  def render(node: tree.Node, diff: Diff): tree.Node =
    node match {
      case text: tree.Text => text

      case tag: tree.Tag =>
        diff match {
          case Diff.SetAttribute(ref, attribute, value) if ref.matches(tag) =>
            tag.copy(attributes = tag.attributes + (attribute.name -> value))

          case Diff.UpdateAttribute(ref, attribute, f) if ref.matches(tag) =>
            val attrs =
              if (HtmlHelpers.BooleanAttributes.contains(attribute.name)) {
                val fBoolean = f.asInstanceOf[Boolean => Boolean]
                if (fBoolean(tag.attributes.contains(attribute.name)))
                  tag.attributes + (attribute.name -> "")
                else
                  tag.attributes - attribute.name
              } else {
                val fString = f.asInstanceOf[Option[String] => Option[String]]
                val updated = fString(tag.attributes.get(attribute.name)
                  .asInstanceOf[Option[String]])
                updated match {
                  case None    => tag.attributes - attribute.name
                  case Some(s) => tag.attributes + (attribute.name -> s)
                }
              }

            tag.copy(attributes = attrs)

          case Diff.RemoveAttribute(ref, attribute) if ref.matches(tag) =>
            tag.copy(attributes = tag.attributes - attribute.name)

          case Diff.PrependChild(ref, child) if ref.matches(tag) =>
            tag.copy(children = child +: tag.children)

          case Diff.AppendChild(ref, child) if ref.matches(tag) =>
            tag.copy(children = tag.children :+ child)

          case Diff.Replace(ref, replacement) if ref.matches(tag) =>
            replacement

          case Diff.ReplaceChildren(ref, children) if ref.matches(tag) =>
            tag.copy(children = children)

          case Diff.RemoveChild(ref)
            if tag.children.collect { case t: tree.Tag => t }
                           .exists(c => ref.matches(c)) =>
            val child = tag.children
              .collect { case t: tree.Tag => t }
              .find(c => ref.matches(c)).get

            tag.copy(children = tag.children.diff(Seq(child)))

          case _ =>
            val children = tag.children.map(render(_, diff))
            tag.copy(children = children)
        }
    }
}
