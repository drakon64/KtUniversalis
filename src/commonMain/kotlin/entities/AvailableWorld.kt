@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import cloud.drakon.ktuniversalis.world.World
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.Serializable

/**
 * ID and name of a world supported by the Universalis API
 * @property id ID of a world supported by the Universalis API
 * @property name Name of a world supported by the Universalis API
 */
@JsExport @Serializable data class AvailableWorld(val id: Short, val name: World)
