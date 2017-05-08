package pl.metastack.metaweb.dsl

import pl.metastack.metaweb._
import pl.metastack.metaweb.tag.HTMLTag

trait Imports {
  implicit class TagRefDSLExtensions(tagRef: TagRef[HTMLTag]) {
    /** Toggle `cssTags` depending on `state` */
    def css(state: Boolean, cssTags: String*): Diff =
      tagRef.`class`.update {
        case None      => if (state) Some(cssTags.mkString(" ")) else None
        case Some(cur) =>
          val currentTags = cur.split(' ')

          val updated =
            if (state) currentTags ++ cssTags
            else       currentTags.diff(cssTags)

          Some(updated.distinct.mkString(" "))
      }

    /** Sets `style` to `display: none` if `state` is true, otherwise
      * sets `style` to `showDisplay` (empty string if None).
      */
    def hide(state: Boolean, showDisplay: Option[Display] = None): Diff =
      tagRef.style := (
        if (state) Display.None.property
        else showDisplay.map(_.property).getOrElse(""))
  }
}
