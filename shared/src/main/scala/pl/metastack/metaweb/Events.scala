package pl.metastack.metaweb

trait Events {
  /* TODO Import events and interfaces from MDN */
  implicit class FormEvents(form: tag.mutable.form) {
    def onsubmit(f: Any => Unit) {
      form.setEvent("submit", f)
    }
  }

  implicit class ButtonEvents(button: tag.mutable.button) {
    def onclick(f: Any => Unit) {
      button.setEvent("click", f)
    }
  }
}
