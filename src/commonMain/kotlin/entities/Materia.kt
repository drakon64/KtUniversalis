package cloud.drakon.ktuniversalis.entities

import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property slotId The materia slot
 * @property materiaId The materia item ID
 */
@JsExport @Serializable class Materia(
    @SerialName("slotID") val slotId: Int,
    @SerialName("materiaID") val materiaId: Int,
)
