@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property lastUploadTime The last upload time for this endpoint, in milliseconds since the UNIX epoch
 * @property entries The historical sales
 * @property stackSizeHistogram A map of quantities to sale counts, representing the number of sales of each quantity
 * @property stackSizeHistogramNq A map of quantities to NQ sale counts, representing the number of sales of each quantity
 * @property stackSizeHistogramHq A map of quantities to HQ sale counts, representing the number of sales of each quantity
 * @property regularSaleVelocity The average number of sales per day, over the past seven days (or the entirety of the shown sales, whichever comes first)
 * @property nqSaleVelocity The average number of NQ sales per day, over the past seven days (or the entirety of the shown sales, whichever comes first)
 * @property hqSaleVelocity The average number of HQ sales per day, over the past seven days (or the entirety of the shown sales, whichever comes first)
 */
@JsExport @Serializable data class History(
    val lastUploadTime: Long,
    val entries: List<MinimizedSale>? = null,
    val stackSizeHistogram: StackSizeHistogram = null,

    @SerialName("stackSizeHistogramNQ")
    val stackSizeHistogramNq: StackSizeHistogram = null,

    @SerialName("stackSizeHistogramHQ")
    val stackSizeHistogramHq: StackSizeHistogram = null,

    val regularSaleVelocity: Double,
    val nqSaleVelocity: Double,
    val hqSaleVelocity: Double,
): MarketBoard
