@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import cloud.drakon.ktuniversalis.world.DataCenter
import cloud.drakon.ktuniversalis.world.World
import cloud.drakon.ktuniversalis.world.idToWorld
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * A data center supported by the Universalis API.
 * @property dataCenter [DataCenter] supported by the Universalis API.
 * @property region Region of a data center supported by the Universalis API.
 * @property worldsIds World IDs of a data center supported by the Universalis API.
 */
@JsExport @Serializable
data class AvailableDataCenter(
    @SerialName("name") val dataCenter: DataCenter,
    val region: String,
    @SerialName("worlds") val worldsIds: List<Short>,
) {
    /**
     * [World]s of a data center supported by the Universalis API
     */
    @Transient val worlds = mutableListOf<World>().let {
        for (worldId in worldsIds) it.add(idToWorld.getValue(worldId))

        it.toList()
    }
}
