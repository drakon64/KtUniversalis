@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import cloud.drakon.ktuniversalis.world.World
import cloud.drakon.ktuniversalis.world.idToWorld
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property lastUploadTime The last upload time for this endpoint, in milliseconds since the UNIX epoch.
 * @property listings The currently-shown listings.
 * @property recentHistory The currently-shown sales.
 * @property currentAveragePrice The average listing price, with outliers removed beyond 3 standard deviations of the mean.
 * @property currentAveragePriceNq The average NQ listing price, with outliers removed beyond 3 standard deviations of the mean.
 * @property currentAveragePriceHq The average HQ listing price, with outliers removed beyond 3 standard deviations of the mean.
 * @property regularSaleVelocity The average number of sales per day, over the past seven days (or the entirety of the shown sales, whichever comes first).
 * @property nqSaleVelocity The average number of NQ sales per day, over the past seven days (or the entirety of the shown sales, whichever comes first).
 * @property hqSaleVelocity The average number of HQ sales per day, over the past seven days (or the entirety of the shown sales, whichever comes first).
 * @property averagePrice The average sale price, with outliers removed beyond 3 standard deviations of the mean.
 * @property averagePriceNq The average NQ sale price, with outliers removed beyond 3 standard deviations of the mean.
 * @property averagePriceHq The average HQ sale price, with outliers removed beyond 3 standard deviations of the mean.
 * @property minPrice The minimum listing price.
 * @property minPriceNq The minimum NQ listing price.
 * @property minPriceHq The minimum HQ listing price.
 * @property maxPrice The maximum listing price.
 * @property maxPriceNq The maximum NQ listing price.
 * @property maxPriceHq The maximum HQ listing price.
 * @property stackSizeHistogram A map of quantities to listing counts, representing the number of listings of each quantity.
 * @property stackSizeHistogramNq A map of quantities to NQ listing counts, representing the number of listings of each quantity.
 * @property stackSizeHistogramHq A map of quantities to HQ listing counts, representing the number of listings of each quantity.
 * @property worldIdUploadTimes The last upload times in milliseconds since epoch for each world in the response, if this is a DC request.
 * @property listingsCount The number of listings retrieved for the request. When using the `listings` limit parameter, this may be different from the number of sale entries returned.
 * @property recentHistoryCount The number of sale entries retrieved for the request. When using the `entries` limit parameter, this may be different from the number of sale entries returned.
 * @property unitsForSale The number of items (not listings) up for sale.
 * @property unitsSold The number of items (not sale entries) sold over the retrieved sales.
 */
@JsExport @Serializable
data class CurrentlyShown(
    val lastUploadTime: Long,
    val listings: List<Listing>? = null,
    val recentHistory: List<Sale>? = null,
    val currentAveragePrice: Double,
    @SerialName("currentAveragePriceNQ") val currentAveragePriceNq: Double,
    @SerialName("currentAveragePriceHQ") val currentAveragePriceHq: Double,
    val regularSaleVelocity: Double,
    val nqSaleVelocity: Double,
    val hqSaleVelocity: Double,
    val averagePrice: Double,
    @SerialName("averagePriceNQ") val averagePriceNq: Double,
    @SerialName("averagePriceHQ") val averagePriceHq: Double,
    val minPrice: Int,
    @SerialName("minPriceNQ") val minPriceNq: Int,
    @SerialName("minPriceHQ") val minPriceHq: Int,
    val maxPrice: Int,
    @SerialName("maxPriceNQ") val maxPriceNq: Int,
    @SerialName("maxPriceHQ") val maxPriceHq: Int,
    val stackSizeHistogram: StackSizeHistogram = null,
    @SerialName("stackSizeHistogramNQ") val stackSizeHistogramNq: StackSizeHistogram = null,
    @SerialName("stackSizeHistogramHQ") val stackSizeHistogramHq: StackSizeHistogram = null,
    @SerialName("worldUploadTimes") val worldIdUploadTimes: Map<Short, Long>? = null,
    val listingsCount: Int,
    val recentHistoryCount: Int,
    val unitsForSale: Int,
    val unitsSold: Int,
) : MarketBoard {
    /**
     * The last upload times in milliseconds since epoch for each [World] in the response, if this is a DC request
     */
    @Transient val worldUploadTimes = if (worldIdUploadTimes != null) {
        mutableMapOf<World, Long>().let {
            for (worldUploadTime in worldIdUploadTimes) {
                it[idToWorld.getValue(worldUploadTime.key)] = worldUploadTime.value
            }

            it.toMap()
        }
    } else null
}
