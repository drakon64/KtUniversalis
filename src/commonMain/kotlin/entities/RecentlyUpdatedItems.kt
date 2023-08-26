@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.Serializable

/**
 * @property items A list of item IDs, with the most recent first
 */
@JsExport
@Serializable
data class RecentlyUpdatedItems(val items: List<WorldItemRecency>? = null)
