@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property items A list of item upload information in timestamp-ascending/descending order.
 */
@JsExport @Serializable
data class RecentlyUpdatedItems(val items: List<WorldItemRecency>? = null)
