package pine

import org.scalacheck.{Gen, Properties}
import org.scalacheck.Prop.forAll
import pine.tag.HTMLTag

import scala.collection.mutable.ListBuffer

class NodePropSpec extends Properties("Node") {
  val attributeKeyChar = Gen.oneOf('a', '1', '-', '_', 'ä')
  val attributeKeyGen  = Gen.listOf(attributeKeyChar).map(_.mkString)
    .filter(_.nonEmpty)
    .filter(x => x.head.isLetter || x.head == '_')
  val attributeValueChar = Gen.oneOf('a', '1', 'ö', '&', ';', '\'', '"', '-', ' ')
  val attributeValueGen  = Gen.listOf(attributeValueChar).map(_.mkString)

  val attribute = for {
    k <- attributeKeyGen
    v <- attributeValueGen
  } yield (k, v)

  val textGen = for {
    s <- attributeValueGen
  } yield Text(s)

  def tagGen(sz: Int): Gen[Tag] = tagGen(sz, Seq.empty)

  def tagGen(sz: Int, parentTags: Seq[String]): Gen[Tag] =
    for {
      // TODO Consider nesting rules (tag.Input cannot have children)
      tag <- Gen.oneOf("a", "b", "div", "span").filter { t =>
        if (Set("a", "b").contains(t)) !parentTags.contains(t)
        else true
      }
      attributes <- Gen.mapOfN(sz / 3, attribute)

      n <- Gen.choose(sz / 5, sz / 2)
      children <- Gen.listOfN(n, sizedTree(sz / 2, parentTags ++ Seq(tag))).filter { l =>
        l.length <= 1 || !l.zip(l.tail).exists {
          // Two adjacent nodes cannot be text nodes
          case (left, right) =>
            left.isInstanceOf[Text] &&
              right.isInstanceOf[Text]
        }
      }.filter { l =>
        // Ignore empty text nodes
        !l.exists {
          case t: Text => t.text.isEmpty
          case _ => false
        }
      }
    } yield HTMLTag.fromTag(tag, attributes, children)

  def sizedTree(sz: Int): Gen[Node] = sizedTree(sz, Seq.empty)

  def sizedTree(sz: Int, parentTags: Seq[String]): Gen[Node] =
    if (sz <= 0) textGen
    else Gen.frequency((1, textGen), (3, tagGen(sz, parentTags)))

  val sized = Gen.choose(0, 20)

  def nodeGen: Gen[Node] = sized.flatMap(sizedTree)

  // Ignore text nodes that start with whitespaces on root level
  def rootNodeGen: Gen[Node] = nodeGen.filter {
    case Text(t) => !t.startsWith(" ")
    case _ => true
  }

  def fun1: Node => Boolean = {
    case n: Tag => true
    case _ => false
  }

  def fun2: Node => Boolean = {
    case n: Text => true
    case _ => false
  }

  def filterFunGen: Gen[Node => Boolean] = Gen.oneOf(fun1, fun2)

  property("toHtml") = forAll(rootNodeGen) { node: Node =>
    HtmlParser.fromString(node.toHtml) == node
  }

  def myFilter(node: Tag, f: Node => Boolean): Seq[Node] = {
    val collected = ListBuffer.empty[Node]
    def iter(node: Node): Unit = {
      if (f(node)) collected += node
      node match {
        case x: Tag => x.children.foreach(iter)
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

  property("toText") = forAll(sized.flatMap(tagGen)) { tag: Tag =>
    val text = tag.toText
    tag
      .filter(_.isInstanceOf[Text])
      .forall(x => text.contains(x.asInstanceOf[Text].text.trim.replaceAll("\\s+", " ")))
  }

  /*
    property("toText (DOM)") = forAll(nodeGen) { node: Node =>
      node.toText == node.toDom.textContent
    }
  }*/
}
