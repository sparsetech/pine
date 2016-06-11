package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * This element includes the <a href="/en-US/docs/Web/HTML/Global_attributes">global attributes</a>.
<dt>
 <strong id="attr-label"><code>label</code></strong>
</dt> 
<dd>
 The name of the menu as shown to the user. Used within nested menus, to provide a label through which the submenu can be accessed. Must only be specified when the parent element is a 
 <a href="/en-US/docs/Web/HTML/Element/menu" title="The HTML <menu> element represents a group of commands that a user can perform or activate. This includes both list menus, which might appear across the top of a screen, as well as context menus, such as those that might appear underneath a button after it has been clicked."><code>&lt;menu&gt;</code></a> in the 
 <em>context menu</em> state.
</dd> 
<dt>
 <strong id="attr-type"><code>type</code></strong>
</dt> 
<dd>
 This attribute indicates the kind of menu being declared, and can be one of two values. 
 <ul> 
  <li><code>context</code>: The <em>context menu</em> state, which represents a group of commands activated through another element. This might be through the <code><a href="/en-US/docs/Web/HTML/Element/button#attr-menu">menu</a></code> attribute of a <a href="/en-US/docs/Web/HTML/Element/button" title="The HTML <button> Element represents a clickable button."><code>&lt;button&gt;</code></a>, or an element with a <a href="/en-US/docs/HTML/Global_attributes#attr-contextmenu"><code>contextmenu</code></a> attribute. When nesting <a href="/en-US/docs/Web/HTML/Element/menu" title="The HTML <menu> element represents a group of commands that a user can perform or activate. This includes both list menus, which might appear across the top of a screen, as well as context menus, such as those that might appear underneath a button after it has been clicked."><code>&lt;menu&gt;</code></a> elements directly within one another, this is the missing value default if the parent is already in this state.</li> 
  <li><code>list</code>: The <em>list menu</em> state, which represents a series of commands for user interaction. This is the missing value default, except where the parent element is a <a href="/en-US/docs/Web/HTML/Element/menu" title="The HTML <menu> element represents a group of commands that a user can perform or activate. This includes both list menus, which might appear across the top of a screen, as well as context menus, such as those that might appear underneath a button after it has been clicked."><code>&lt;menu&gt;</code></a> in the <em>context menu</em> state.</li> 
 </ul> 
</dd>
 */
case class Menu(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends tree.Tag with HTMLTag {
  override def tagName = "menu"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Menu = Menu(attributes, children)
  /**
   * The name of the menu as shown to the user. Used within nested menus, to provide a label through which the submenu can be accessed. Must only be specified when the parent element is a 
<a href="/en-US/docs/Web/HTML/Element/menu" title="The HTML <menu> element represents a group of commands that a user can perform or activate. This includes both list menus, which might appear across the top of a screen, as well as context menus, such as those that might appear underneath a button after it has been clicked."><code>&lt;menu&gt;</code></a> in the 
<em>context menu</em> state.
   */
  def label: scala.Option[String] = attributes.get("label").asInstanceOf[scala.Option[String]]
  /**
   * This attribute indicates the kind of menu being declared, and can be one of two values. 
<ul> 
 <li><code>context</code>: The <em>context menu</em> state, which represents a group of commands activated through another element. This might be through the <code><a href="/en-US/docs/Web/HTML/Element/button#attr-menu">menu</a></code> attribute of a <a href="/en-US/docs/Web/HTML/Element/button" title="The HTML <button> Element represents a clickable button."><code>&lt;button&gt;</code></a>, or an element with a <a href="/en-US/docs/HTML/Global_attributes#attr-contextmenu"><code>contextmenu</code></a> attribute. When nesting <a href="/en-US/docs/Web/HTML/Element/menu" title="The HTML <menu> element represents a group of commands that a user can perform or activate. This includes both list menus, which might appear across the top of a screen, as well as context menus, such as those that might appear underneath a button after it has been clicked."><code>&lt;menu&gt;</code></a> elements directly within one another, this is the missing value default if the parent is already in this state.</li> 
 <li><code>list</code>: The <em>list menu</em> state, which represents a series of commands for user interaction. This is the missing value default, except where the parent element is a <a href="/en-US/docs/Web/HTML/Element/menu" title="The HTML <menu> element represents a group of commands that a user can perform or activate. This includes both list menus, which might appear across the top of a screen, as well as context menus, such as those that might appear underneath a button after it has been clicked."><code>&lt;menu&gt;</code></a> in the <em>context menu</em> state.</li> 
</ul>
   */
  def `type`: scala.Option[String] = attributes.get("type").asInstanceOf[scala.Option[String]]
}
