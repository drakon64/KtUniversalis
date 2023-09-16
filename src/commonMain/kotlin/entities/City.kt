@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport @Serializable
enum class City {
    @SerialName("Limsa Lominsa") LimsaLominsa,
    Gridania,
    @SerialName("Ul'dah") Uldah,
    Ishgard,
    Kugane,
    Crystarium,
    @SerialName("Old Sharlayan") OldSharlayan
}
