package cloud.drakon.ktuniversalis.entities

import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property itemId The item ID
 * @property worldId The world ID, if applicable
 * @property lastUploadTime The last upload time for this endpoint, in milliseconds since the UNIX epoch
 * @property entries The historical sales
 * @property dcName The DC name, if applicable
 * @property regionName The region name, if applicable
 * @property stackSizeHistogram A map of quantities to sale counts, representing the number of sales of each quantity
 * @property stackSizeHistogramNq A map of quantities to NQ sale counts, representing the number of sales of each quantity
 * @property stackSizeHistogramHq A map of quantities to HQ sale counts, representing the number of sales of each quantity
 * @property regularSaleVelocity The average number of sales per day, over the past seven days (or the entirety of the shown sales, whichever comes first)
 * @property nqSaleVelocity The average number of NQ sales per day, over the past seven days (or the entirety of the shown sales, whichever comes first)
 * @property hqSaleVelocity The average number of HQ sales per day, over the past seven days (or the entirety of the shown sales, whichever comes first)
 * @property worldName The world name, if applicable
 */
@JsExport @Serializable class History(
    @SerialName("itemID") val itemId: Int,
    @SerialName("worldID") val worldId: Int? = null,
    val lastUploadTime: Long,
    val entries: Array<MinimizedSale>? = null,
    val dcName: String? = null,
    val regionName: String? = null,
    val stackSizeHistogram: Map<String, Int>? = null,
    @SerialName("stackSizeHistogramNQ")
    val stackSizeHistogramNq: Map<String, Int>? = null,
    @SerialName("stackSizeHistogramHQ")
    val stackSizeHistogramHq: Map<String, Int>? = null,
    val regularSaleVelocity: Double,
    val nqSaleVelocity: Double,
    val hqSaleVelocity: Double,
    val worldName: String? = null,
)
