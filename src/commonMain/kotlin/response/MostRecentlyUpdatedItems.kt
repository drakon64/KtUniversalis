package cloud.drakon.ktuniversalis.response

import kotlin.js.JsExport
import kotlinx.serialization.Serializable

/**
 * The least-recently updated items on the specified world or data center, along with the upload times for each item
 */
@JsExport @Serializable
class MostRecentlyUpdatedItems(val items: Array<WorldItemRecency>? = null)
