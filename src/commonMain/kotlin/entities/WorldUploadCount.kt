package cloud.drakon.ktuniversalis.entities

import kotlin.js.JsExport
import kotlinx.serialization.Serializable

/**
 * @property count The number of times an upload has occurred on this world
 * @property proportion The proportion of uploads on this world to the total number of uploads
 */
@JsExport @Serializable data class WorldUploadCount(
    val count: Int,
    val proportion: Double,
)
