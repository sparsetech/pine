package pl.metastack.metaweb

trait Events {
  /* TODO Import events and interfaces from MDN */
  implicit class FormEvents(form: tag.form) {
    def onsubmit(f: Any => Unit) {
      form.bindEvent("submit", f)
    }
  }

  implicit class ButtonEvents(button: tag.button) {
    def onclick(f: Any => Unit) {
      button.bindEvent("click", f)
    }
  }
}
