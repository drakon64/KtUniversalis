@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import cloud.drakon.ktuniversalis.world.World
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * ID and [World] supported by the Universalis API.
 * @property id ID of a world supported by the Universalis API.
 * @property world [World] supported by the Universalis API.
 */
@JsExport @Serializable
data class AvailableWorld(val id: Short, @SerialName("name") val world: World)
