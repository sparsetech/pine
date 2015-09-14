package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * <span style="line-height: 21px;">This element includes the&nbsp;</span><a href="https://developer.mozilla.org/en-US/docs/HTML/Global_attributes" title="HTML/Global attributes" style="line-height: 21px;">global attributes</a><span style="line-height: 21px;">.</span>
<dt>
 <strong id="attr-autofocus"><code>autofocus</code></strong>
</dt> 
<dd>
 This Boolean attribute lets you specify that the control should have input focus when the page loads, unless the user overrides it, for example by typing in a different control. Only one form element in a document can have the 
 <code>autofocus</code> attribute, which is a Boolean.
</dd> 
<dt>
 <strong id="attr-challenge"><code>challenge</code></strong>
</dt> 
<dd>
 A challenge string that is submitted along with the public key. Defaults to an empty string if not specified.
</dd> 
<dt>
 <strong id="attr-disabled"><code>disabled</code></strong>
</dt> 
<dd>
 This Boolean attribute indicates that the form control is not available for interaction.
</dd> 
<dt>
 <strong id="attr-form"><code>form</code></strong>
</dt> 
<dd>
 The form element that this element is associated with (its 
 <em>form owner</em>). The value of the attribute must be an 
 <code>id</code> of a 
 <a href="/en-US/docs/Web/HTML/Element/form" title="The HTML <form> element represents a document section that contains interactive controls to submit information to a web server."><code>&lt;form&gt;</code></a> element in the same document. If this attribute is not specified, this element must be a descendant of a 
 <a href="/en-US/docs/Web/HTML/Element/form" title="The HTML <form> element represents a document section that contains interactive controls to submit information to a web server."><code>&lt;form&gt;</code></a> element. This attribute enables you to place 
 <code>&lt;keygen&gt; </code>elements anywhere within a document, not just as descendants of their form elements.
</dd> 
<dt>
 <strong id="attr-keytype"><code>keytype</code></strong>
</dt> 
<dd>
 The type of key generated. The default value is 
 <code>RSA</code>.
</dd> 
<dt>
 <strong id="attr-name"><code>name</code></strong>
</dt> 
<dd>
 The name of the control, which is submitted with the form data.
</dd>
The element is written as follows:
&lt;keygen name="<var>name</var>" challenge="<var>challenge string</var>" keytype="<var>type</var>" keyparams="<var>pqg-params</var>"&gt;
The <code>keytype</code> parameter is used to specify what type of key is to be generated. Valid values are "<code>RSA</code>", which is the default, "<code>DSA</code>" and "<code>EC</code>". The <code>name</code> and <code>challenge</code> attributes are required in all cases. The <code>keytype</code> attribute is optional for RSA key generation and required for DSA and EC key generation. The <code>keyparams</code> attribute is required for DSA and EC key generation and ignored for RSA key generation. <code>PQG</code> is a synonym for <code>keyparams</code>. That is, you may specify <code>keyparams="pqg-params"</code> or <code>pqg="pqg-params"</code>.
For RSA keys, the <code>keyparams</code> parameter is not used (ignored if present). The user may be given a choice of RSA key strengths. Currently, the user is given a choice between "high" strength (2048 bits) and "medium" strength (1024 bits).
For DSA keys, the <code>keyparams</code> parameter specifies the DSA PQG parameters which are to be used in the keygen process. The value of the <code>pqg</code> parameter is the the BASE64 encoded, DER encoded Dss-Parms as specified in IETF <a href="ftp://ftp.rfc-editor.org/in-notes/rfc3279.txt" class="link-ftp external">RFC 3279</a>. The user may be given a choice of DSA key sizes, allowing the user to choose one of the sizes defined in the DSA standard.
For EC keys, the <code>keyparams</code> parameter specifies the name of the elliptic curve on which the key will be generated. It is normally a string from the table in <a href="http://mxr.mozilla.org/mozilla-central/source/security/manager/ssl/src/nsKeygenHandler.cpp?mark=179-185,187-206,208-227,229-256#177" class="external" title="http://mxr.mozilla.org/mozilla-central/source/security/manager/ssl/src/nsKeygenHandler.cpp?mark=179-185,187-206,208-227,229-256#177">nsKeygenHandler.cpp</a>. (Note that only a subset of the curves named there may actually be supported in any particular browser.) If the <code>keyparams</code> parameter string is not a recognized curve name string, then a curve is chosen according to the user's chosen key strength (low, medium, high), using the curve named "<code>secp384r1</code>" for high, and the curve named "<code>secp256r1</code>" for medium keys. (Note: choice of the number of key strengths, default values for each strength, and the UI by which the user is offered a choice, are outside of the scope of this specification.)
The <code>&lt;keygen&gt;</code> element is only valid within an HTML form. It will cause some sort of selection to be presented to the user for selecting key size. The UI for the selection may be a menu, radio buttons, or possibly something else. The browser presents several possible key strengths. Currently, two strengths are offered, high and medium. If the user's browser is configured to support cryptographic hardware (e.g. "smart cards") the user may also be given a choice of where to generate the key, i.e., in a smart card or in software and stored on disk.
When the submit button is pressed, a key pair of the selected size is generated. The private key is encrypted and stored in the local key database.
PublicKeyAndChallenge ::= SEQUENCE {
       spki SubjectPublicKeyInfo,
       challenge IA5STRING
   }
   SignedPublicKeyAndChallenge ::= SEQUENCE {
       publicKeyAndChallenge PublicKeyAndChallenge,
       signatureAlgorithm AlgorithmIdentifier,
       signature BIT STRING
   }
