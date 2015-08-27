package pl.metastack.metaweb

trait Events {
  /* TODO Import events and interfaces from MDN */
  implicit class Events(tag: state.Tag) {
    def onsubmit(f: Any => Unit) {
      tag.setEvent("submit", f)
    }

    def onclick(f: Any => Unit) {
      tag.setEvent("click", f)
    }
  }
}
