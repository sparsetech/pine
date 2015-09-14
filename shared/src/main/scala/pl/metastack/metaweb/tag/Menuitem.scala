package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The <strong>HTML <code>&lt;menuitem&gt;</code> element</strong> represents a command that a user is able to invoke through a popup menu. This includes context menus, as well as menus that might be attached to a menu button.
A command can either be defined explicitly, with a textual label and optional icon to describe its appearance, or alternatively as an <em>indirect command</em> whose behavior is defined by a separate element. Commands can also optionally include a checkbox or be grouped to share radio buttons. (Menu items for indirect commands gain checkboxes or radio buttons when defined against elements <code>&lt;input type="checkbox"&gt;</code> and <code>&lt;input type="radio"&gt;</code>.)
 */
class Menuitem extends state.Tag("menuitem") with HTMLTag {
  /**
   * Boolean attribute which indicates whether the command is selected. May only be used when the 
<code>type</code> attribute is 
<code>checkbox</code> or 
<code>radio</code>.
   */
  def checked: StateChannel[String] = attribute("checked").asInstanceOf[StateChannel[String]]
  /**
   * Specifies the ID of a separate element, indicating a command to be invoked indirectly. May not be used within a menu item that also includes the attributes 
<code>checked</code>, 
<code>disabled</code>, 
<code>icon</code>, 
<code>label</code>, 
<code>radiogroup</code> or 
<code>type</code>.
   */
  def command: StateChannel[String] = attribute("command").asInstanceOf[StateChannel[String]]
  /**
   * This Boolean attribute indicates use of the same command as the menu's subject element (such as a 
<code>button</code> or 
<code>input</code>).
   */
  def default: StateChannel[String] = attribute("default").asInstanceOf[StateChannel[String]]
  /**
   * Boolean attribute which indicates that the command is not available in the current state. Note that 
<code>disabled</code> is distinct from 
<code>hidden</code>; the 
<code>disabled</code> attribute is appropriate in any context where a change in circumstances might render the command relevant.
   */
  def disabled: StateChannel[String] = attribute("disabled").asInstanceOf[StateChannel[String]]
  /**
   * Image URL, used to provide a picture to represent the command.
   */
  def icon: StateChannel[String] = attribute("icon").asInstanceOf[StateChannel[String]]
  /**
   * The name of the command as shown to the user. Required when a 
<code>command</code> attribute is not present.
   */
  def label: StateChannel[String] = attribute("label").asInstanceOf[StateChannel[String]]
  /**
   * This attribute specifies the name of a group of commands to be toggled as radio buttons when selected. May only be used where the 
<code>type</code> attribute is 
<code>radio</code>.
   */
  def radiogroup: StateChannel[String] = attribute("radiogroup").asInstanceOf[StateChannel[String]]
  /**
   * This attribute indicates the kind of command, and can be one of three values. 
<ul> 
 <li><code>command</code>: A regular command with an associated action. This is the missing value default.</li> 
 <li><code>checkbox</code>: Represents a command that can be toggled between two different states.</li> 
 <li><code>radio</code>: Represent one selection from a group of commands that can be toggled as radio buttons.</li> 
</ul>
   */
  def `type`: StateChannel[String] = attribute("type").asInstanceOf[StateChannel[String]]
}
