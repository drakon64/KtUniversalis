@file:OptIn(DelicateCoroutinesApi::class)

package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.exception.InvalidEntriesException
import cloud.drakon.ktuniversalis.exception.InvalidParameterException
import cloud.drakon.ktuniversalis.exception.InvalidWorldDcException
import cloud.drakon.ktuniversalis.exception.InvalidWorldDcItemException
import cloud.drakon.ktuniversalis.exception.InvalidWorldException
import cloud.drakon.ktuniversalis.exception.ItemIdsException
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
 * Returns all data centers supported by the Universalis API. For use outside of Kotlin coroutines.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
fun getAvailableDataCentersAsync() = GlobalScope.future {
    getAvailableDataCenters()
}

/**
 * Returns the IDs and names of all worlds supported by the Universalis API. For use outside of Kotlin coroutines.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
fun getAvailableWorldsAsync() = GlobalScope.future {
    getAvailableWorlds()
}

/**
 * Returns the least-recently updated items on the specified world or data center, along with the upload times for each item. For use outside of Kotlin coroutines.
 * @param world The world to request data for.
 * @param dcName The data center to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws InvalidWorldDcException The world/DC requested is invalid.
 * @throws InvalidEntriesException `entries` must be between `0` and `200`.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
fun getLeastRecentlyUpdatedItemsAsync(
    world: String? = null,
    dcName: String? = null,
    entries: Int? = null,
) = GlobalScope.future {
    getLeastRecentlyUpdatedItems(world, dcName, entries)
}

/**
 * Returns the data currently shown on the market board for the requested list of item IDs and world or data center. For use outside of Kotlin coroutines.
 * @param worldDcRegion The world, data center, or region to retrieve data for. This may be an ID or a name. Regions should be specified as Japan, Europe, North-America, Oceania, China, or 中国.
 * @param itemIds List of item IDs to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param noGst If the result should not have Gil sales tax (GST) factored in. GST is applied to all consumer purchases in-game, and is separate from the retainer city tax that impacts what sellers receive. By default, GST is factored in.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is 7 days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @param fields An list of fields that should be included in the response, if omitted will return all fields. For example if you're only interested in the listings price per unit you can set this to `listings.pricePerUnit`.
 * @throws ItemIdsException At least one and less than or equal to 100 item IDs are required.
 * @throws InvalidParameterException The parameters are invalid.
 * @throws InvalidWorldDcItemException The world/DC or item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
fun getMarketBoardCurrentDataAsync(
    worldDcRegion: String,
    itemIds: List<Int>,
    listings: Int? = null,
    entries: Int? = null,
    noGst: Boolean? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
    fields: List<String>? = null,
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
        fields
    )
}

/**
 * Returns the history data for the requested list of item IDs and world or data center. For use outside of Kotlin coroutines.
 * @param worldDcRegion The world or data center to retrieve data for. This may be an ID or a name. Regions should be specified as Japan, Europe, North-America, Oceania, China, or 中国.
 * @param itemIds List of item IDs to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws ItemIdsException At least one and less than or equal to 100 item IDs are required.
 * @throws InvalidWorldDcItemException The world/DC or item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
fun getMarketBoardSaleHistoryAsync(
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
 * Returns the current tax rate data for the specified world. For use outside of Kotlin coroutines.
 * @param world The world or to retrieve data for. This may be an ID or a name.
 * @throws InvalidWorldException The world requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
fun getMarketTaxRatesAsync(world: String) = GlobalScope.future {
    getMarketTaxRates(world)
}

/**
 * Returns a list of marketable item IDs. For use outside of Kotlin coroutines.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
fun getMarketableItemsAsync() = GlobalScope.future {
    getMarketableItems()
}

/**
 * Returns the most-recently updated items on the specified world or data center, along with the upload times for each item. For use outside of Kotlin coroutines.
 * @param world The world to request data for.
 * @param dcName The data center to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws InvalidWorldDcException The world/DC requested is invalid.
 * @throws InvalidEntriesException `entries` must be between `0` and `200`.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
fun getMostRecentlyUpdatedItemsAsync(
    world: String? = null,
    dcName: String? = null,
    entries: Int? = null,
) = GlobalScope.future {
    getMostRecentlyUpdatedItems(world, dcName, entries)
}

/**
 * Returns the total upload counts for each client application that uploads data to Universalis. For use outside of Kotlin coroutines.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
fun getUploadCountsByUploadApplicationAsync() = GlobalScope.future {
    getUploadCountsByUploadApplication()
}

/**
 * Returns the world upload counts and proportions of the total uploads for each world. For use outside of Kotlin coroutines.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
fun getUploadCountsByWorldAsync() = GlobalScope.future {
    getUploadCountsByWorld()
}

/**
 * Returns the number of uploads per day over the past 30 days. For use outside of Kotlin coroutines.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
fun getUploadsPerDayAsync() = GlobalScope.future {
    getUploadsPerDay()
}
