package cloud.drakon.ktuniversalis.response

import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
