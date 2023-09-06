@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property sourceName The name of the client application
 * @property uploadCount The number of uploads originating from the client application
 */
@JsExport
@Serializable
data class SourceUploadCount(
    val sourceName: String? = null,
    val uploadCount: Int,
)
