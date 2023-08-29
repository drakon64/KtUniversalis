@file:JvmName("KtUniversalis") @file:JvmMultifileClass @file:OptIn(DelicateCoroutinesApi::class)

package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.exception.UniversalisException
import io.ktor.client.HttpClient
import io.ktor.client.engine.java.Java
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.future.future

internal actual val ktorClient = HttpClient(Java) {
    install(ContentNegotiation) {
        json()
    }

    install(DefaultRequest) {
        url("https://universalis.app/api/v2/")
    }
}

/**
 * Returns all data centers supported by the Universalis API.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@Throws(UniversalisException::class) fun getAvailableDataCentersAsync() =
    GlobalScope.future {
        getAvailableDataCenters()
    }

/**
 * Returns the IDs and names of all worlds supported by the Universalis API.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@Throws(UniversalisException::class) fun getAvailableWorldsAsync() =
    GlobalScope.future {
        getAvailableWorlds()
    }

/**
 * Returns the data currently shown on the market board for the requested item ID and world or data center.
 * @param worldDcRegion The world, data center, or region to retrieve data for. This may be an ID or a name. Regions should be specified as Japan, Europe, North-America, Oceania, China, or 中国.
 * @param itemId The item ID to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param noGst If the result should not have Gil sales tax (GST) factored in. GST is applied to all consumer purchases in-game, and is separate from the retainer city tax that impacts what sellers receive. By default, GST is factored in.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is 7 days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmOverloads @Throws(UniversalisException::class) fun getMarketBoardCurrentDataAsync(
    worldDcRegion: String,
    itemId: Int,
    listings: Int? = null,
    entries: Int? = null,
    noGst: Boolean? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
) = GlobalScope.future {
    getMarketBoardCurrentData(
        worldDcRegion,
        itemId,
        listings,
        entries,
        noGst,
        hq,
        statsWithin,
        entriesWithin,
    )
}

/**
 * Returns the data currently shown on the market board for the requested list of item IDs and world or data center.
 * @param worldDcRegion The world, data center, or region to retrieve data for. This may be an ID or a name. Regions should be specified as Japan, Europe, North-America, Oceania, China, or 中国.
 * @param itemIds The list of item IDs to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param noGst If the result should not have Gil sales tax (GST) factored in. GST is applied to all consumer purchases in-game, and is separate from the retainer city tax that impacts what sellers receive. By default, GST is factored in.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is 7 days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmOverloads @Throws(UniversalisException::class) fun getMarketBoardCurrentDataAsync(
    worldDcRegion: String,
    itemIds: List<Int>,
    listings: Int? = null,
    entries: Int? = null,
    noGst: Boolean? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
) = GlobalScope.future {
    getMarketBoardCurrentData(
        worldDcRegion,
        itemIds,
        listings,
        entries,
        noGst,
        hq,
        statsWithin,
        entriesWithin,
    )
}

/**
 * Returns the history data for the requested list of item IDs and world or data center.
 * @param worldDcRegion The world or data center to retrieve data for. This may be an ID or a name. Regions should be specified as Japan, Europe, North-America, Oceania, China, or 中国.
 * @param itemId List of item IDs to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmOverloads @Throws(UniversalisException::class) fun getMarketBoardSaleHistoryAsync(
    worldDcRegion: String,
    itemId: Int,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
) = GlobalScope.future {
    getMarketBoardSaleHistory(
        worldDcRegion, itemId, entriesToReturn, statsWithin, entriesWithin
    )
}

/**
 * Returns the history data for the requested list of item IDs and world or data center.
 * @param worldDcRegion The world or data center to retrieve data for. This may be an ID or a name. Regions should be specified as Japan, Europe, North-America, Oceania, China, or 中国.
 * @param itemIds The list of item IDs to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmOverloads @Throws(UniversalisException::class) fun getMarketBoardSaleHistoryAsync(
    worldDcRegion: String,
    itemIds: List<Int>,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
) = GlobalScope.future {
    getMarketBoardSaleHistory(
        worldDcRegion, itemIds, entriesToReturn, statsWithin, entriesWithin
    )
}

/**
 * Returns the current tax rate data for the specified world.
 * @param world The world or to retrieve data for. This may be an ID or a name.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@Throws(UniversalisException::class) fun getMarketTaxRatesAsync(world: String) =
    GlobalScope.future {
        getMarketTaxRates(world)
    }

/**
 * Returns a list of marketable item IDs.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@Throws(UniversalisException::class) fun getMarketableItemsAsync() =
    GlobalScope.future {
        getMarketableItems()
    }

/**
 * Returns the total upload counts for each client application that uploads data to Universalis.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@Throws(UniversalisException::class) fun getUploadCountsByUploadApplicationAsync() =
    GlobalScope.future {
        getUploadCountsByUploadApplication()
    }

/**
 * Returns the world upload counts and proportions of the total uploads for each world.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@Throws(UniversalisException::class) fun getUploadCountsByWorldAsync() =
    GlobalScope.future {
        getUploadCountsByWorld()
    }

/**
 * Returns the number of uploads per day over the past 30 days.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@Throws(UniversalisException::class) fun getUploadsPerDayAsync() = GlobalScope.future {
    getUploadsPerDay()
}
