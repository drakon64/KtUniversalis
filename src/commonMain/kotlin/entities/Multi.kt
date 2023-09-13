@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import cloud.drakon.ktuniversalis.world.DataCenter
import cloud.drakon.ktuniversalis.world.World
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property itemIds The item IDs that were requested.
 * @property items The item data that was requested, keyed on the item ID.
 * @property dataCenter The [DataCenter] requested, if applicable.
 * @property regionName The name of the region requested, if applicable.
 * @property unresolvedItems A list of IDs that could not be resolved to any item data.
 * @property world The [World] requested, if applicable.
 */
@JsExport @Serializable
data class Multi<T : MarketBoard>(
    @SerialName("itemIDs") val itemIds: List<Int>? = null,
    val items: Map<Int, T>? = null,
    @SerialName("dcName") val dataCenter: DataCenter? = null,
    val regionName: String? = null,
    val unresolvedItems: List<Int>? = null,
    @SerialName("worldName") val world: World? = null,
)
