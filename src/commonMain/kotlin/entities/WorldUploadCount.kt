package cloud.drakon.ktuniversalis.entities

import kotlin.js.JsExport
import kotlinx.serialization.Serializable

@JsExport @Serializable class WorldUploadCount(val count: Int, val proportion: Double)
