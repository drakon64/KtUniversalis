@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.Serializable

/**
 * A data center supported by the Universalis API
 * @property name Name of a data center supported by the Universalis API
 * @property region Region of a data center supported by the Universalis API
 * @property worlds World IDs of a data center supported by the Universalis API
 */
@JsExport @Serializable data class DataCenter(
    val name: String? = null,
    val region: String? = null,
    val worlds: Set<Short>? = null,
)
