package pine.dsl

import pine._

trait Imports {
  implicit class TagRefDSLExtensions[T <: Singleton](tagRef: TagRef[T]) {
    /** Toggle `cssTags` depending on `state` */
    @deprecated("Use `class`.state() instead")
    def css(state: Boolean, cssTags: String*)
           (implicit renderCtx: RenderContext): Unit =
      cssTags.foreach(tagRef.`class`.state(state, _))

    /** Sets `style` to `display: none` if `state` is true, otherwise
      * sets `style` to `showDisplay` (empty string if None).
      */
    def hide(state: Boolean, showDisplay: Option[Display] = None)
            (implicit renderCtx: RenderContext): Unit =
      tagRef.style := (
        if (state) Display.None.property
        else showDisplay.map(_.property).getOrElse(""))
  }
}
