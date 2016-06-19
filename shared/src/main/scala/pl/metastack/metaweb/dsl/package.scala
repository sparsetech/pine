package pl.metastack.metaweb

import pl.metastack.metaweb.diff.{Diff, NodeRef}
import pl.metastack.metaweb.tag.HTMLTag

package object dsl {
  implicit class NodeRefDSLExtensions(nodeRef: NodeRef[HTMLTag]) {
    /** Sets `style` to `display: none` if `state` is true, otherwise
      * sets `style` to `showDisplay` (empty string if None).
      */
    def hide(state: Boolean, showDisplay: Option[Display] = None): Diff =
      nodeRef.style := (
        if (state) Display.None.property
        else showDisplay.map(_.property).getOrElse(""))
  }
}
