@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property itemIds The item IDs that were requested.
 * @property items The item data that was requested, keyed on the item ID.
 * @property unresolvedItems A list of IDs that could not be resolved to any item data.
 */
@JsExport @Serializable
data class Multi<T : MarketBoard>(
    @SerialName("itemIDs") val itemIds: List<Int>? = null,
    val items: Map<Int, T>? = null,
    val unresolvedItems: List<Int>? = null,
)
