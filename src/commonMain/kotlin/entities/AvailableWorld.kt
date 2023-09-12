@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import cloud.drakon.ktuniversalis.world.World
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * ID and name of a [World] supported by the Universalis API.
 * @property id ID of a [World] supported by the Universalis API.
 * @property name Name of a [World] supported by the Universalis API.
 */
@JsExport @Serializable
data class AvailableWorld(val id: Short, val name: World)
