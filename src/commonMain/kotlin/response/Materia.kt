package cloud.drakon.ktuniversalis.response

import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@JsExport @Serializable class Materia(
    @SerialName("slotID") val slotId: Int,
    @SerialName("materiaID") val materiaId: Int,
)
