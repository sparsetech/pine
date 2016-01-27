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
      tag.find {
        case t: Tag =>
          val cls = tag.attribute("class").get
          cls != null && cls.toString.split(' ').toSet.contains(clazz)
        case _      => false
      }.map(_.asInstanceOf[T])
    }

    def byClass[T <: state.Tag](clazz: String): T = tag.byClassOpt(clazz).get
  }
}
