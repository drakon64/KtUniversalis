@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property limsaLominsa The percent retainer tax in Limsa Lominsa
 * @property gridania The percent retainer tax in Gridania
 * @property uldah The percent retainer tax in Ul'dah
 * @property ishgard The percent retainer tax in Ishgard
 * @property kugane The percent retainer tax in Kugane
 * @property crystarium The percent retainer tax in the Crystarium
 * @property oldSharlayan The percent retainer tax in Old Sharlayan
 */
@JsExport @Serializable data class TaxRates(
    @SerialName("Limsa Lominsa") val limsaLominsa: Byte,
    @SerialName("Gridania") val gridania: Byte,
    @SerialName("Ul'dah") val uldah: Byte,
    @SerialName("Ishgard") val ishgard: Byte,
    @SerialName("Kugane") val kugane: Byte,
    @SerialName("Crystarium") val crystarium: Byte,
    @SerialName("Old Sharlayan") val oldSharlayan: Byte,
)
