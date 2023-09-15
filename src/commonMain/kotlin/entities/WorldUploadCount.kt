@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import cloud.drakon.ktuniversalis.world.World
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property count The number of times an upload has occurred on this [World].
 * @property proportion The proportion of uploads on this [World] to the total number of uploads.
 */
@JsExport @Serializable
data class WorldUploadCount(val count: Int, val proportion: Double)
