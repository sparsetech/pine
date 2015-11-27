package pl.metastack.metaweb.dsl

import pl.metastack.metaweb.tag.HTMLTag

object Tags {
  implicit class HTMLTagExtensions(tag: HTMLTag) {
    def show(state: Boolean, cssTags: String*): Unit = {
      tag.`class`.update { cur =>
        val currentTags = cur.split(' ')

        val updated =
          if (state) currentTags ++ cssTags
          else currentTags.diff(cssTags)

        updated.distinct.mkString(" ")
      }
    }
  }
}
