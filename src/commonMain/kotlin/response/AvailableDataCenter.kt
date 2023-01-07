package cloud.drakon.ktuniversalis.response

import kotlin.js.JsExport
import kotlinx.serialization.Serializable

/**
 * A data center supported by the Universalis API
 */
@JsExport @Serializable class AvailableDataCenter(
    val name: String,
    val region: String,
    val worlds: ShortArray,
)
