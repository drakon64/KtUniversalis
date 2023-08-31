@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.world

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.Serializable

@JsExport @Serializable enum class Region {
    Japan, Europe, NorthAmerica, Oceania, China, 中国
}
