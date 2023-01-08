package cloud.drakon.ktuniversalis.entities

import kotlin.js.JsExport
import kotlinx.serialization.Serializable

@JsExport @Serializable
class MostRecentlyUpdatedItems(val items: Array<WorldItemRecency>? = null)
