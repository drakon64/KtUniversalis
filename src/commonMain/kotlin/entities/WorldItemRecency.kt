package cloud.drakon.ktuniversalis.entities

import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property itemId The item ID
 * @property lastUploadTime The last upload time for the item on the listed world
 * @property worldId The world ID
 * @property worldName The world name
 */
@JsExport @Serializable class WorldItemRecency(
    @SerialName("itemID") val itemId: Int,
    val lastUploadTime: Long,
    @SerialName("worldID") val worldId: Int,
    val worldName: String? = null,
)
