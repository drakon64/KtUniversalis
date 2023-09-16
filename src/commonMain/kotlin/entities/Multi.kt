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
    @SerialName("itemIDs") val itemIds: IntArray? = null,
    val items: Map<Int, T>? = null,
    val unresolvedItems: IntArray? = null,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Multi<*>

        if (itemIds != null) {
            if (other.itemIds == null) return false
            if (!itemIds.contentEquals(other.itemIds)) return false
        } else if (other.itemIds != null) return false
        if (items != other.items) return false
        if (unresolvedItems != null) {
            if (other.unresolvedItems == null) return false
            if (!unresolvedItems.contentEquals(other.unresolvedItems)) return false
        } else if (other.unresolvedItems != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = itemIds?.contentHashCode() ?: 0
        result = 31 * result + (items?.hashCode() ?: 0)
        result = 31 * result + (unresolvedItems?.contentHashCode() ?: 0)
        return result
    }
}
