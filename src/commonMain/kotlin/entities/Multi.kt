package cloud.drakon.ktuniversalis.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property itemIds The item IDs that were requested.
 * @property items The item data that was requested, keyed on the item ID.
 * @property unresolvedItems An array of IDs that could not be resolved to any item data.
 */
@Serializable
data class Multi<T : MarketBoard>(
    @SerialName("itemIDs") val itemIds: List<Int>? = null,
    val items: Map<Int, T>? = null,
    val unresolvedItems: List<Int>? = null,
)
