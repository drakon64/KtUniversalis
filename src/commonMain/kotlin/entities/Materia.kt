@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property slotId The materia slot.
 * @property materiaId The materia item ID.
 */
@JsExport @Serializable
data class Materia(
    @SerialName("slotID") val slotId: Byte,
    @SerialName("materiaID") val materiaId: Int,
)
