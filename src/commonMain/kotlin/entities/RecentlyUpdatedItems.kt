@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property items An list of item IDs, with the least/most recent first.
 */
@JsExport @Serializable
data class RecentlyUpdatedItems(val items: List<WorldItemRecency>? = null)
