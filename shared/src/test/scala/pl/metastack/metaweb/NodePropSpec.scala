package pl.metastack.metaweb

import org.scalacheck.{Gen, Properties}
import org.scalacheck.Prop.forAll

import scala.collection.mutable.ListBuffer

class NodePropSpec extends Properties("Node") {
  val attributeKeyChar = Gen.oneOf('a', '1', '-', '_', 'ä')
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

  def tagGen(sz: Int) =
    for {
      // TODO Consider nesting rules (tag.Input cannot have children)
      tag <- Gen.oneOf(tag.A, tag.B, tag.Div, tag.Span)
      attributes <- Gen.mapOfN(sz / 3, attribute)

      n <- Gen.choose(sz / 5, sz / 2)
      children <- Gen.listOfN(n, sizedTree(sz / 2)).filter { l =>
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

  def sizedTree(sz: Int): Gen[tree.Node] =
    if (sz <= 0) textGen
    else Gen.frequency((1, textGen), (3, tagGen(sz)))

  val sized = Gen.choose(0, 20)

  def nodeGen: Gen[tree.Node] = sized.flatMap(sizedTree)

  def fun1: tree.Node => Boolean = {
    case n: tree.Tag => true
    case _ => false
  }

  def fun2: tree.Node => Boolean = {
    case n: tree.Text => true
    case _ => false
  }

  def filterFunGen: Gen[tree.Node => Boolean] = Gen.oneOf(fun1, fun2)

  property("toHtml") = forAll(nodeGen) { node: tree.Node =>
    HtmlParser.fromString(node.toHtml) == node
  }

  def myFilter(node: tree.Tag, f: tree.Node => Boolean): Seq[tree.Node] = {
    val collected = ListBuffer.empty[tree.Node]
    def iter(node: tree.Node): Unit = {
      if (f(node)) collected += node
      node match {
        case x: tree.Tag => x.children.foreach(iter)
        case _ =>
      }
    }
    node.children.foreach(iter)
    collected
  }

  property("filter (forall)") = forAll(sized.flatMap(tagGen), filterFunGen) { (tag, f) =>
    tag.filter(f).forall(f)
  }

  property("filter (reference implementation)") = forAll(sized.flatMap(tagGen), filterFunGen) { (tag, f) =>
    tag.filter(f) == myFilter(tag, f)
  }
}
