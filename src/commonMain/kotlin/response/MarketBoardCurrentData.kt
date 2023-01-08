package cloud.drakon.ktuniversalis.response

import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property itemId The item ID
 * @property worldId The world ID, if applicable
 * @property lastUploadTime The last upload time for this endpoint, in milliseconds since the UNIX epoch
 * @property listings The currently-shown listings
 * @property recentHistory The currently-shown sales
 * @property dcName The DC name, if applicable
 * @property regionName The region name, if applicable
 * @property currentAveragePrice The average listing price, with outliers removed beyond 3 standard deviations of the mean
 * @property currentAveragePriceNQ The average NQ listing price, with outliers removed beyond 3 standard deviations of the mean
 * @property currentAveragePriceHQ The average HQ listing price, with outliers removed beyond 3 standard deviations of the mean
 * @property regularSaleVelocity The average number of sales per day, over the past seven days (or the entirety of the shown sales, whichever comes first)
 * @property nqSaleVelocity The average number of NQ sales per day, over the past seven days (or the entirety of the shown sales, whichever comes first)
 * @property hqSaleVelocity The average number of HQ sales per day, over the past seven days (or the entirety of the shown sales, whichever comes first)
 * @property averagePrice The average sale price, with outliers removed beyond 3 standard deviations of the mean
 * @property averagePriceNQ The average NQ sale price, with outliers removed beyond 3 standard deviations of the mean
 * @property averagePriceHQ The average HQ sale price, with outliers removed beyond 3 standard deviations of the mean
 * @property minPrice The minimum listing price
 * @property minPriceNQ The minimum NQ listing price
 * @property minPriceHQ The minimum HQ listing price
 * @property maxPrice The maximum listing price
 * @property maxPriceNQ The maximum NQ listing price
 * @property maxPriceHQ The maximum HQ listing price
 * @property stackSizeHistogram A map of quantities to listing counts, representing the number of listings of each quantity
 * @property stackSizeHistogramNQ A map of quantities to NQ listing counts, representing the number of listings of each quantity
 * @property stackSizeHistogramHQ A map of quantities to HQ listing counts, representing the number of listings of each quantity
 * @property worldName The world name, if applicable
 */
@JsExport @Serializable class MarketBoardCurrentData(
    @SerialName("itemID") val itemId: Int,
    @SerialName("worldID") val worldId: Int? = null,
    val lastUploadTime: Long,
    val listings: Array<Listing>,
    val recentHistory: Array<RecentHistory>,
    val dcName: String? = null,
    val regionName: String? = null,
    val currentAveragePrice: Double,
    val currentAveragePriceNQ: Double,
    val currentAveragePriceHQ: Double,
    val regularSaleVelocity: Int,
    val nqSaleVelocity: Int,
    val hqSaleVelocity: Int,
    val averagePrice: Double,
    val averagePriceNQ: Double,
    val averagePriceHQ: Double,
    val minPrice: Int,
    val minPriceNQ: Int,
    val minPriceHQ: Int,
    val maxPrice: Int,
    val maxPriceNQ: Int,
    val maxPriceHQ: Int,
    val stackSizeHistogram: Map<String, Int>,
    val stackSizeHistogramNQ: Map<String, Int>,
    val stackSizeHistogramHQ: Map<String, Int>,
    val worldName: String? = null,
)
