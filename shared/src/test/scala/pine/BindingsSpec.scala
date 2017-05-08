package pine

/*
import minitest._

object BindingsSpec extends SimpleTestSuite {
  test("Binding `href` on `a` tags") {
    val a = tag.A()
    a.href := "http://example.com/"

    assertEquals(a.toHtml, """<a href="http://example.com/"></a>""")
  }

  test("Don't escape <script>") {
    val script = tag.Script()
    script += """$("a")"""

    assertEquals(script.toHtml, """<script>$("a")</script>""")
  }

  test("one-way binding tree") {
    val url = Var("http://github.com/")
    val title = Var("GitHub")

    val root = html"""<a></a>"""
    root.attribute("href").asInstanceOf[Var[String]].subscribe(url)
    root.subscribeChildren(Buffer({
      val s = new state.Text
      s.listen(title)
      s
    }))

    assertEquals(root.toHtml, """<a href="http://github.com/">GitHub</a>""")

    url := "http://google.com/"
    assertEquals(root.attribute("href").get, "http://google.com/")
    assertEquals(root.toHtml, """<a href="http://google.com/">GitHub</a>""")

    root.clearChildren()
    assertEquals(root.toHtml, """<a href="http://google.com/"></a>""")
  }

  test("Check attribute and content updates") {
    val url = Var("http://github.com/")
    val title = Var("GitHub")

    val root = html"""<a></a>"""
    assertEquals(root.toHtml, """<a></a>""")

    val href = root.attribute("href").asInstanceOf[StateChannel[String]]
    assertEquals(root.toHtml, """<a href=""></a>""")

    href.subscribe(url)
    root := {
      val s = new state.Text
      s.listen(title)
      s
    }

    assertEquals(root.toHtml, """<a href="http://github.com/">GitHub</a>""")

    url := "http://google.com/"
    title := "Google"
    assertEquals(root.toHtml, """<a href="http://google.com/">Google</a>""")
  }

  test("Bind list") {
    val list = html"""<div id="list"></div>"""

    list.subscribeChildren(Buffer("a", "b", "c").map { i =>
      val title = s"Title $i"
      val subtitle = s"Subtitle $i"
      html"""<div><div>$title</div><div>$subtitle</div></div>"""
    })

    assertEquals(list.children.size, 3)
    assertEquals(list.children.last.toHtml,
      """<div><div>Title c</div><div>Subtitle c</div></div>""")
  }

  test("Inline event handler") {
    var clicked = 0
    val btn = html"""<button onclick="${(_: Any) => clicked += 1}">Test</button>"""

    btn.click()
    assertEquals(clicked, 1)
  }

  test("Inline event handler (2)") {
    var eventTriggered = 0
    val input = html"""<input type="text" onfocus=${eventTriggered += 1} />"""

    input.triggerAction("focus")
    assertEquals(eventTriggered, 1)
  }

  test("Function as inline event handler") {
    var clicked = 0
    def click(event: Any): Unit = clicked += 1
    val btn = html"""<button onclick="${click _}">Test</button>"""
    btn.click()
    assertEquals(clicked, 1)
  }

  test("Function as inline event handler (2)") {
    var clicked = 0
    def click(event: Any): Unit = clicked += 1
    val btn = html"""<button onclick="${click(_: Any)}">Test</button>"""
    btn.click()
    assertEquals(clicked, 1)
  }

  test("Function as inline event handler (3)") {
    var clicked = 0
    def f(): Unit = clicked += 1
    val btn = html"""<button onclick="$f">Test</button>"""

    btn.click()
    assertEquals(clicked, 1)
  }
}
*/
