@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import cloud.drakon.ktuniversalis.world.DataCenter
import cloud.drakon.ktuniversalis.world.World
import kotlin.js.ExperimentalJsExport
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
 * @property currentAveragePriceNq The average NQ listing price, with outliers removed beyond 3 standard deviations of the mean
 * @property currentAveragePriceHq The average HQ listing price, with outliers removed beyond 3 standard deviations of the mean
 * @property regularSaleVelocity The average number of sales per day, over the past seven days (or the entirety of the shown sales, whichever comes first)
 * @property nqSaleVelocity The average number of NQ sales per day, over the past seven days (or the entirety of the shown sales, whichever comes first)
 * @property hqSaleVelocity The average number of HQ sales per day, over the past seven days (or the entirety of the shown sales, whichever comes first)
 * @property averagePrice The average sale price, with outliers removed beyond 3 standard deviations of the mean
 * @property averagePriceNq The average NQ sale price, with outliers removed beyond 3 standard deviations of the mean
 * @property averagePriceHq The average HQ sale price, with outliers removed beyond 3 standard deviations of the mean
 * @property minPrice The minimum listing price
 * @property minPriceNq The minimum NQ listing price
 * @property minPriceHq The minimum HQ listing price
 * @property maxPrice The maximum listing price
 * @property maxPriceNq The maximum NQ listing price
 * @property maxPriceHq The maximum HQ listing price
 * @property stackSizeHistogram A map of quantities to listing counts, representing the number of listings of each quantity
 * @property stackSizeHistogramNq A map of quantities to NQ listing counts, representing the number of listings of each quantity
 * @property stackSizeHistogramHq A map of quantities to HQ listing counts, representing the number of listings of each quantity
 * @property worldName The world name, if applicable
 * @property worldUploadTimes The last upload times in milliseconds since epoch for each world in the response, if this is a DC request
 * @property listingsCount The number of listings retrieved for the request. When using the "listings" limit parameter, this may be different from the number of sale entries returned
 * @property recentHistoryCount The number of sale entries retrieved for the request. When using the "entries" limit parameter, this may be different from the number of sale entries returned
 * @property unitsForSale The number of items (not listings) up for sale
 * @property unitsSold The number of items (not sale entries) sold over the retrieved sales
 */
