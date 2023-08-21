package cloud.drakon.ktuniversalis.entities

import kotlin.js.JsExport
import kotlinx.serialization.Serializable

/**
 * @property items An array of item upload information
 */
@JsExport
@Serializable
data class RecentlyUpdatedItems(val items: Set<WorldItemRecency>? = null)
