@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.world

import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport @Serializable
enum class Region {
    Japan, Europe, NorthAmerica, Oceania, China
}
