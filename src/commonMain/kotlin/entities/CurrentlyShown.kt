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
 * @property worldUploadTimes The last upload times in milliseconds since epoch for each [World] in the response, if this is a DC request
 * @property listingsCount The number of listings retrieved for the request. When using the `listings` limit parameter, this may be different from the number of sale entries returned.
 * @property recentHistoryCount The number of sale entries retrieved for the request. When using the `entries` limit parameter, this may be different from the number of sale entries returned.
 * @property unitsForSale The number of items (not listings) up for sale.
 * @property unitsSold The number of items (not sale entries) sold over the retrieved sales.
 */
@JsExport @Serializable
data class CurrentlyShown(
    val lastUploadTime: Long,
    val listings: Array<Listing>? = null,
    val recentHistory: Array<Sale>? = null,
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
    @SerialName("worldUploadTimes") private val worldIdUploadTimes: Map<Short, Long>? = null,
    val listingsCount: Int,
    val recentHistoryCount: Int,
    val unitsForSale: Int,
    val unitsSold: Int,
) : MarketBoard {
    @Transient val worldUploadTimes = if (worldIdUploadTimes != null) {
        mutableMapOf<World, Long>().let {
            for (worldUploadTime in worldIdUploadTimes) {
                it[idToWorld.getValue(worldUploadTime.key)] = worldUploadTime.value
            }

            it.toMap()
        }
    } else null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as CurrentlyShown

        if (lastUploadTime != other.lastUploadTime) return false
        if (listings != null) {
            if (other.listings == null) return false
            if (!listings.contentEquals(other.listings)) return false
        } else if (other.listings != null) return false
        if (recentHistory != null) {
            if (other.recentHistory == null) return false
            if (!recentHistory.contentEquals(other.recentHistory)) return false
        } else if (other.recentHistory != null) return false
        if (currentAveragePrice != other.currentAveragePrice) return false
        if (currentAveragePriceNq != other.currentAveragePriceNq) return false
        if (currentAveragePriceHq != other.currentAveragePriceHq) return false
        if (regularSaleVelocity != other.regularSaleVelocity) return false
        if (nqSaleVelocity != other.nqSaleVelocity) return false
        if (hqSaleVelocity != other.hqSaleVelocity) return false
        if (averagePrice != other.averagePrice) return false
        if (averagePriceNq != other.averagePriceNq) return false
        if (averagePriceHq != other.averagePriceHq) return false
        if (minPrice != other.minPrice) return false
        if (minPriceNq != other.minPriceNq) return false
        if (minPriceHq != other.minPriceHq) return false
        if (maxPrice != other.maxPrice) return false
        if (maxPriceNq != other.maxPriceNq) return false
        if (maxPriceHq != other.maxPriceHq) return false
        if (stackSizeHistogram != other.stackSizeHistogram) return false
        if (stackSizeHistogramNq != other.stackSizeHistogramNq) return false
        if (stackSizeHistogramHq != other.stackSizeHistogramHq) return false
        if (listingsCount != other.listingsCount) return false
        if (recentHistoryCount != other.recentHistoryCount) return false
        if (unitsForSale != other.unitsForSale) return false
        if (unitsSold != other.unitsSold) return false
        if (worldUploadTimes != other.worldUploadTimes) return false

        return true
    }

    override fun hashCode(): Int {
        var result = lastUploadTime.hashCode()
        result = 31 * result + (listings?.contentHashCode() ?: 0)
        result = 31 * result + (recentHistory?.contentHashCode() ?: 0)
        result = 31 * result + currentAveragePrice.hashCode()
        result = 31 * result + currentAveragePriceNq.hashCode()
        result = 31 * result + currentAveragePriceHq.hashCode()
        result = 31 * result + regularSaleVelocity.hashCode()
        result = 31 * result + nqSaleVelocity.hashCode()
        result = 31 * result + hqSaleVelocity.hashCode()
        result = 31 * result + averagePrice.hashCode()
        result = 31 * result + averagePriceNq.hashCode()
        result = 31 * result + averagePriceHq.hashCode()
        result = 31 * result + minPrice
        result = 31 * result + minPriceNq
        result = 31 * result + minPriceHq
        result = 31 * result + maxPrice
        result = 31 * result + maxPriceNq
        result = 31 * result + maxPriceHq
        result = 31 * result + (stackSizeHistogram?.hashCode() ?: 0)
        result = 31 * result + (stackSizeHistogramNq?.hashCode() ?: 0)
        result = 31 * result + (stackSizeHistogramHq?.hashCode() ?: 0)
        result = 31 * result + listingsCount
        result = 31 * result + recentHistoryCount
        result = 31 * result + unitsForSale
        result = 31 * result + unitsSold
        result = 31 * result + (worldUploadTimes?.hashCode() ?: 0)
        return result
    }

    override fun toString() = "CurrentlyShown(lastUploadTime=$lastUploadTime, listings=${listings?.contentToString()}, recentHistory=${recentHistory?.contentToString()}, currentAveragePrice=$currentAveragePrice, currentAveragePriceNq=$currentAveragePriceNq, currentAveragePriceHq=$currentAveragePriceHq, regularSaleVelocity=$regularSaleVelocity, nqSaleVelocity=$nqSaleVelocity, hqSaleVelocity=$hqSaleVelocity, averagePrice=$averagePrice, averagePriceNq=$averagePriceNq, averagePriceHq=$averagePriceHq, minPrice=$minPrice, minPriceNq=$minPriceNq, minPriceHq=$minPriceHq, maxPrice=$maxPrice, maxPriceNq=$maxPriceNq, maxPriceHq=$maxPriceHq, stackSizeHistogram=$stackSizeHistogram, stackSizeHistogramNq=$stackSizeHistogramNq, stackSizeHistogramHq=$stackSizeHistogramHq, worldUploadTimes=$worldUploadTimes, listingsCount=$listingsCount, recentHistoryCount=$recentHistoryCount, unitsForSale=$unitsForSale, unitsSold=$unitsSold)"
}
