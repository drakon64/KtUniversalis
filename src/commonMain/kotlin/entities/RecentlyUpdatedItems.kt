@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.Serializable

/**
 * @property items An array of item upload information
 */
@JsExport
@Serializable
data class RecentlyUpdatedItems(val items: List<WorldItemRecency>? = null)
