package pl.metastack.metaweb

import pl.metastack.metaweb.tag.HTMLTag

package object dsl {
  implicit class HTMLTagExtensions(tag: HTMLTag) {
    /** Sets `style` to `display: none` if `state` is true, otherwise
      * sets `style` to `showDisplay` (empty string if None).
      */
    def hide(state: Boolean, showDisplay: Option[Display] = None): Unit =
      tag.style := (
        if (state) Display.None.property
        else showDisplay.map(_.property).getOrElse(""))

    /** Toggle `cssTags` depending on `state` */
    def css(state: Boolean, cssTags: String*): Unit = {
      tag.`class`.update { cur =>
        val currentTags = cur.split(' ')

        val updated =
          if (state) currentTags ++ cssTags
          else currentTags.diff(cssTags)

        updated.distinct.mkString(" ")
      }
    }
  }

  implicit class TagExtensions(tag: state.Tag) {
    def byClassOpt[T <: state.Tag](clazz: String): Option[T] = {
      if (tag.attribute("class").get != null &&
        tag.attribute("class").get.toString.split(' ').toSet.contains(clazz))
        Some(tag.asInstanceOf[T])
      else tag.children.collectFirst {
        case t: state.Tag if t.byClassOpt(clazz).isDefined => t.byClassOpt(clazz).get  // TODO optimise
      }
    }

    def byClass[T <: state.Tag](clazz: String): T = tag.byClassOpt(clazz).get
  }
}