The public key and challenge string are DER encoded as <code>PublicKeyAndChallenge</code>, and then digitally signed with the private key to produce a <code>SignedPublicKeyAndChallenge</code>. The <code>SignedPublicKeyAndChallenge</code> is <a href="/en-US/docs/Glossary/Base64" class="new glossaryLink" title="The definition of that term (Base64) has not been written yet; please consider contributing it!">Base64</a> encoded, and the ASCII data is finally submitted to the server as the value of a form name/value pair, where the name is <var>name</var> as specified by the <code>name</code> attribute of the <code>keygen</code> element. If no challenge string is provided, then it will be encoded as an <code>IA5STRING</code> of length zero.
Here is an example form submission as it would be delivered to a CGI program by the HTTP server:
commonname=John+Doe&amp;email=doe@foo.com&amp;org=Foobar+Computing+Corp.&amp;
   orgunit=Bureau+of+Bureaucracy&amp;locality=Anytown&amp;state=California&amp;country=US&amp;
   key=MIHFMHEwXDANBgkqhkiG9w0BAQEFAANLADBIAkEAnX0TILJrOMUue%2BPtwBRE6XfV%0AWtKQbsshxk5ZhcUwcwyvcnIq9b82QhJdoACdD34rqfCAIND46fXKQUnb0mvKzQID%0AAQABFhFNb3ppbGxhSXNNeUZyaWVuZDANBgkqhkiG9w0BAQQFAANBAAKv2Eex2n%2FS%0Ar%2F7iJNroWlSzSMtTiQTEB%2BADWHGj9u1xrUrOilq%2Fo2cuQxIfZcNZkYAkWP4DubqW%0Ai0%2F%2FrgBvmco%3D
 */
class Keygen extends state.Tag("keygen") with HTMLTag {
  /**
   * This Boolean attribute lets you specify that the control should have input focus when the page loads, unless the user overrides it, for example by typing in a different control. Only one form element in a document can have the 
<code>autofocus</code> attribute, which is a Boolean.
   */
  def autofocus: StateChannel[String] = attribute("autofocus").asInstanceOf[StateChannel[String]]
  /**
   * A challenge string that is submitted along with the public key. Defaults to an empty string if not specified.
   */
  def challenge: StateChannel[String] = attribute("challenge").asInstanceOf[StateChannel[String]]
  /**
   * This Boolean attribute indicates that the form control is not available for interaction.
   */
  def disabled: StateChannel[String] = attribute("disabled").asInstanceOf[StateChannel[String]]
  /**
   * The form element that this element is associated with (its 
<em>form owner</em>). The value of the attribute must be an 
<code>id</code> of a 
<a href="/en-US/docs/Web/HTML/Element/form" title="The HTML <form> element represents a document section that contains interactive controls to submit information to a web server."><code>&lt;form&gt;</code></a> element in the same document. If this attribute is not specified, this element must be a descendant of a 
<a href="/en-US/docs/Web/HTML/Element/form" title="The HTML <form> element represents a document section that contains interactive controls to submit information to a web server."><code>&lt;form&gt;</code></a> element. This attribute enables you to place 
<code>&lt;keygen&gt; </code>elements anywhere within a document, not just as descendants of their form elements.
   */
  def form: StateChannel[String] = attribute("form").asInstanceOf[StateChannel[String]]
  /**
   * The type of key generated. The default value is 
<code>RSA</code>.
   */
  def keytype: StateChannel[String] = attribute("keytype").asInstanceOf[StateChannel[String]]
  /**
   * The name of the control, which is submitted with the form data.
   */
  def name: StateChannel[String] = attribute("name").asInstanceOf[StateChannel[String]]
}
