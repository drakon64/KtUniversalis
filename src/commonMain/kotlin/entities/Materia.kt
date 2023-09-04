@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property slotId The materia slot
 * @property materiaId The materia item ID
 */
@JsExport @Serializable data class Materia(
    @SerialName("slotID") val slotId: Byte,
    @SerialName("materiaID") val materiaId: Int,
)