@JsExport @Serializable data class CurrentlyShown(
    @SerialName("itemID") val itemId: Int,
    @SerialName("worldID") val worldId: Short? = null,
    val lastUploadTime: Long,
    val listings: List<Listing>? = null,
    val recentHistory: List<Sale>? = null,
    val dcName: DataCenter? = null,
    val regionName: String? = null,
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

    @SerialName("stackSizeHistogramNQ")
    val stackSizeHistogramNq: StackSizeHistogram = null,

    @SerialName("stackSizeHistogramHQ")
    val stackSizeHistogramHq: StackSizeHistogram = null,

    val worldName: World? = null,
    val worldUploadTimes: Map<Short, Long>? = null,
    val listingsCount: Int,
    val recentHistoryCount: Int,
    val unitsForSale: Int,
    val unitsSold: Int,
): MarketBoard {
    private companion object {
        private val idToWorld = mapOf(
            21.toShort() to World.Ravana,
            22.toShort() to World.Bismarck,
            23.toShort() to World.Asura,
            24.toShort() to World.Belias,
            28.toShort() to World.Pandaemonium,
            29.toShort() to World.Shinryu,
            30.toShort() to World.Unicorn,
            31.toShort() to World.Yojimbo,
            32.toShort() to World.Zeromus,
            33.toShort() to World.Twintania,
            34.toShort() to World.Brynhildr,
            35.toShort() to World.Famfrit,
            36.toShort() to World.Lich,
            37.toShort() to World.Mateus,
            39.toShort() to World.Omega,
            40.toShort() to World.Jenova,
            41.toShort() to World.Zalera,
            42.toShort() to World.Zodiark,
            43.toShort() to World.Alexander,
            44.toShort() to World.Anima,
            45.toShort() to World.Carbuncle,
            46.toShort() to World.Fenrir,
            47.toShort() to World.Hades,
            48.toShort() to World.Ixion,
            49.toShort() to World.Kujata,
            50.toShort() to World.Typhon,
            51.toShort() to World.Ultima,
            52.toShort() to World.Valefor,
            53.toShort() to World.Exodus,
            54.toShort() to World.Faerie,
            55.toShort() to World.Lamia,
            56.toShort() to World.Phoenix,
            57.toShort() to World.Siren,
            58.toShort() to World.Garuda,
            59.toShort() to World.Ifrit,
            60.toShort() to World.Ramuh,
            61.toShort() to World.Titan,
            62.toShort() to World.Diabolos,
            63.toShort() to World.Gilgamesh,
            64.toShort() to World.Leviathan,
            65.toShort() to World.Midgardsormr,
            66.toShort() to World.Odin,
            67.toShort() to World.Shiva,
            68.toShort() to World.Atomos,
            69.toShort() to World.Bahamut,
            70.toShort() to World.Chocobo,
            71.toShort() to World.Moogle,
            72.toShort() to World.Tonberry,
            73.toShort() to World.Adamantoise,
            74.toShort() to World.Coeurl,
            75.toShort() to World.Malboro,
            76.toShort() to World.Tiamat,
            77.toShort() to World.Ultros,
            78.toShort() to World.Behemoth,
            79.toShort() to World.Cactuar,
            80.toShort() to World.Cerberus,
            81.toShort() to World.Goblin,
            82.toShort() to World.Mandragora,
            83.toShort() to World.Louisoix,
            85.toShort() to World.Spriggan,
            86.toShort() to World.Sephirot,
            87.toShort() to World.Sophia,
            88.toShort() to World.Zurvan,
            90.toShort() to World.Aegis,
            91.toShort() to World.Balmung,
            92.toShort() to World.Durandal,
            93.toShort() to World.Excalibur,
            94.toShort() to World.Gungnir,
            95.toShort() to World.Hyperion,
            96.toShort() to World.Masamune,
            97.toShort() to World.Ragnarok,
            98.toShort() to World.Ridill,
            99.toShort() to World.Sargatanas,
            400.toShort() to World.Sagittarius,
            401.toShort() to World.Phantom,
            402.toShort() to World.Alpha,
            403.toShort() to World.Raiden,
            404.toShort() to World.Marilith,
            405.toShort() to World.Seraph,
            406.toShort() to World.Halicarnassus,
            407.toShort() to World.Maduin,
            1167.toShort() to World.红玉海,
            1081.toShort() to World.神意之地,
            1042.toShort() to World.拉诺西亚,
            1044.toShort() to World.幻影群岛,
            1060.toShort() to World.萌芽池,
            1173.toShort() to World.宇宙和音,
            1174.toShort() to World.沃仙曦染,
            1175.toShort() to World.晨曦王座,
            1172.toShort() to World.白银乡,
            1076.toShort() to World.白金幻象,
            1171.toShort() to World.神拳痕,
            1170.toShort() to World.潮风亭,
            1113.toShort() to World.旅人栈桥,
            1121.toShort() to World.拂晓之间,
            1166.toShort() to World.龙巢神殿,
            1176.toShort() to World.梦羽宝境,
            1043.toShort() to World.紫水栈桥,
            1169.toShort() to World.延夏,
            1106.toShort() to World.静语庄园,
            1045.toShort() to World.摩杜纳,
            1177.toShort() to World.海猫茶屋,
            1178.toShort() to World.柔风海湾,
            1179.toShort() to World.琥珀原,
            1192.toShort() to World.水晶塔,
            1183.toShort() to World.银泪湖,
            1180.toShort() to World.太阳海岸,
            1186.toShort() to World.伊修加德,
            1201.toShort() to World.红茶川,
            1068.toShort() to World.黄金谷,
            1064.toShort() to World.月牙湾,
            1187.toShort() to World.雪松原,
            2075.toShort() to World.카벙클,
            2076.toShort() to World.초코보,
            2077.toShort() to World.모그리,
            2078.toShort() to World.톤베리,
            2080.toShort() to World.펜리르
        )
    }

    /**
     * The last upload times in milliseconds since epoch for each world in the response, if this is a DC request
     */
    val worldNameUploadTimes =
        if (worldUploadTimes != null) mutableMapOf<World, Long>().let {
            for (i in worldUploadTimes) it[idToWorld.getValue(i.key)] = i.value

            it.toMap()
        } else null
}
