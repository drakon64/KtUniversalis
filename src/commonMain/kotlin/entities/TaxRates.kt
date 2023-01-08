package cloud.drakon.ktuniversalis.entities

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
@JsExport @Serializable class TaxRates(
    @SerialName("Limsa Lominsa") val limsaLominsa: Int,
    @SerialName("Gridania") val gridania: Int,
    @SerialName("Ul'dah") val uldah: Int,
    @SerialName("Ishgard") val ishgard: Int,
    @SerialName("Kugane") val kugane: Int,
    @SerialName("Crystarium") val crystarium: Int,
    @SerialName("Old Sharlayan") val oldSharlayan: Int,
)
