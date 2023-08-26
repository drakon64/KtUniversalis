@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@JsExport @Serializable data class Multi<T: MarketBoard>(
    @SerialName("itemIDs") val itemIds: Set<Int>? = null,
    val items: Map<Int, T>? = null,
    @SerialName("worldID") val worldId: Short? = null,
    val dcName: String? = null,
    val regionName: String? = null,
    val unresolvedItems: Set<Int>? = null,
    val worldName: String? = null,
)
