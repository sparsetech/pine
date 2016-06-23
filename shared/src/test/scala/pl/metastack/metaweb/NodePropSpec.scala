package pl.metastack.metaweb

import org.scalacheck.{Gen, Properties}
import org.scalacheck.Prop.forAll

class NodePropSpec extends Properties("Node") {
  val attributeKeyChar = Gen.const('a', '1', '-', '_', 'ä')
  val attributeKeyGen  = Gen.listOf(attributeKeyChar).map(_.mkString)
    .filter(_.nonEmpty)
    .filter(x => x.head.isLetter || x.head == '_')
  val attributeValueChar = Gen.oneOf('a', '1', 'ö', '&', ';', '\'', '"', '-')
  val attributeValueGen  = Gen.listOf(attributeValueChar).map(_.mkString)

  val attribute = for {
    k <- attributeKeyGen
    v <- attributeValueGen
  } yield (k, v)

  val textGen = for {
    s <- attributeValueGen
  } yield tree.Text(s)

  val tagGen =
    Gen.sized { size =>
      for {
        // TODO Consider nesting rules (tag.Input cannot have children)
        tag <- Gen.oneOf(tag.A, tag.B, tag.Div, tag.Span)
        attributes <- Gen.mapOf(attribute)

        s <- Gen.choose(0, size)
        g = Gen.resize(size / (s + 1), nodeGen)

        children <- Gen.listOfN(s, g)
          .filter { l =>
            l.length <= 1 || !l.zip(l.tail).exists {
              // Two adjacent nodes cannot be text nodes
              case (left, right) =>
                left.isInstanceOf[tree.Text] &&
                  right.isInstanceOf[tree.Text]
            }
          }.filter { l =>
            // Ignore empty text nodes
            !l.exists {
              case t: tree.Text => t.text.isEmpty
              case _ => false
            }
          }
      } yield tag(attributes, children)
    }

  def nodeGen: Gen[tree.Node] = Gen.oneOf(textGen, tagGen)

  property("toHtml") = forAll(nodeGen) { node: tree.Node =>
    HtmlParser.fromString(node.toHtml) == node
  }
}
