@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property lastUploadTime The last upload time for this endpoint, in milliseconds since the UNIX epoch.
 * @property entries The historical sales.
 * @property stackSizeHistogram A [Map] of quantities to sale counts, representing the number of sales of each quantity.
 * @property stackSizeHistogramNq A [Map] of quantities to NQ sale counts, representing the number of sales of each quantity.
 * @property stackSizeHistogramHq A [Map] of quantities to HQ sale counts, representing the number of sales of each quantity.
 * @property regularSaleVelocity The average number of sales per day, over the past seven days (or the entirety of the shown sales, whichever comes first).
 * @property nqSaleVelocity The average number of NQ sales per day, over the past seven days (or the entirety of the shown sales, whichever comes first).
 * @property hqSaleVelocity The average number of HQ sales per day, over the past seven days (or the entirety of the shown sales, whichever comes first).
 */
@JsExport @Serializable
data class History(
    val lastUploadTime: Long,
    val entries: Array<MinimizedSale>? = null,
    val stackSizeHistogram: StackSizeHistogram = null,
    @SerialName("stackSizeHistogramNQ") val stackSizeHistogramNq: StackSizeHistogram = null,
    @SerialName("stackSizeHistogramHQ") val stackSizeHistogramHq: StackSizeHistogram = null,
    val regularSaleVelocity: Double,
    val nqSaleVelocity: Double,
    val hqSaleVelocity: Double,
) : MarketBoard {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as History

        if (lastUploadTime != other.lastUploadTime) return false
        if (entries != null) {
            if (other.entries == null) return false
            if (!entries.contentEquals(other.entries)) return false
        } else if (other.entries != null) return false
        if (stackSizeHistogram != other.stackSizeHistogram) return false
        if (stackSizeHistogramNq != other.stackSizeHistogramNq) return false
        if (stackSizeHistogramHq != other.stackSizeHistogramHq) return false
        if (regularSaleVelocity != other.regularSaleVelocity) return false
        if (nqSaleVelocity != other.nqSaleVelocity) return false
        if (hqSaleVelocity != other.hqSaleVelocity) return false

        return true
    }

    override fun hashCode(): Int {
        var result = lastUploadTime.hashCode()
        result = 31 * result + (entries?.contentHashCode() ?: 0)
        result = 31 * result + (stackSizeHistogram?.hashCode() ?: 0)
        result = 31 * result + (stackSizeHistogramNq?.hashCode() ?: 0)
        result = 31 * result + (stackSizeHistogramHq?.hashCode() ?: 0)
        result = 31 * result + regularSaleVelocity.hashCode()
        result = 31 * result + nqSaleVelocity.hashCode()
        result = 31 * result + hqSaleVelocity.hashCode()
        return result
    }
}
