@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport @Serializable
enum class City(val id: Byte) {
    @SerialName("Limsa Lominsa") LimsaLominsa(1) {
        override fun toString() = "Limsa Lominsa"
    },

    Gridania(2),

    @SerialName("Ul'dah") Uldah(3) {
        override fun toString() = "Ul'dah"
    },

    Ishgard(4),
    Kugane(7),
    Crystarium(10),

    @SerialName("Old Sharlayan") OldSharlayan(12) {
        override fun toString() = "Old Sharlayan"
    };

    internal companion object {
        val idToCity = mapOf(
            LimsaLominsa.id to LimsaLominsa,
            Gridania.id to Gridania,
            Uldah.id to Uldah,
            Ishgard.id to Ishgard,
            Kugane.id to Kugane,
            Crystarium.id to Crystarium,
            OldSharlayan.id to OldSharlayan
        )
    }
}
