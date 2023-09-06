@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import cloud.drakon.ktuniversalis.world.DataCenter
import cloud.drakon.ktuniversalis.world.World
import cloud.drakon.ktuniversalis.world.idToWorld
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * A data center supported by the Universalis API
 * @property name Name of a data center supported by the Universalis API
 * @property region Region of a data center supported by the Universalis API
 * @property worlds World IDs of a data center supported by the Universalis API
 */
@JsExport
@Serializable
data class AvailableDataCenter(
    val name: DataCenter,
    val region: String,
    val worlds: List<Short>,
) {
    /**
     * World names of a data center supported by the Universalis API
     */
    val worldNames = mutableListOf<World>().let {
        for (worldId in worlds) it.add(idToWorld.getValue(worldId))

        it.toList()
    }
}
