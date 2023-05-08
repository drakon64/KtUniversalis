package cloud.drakon.ktuniversalis.entities

import kotlin.js.JsExport
import kotlinx.serialization.Serializable

/**
 * @property sourceName The name of the client application
 * @property uploadCount The number of uploads originating from the client application
 */
@JsExport @Serializable data class SourceUploadCount(
    val sourceName: String? = null,
    val uploadCount: Int,
)
