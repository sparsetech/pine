package pl.metastack.metaweb

import pl.metastack.metaweb.macros.{ExternalHtml, InlineHtml}

trait Macros extends InlineHtml.Import with ExternalHtml.Import
