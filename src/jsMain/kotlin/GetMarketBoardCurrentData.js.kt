@file:OptIn(DelicateCoroutinesApi::class, ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.entities.CurrentlyShown
import cloud.drakon.ktuniversalis.entities.Multi
import cloud.drakon.ktuniversalis.exception.InvalidItemException
import cloud.drakon.ktuniversalis.exception.InvalidParametersException
import cloud.drakon.ktuniversalis.exception.UniversalisException
import cloud.drakon.ktuniversalis.world.DataCenter
import cloud.drakon.ktuniversalis.world.Region
import cloud.drakon.ktuniversalis.world.World
import io.ktor.client.call.body
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import kotlin.js.Promise

/**
 * Retrieves the data currently shown on the market board for the requested item and [World].
 *
 * This function is designed to be used from JavaScript. For use within Kotlin, see [getMarketBoardCurrentData].
 * @param itemId The item ID to retrieve data for.
 * @param world The [World] to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidItemException The item requested is invalid.
 * @throws InvalidParametersException The parameters were invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getMarketBoardCurrentDataByWorld")
fun getMarketBoardCurrentDataAsync(
    itemId: Int,
    world: World,
    listings: Int? = null,
    entries: Int? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): Promise<CurrentlyShown> = GlobalScope.promise {
    getMarketBoardCurrentDataList(
        listOf(itemId),
        world.name,
        listings,
        entries,
        hq,
        statsWithin,
        entriesWithin,
    ).body()
}

/**
 * Retrieves the data currently shown on the market board for the requested item and [DataCenter].
 *
 * This function is designed to be used from JavaScript. For use within Kotlin, see [getMarketBoardCurrentData].
 * @param itemId The item ID to retrieve data for.
 * @param dataCenter The [DataCenter] to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidItemException The item requested is invalid.
 * @throws InvalidParametersException The parameters were invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getMarketBoardCurrentDataByDataCenter")
fun getMarketBoardCurrentDataAsync(
    itemId: Int,
    dataCenter: DataCenter,
    listings: Int? = null,
    entries: Int? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): Promise<CurrentlyShown> = GlobalScope.promise {
    getMarketBoardCurrentDataList(
        listOf(itemId),
        dataCenter.name,
        listings,
        entries,
        hq,
        statsWithin,
        entriesWithin,
    ).body()
}

/**
 * Retrieves the data currently shown on the market board for the requested item and [Region].
 *
 * This function is designed to be used from JavaScript. For use within Kotlin, see [getMarketBoardCurrentData].
 * @param itemId The item ID to retrieve data for.
 * @param region The [Region] to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidItemException The item requested is invalid.
 * @throws InvalidParametersException The parameters were invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getMarketBoardCurrentDataByRegion")
fun getMarketBoardCurrentDataAsync(
    itemId: Int,
    region: Region,
    listings: Int? = null,
    entries: Int? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): Promise<CurrentlyShown> = GlobalScope.promise {
    getMarketBoardCurrentDataList(
        listOf(itemId),
        region.toString(),
        listings,
        entries,
        hq,
        statsWithin,
        entriesWithin,
    ).body()
}

/**
 * Retrieves the data currently shown on the market board for the requested array of items and [World].
 *
 * This function is designed to be used from JavaScript. For use within Kotlin, see [getMarketBoardCurrentData].
 * @param itemIds The array of item ID to retrieve data for.
 * @param world The [World] to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidParametersException The parameters were invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getMarketBoardCurrentDataListByWorld")
fun getMarketBoardCurrentDataAsync(
    itemIds: IntArray,
    world: World,
    listings: Int? = null,
    entries: Int? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): Promise<Multi<CurrentlyShown>> = GlobalScope.promise {
    getMarketBoardCurrentDataList(
        itemIds.toList(),
        world.name,
        listings,
        entries,
        hq,
        statsWithin,
        entriesWithin,
    ).body()
}

/**
 * Retrieves the data currently shown on the market board for the requested array of items and [DataCenter].
 *
 * This function is designed to be used from JavaScript. For use within Kotlin, see [getMarketBoardCurrentData].
 * @param itemIds The array of item ID to retrieve data for.
 * @param dataCenter The [DataCenter] to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidParametersException The parameters were invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getMarketBoardCurrentDataListByDataCenter")
fun getMarketBoardCurrentDataAsync(
    itemIds: IntArray,
    dataCenter: DataCenter,
    listings: Int? = null,
    entries: Int? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): Promise<Multi<CurrentlyShown>> = GlobalScope.promise {
    getMarketBoardCurrentDataList(
        itemIds.toList(),
        dataCenter.name,
        listings,
        entries,
        hq,
        statsWithin,
        entriesWithin,
    ).body()
}

/**
 * Retrieves the data currently shown on the market board for the requested array of items and [Region].
 *
 * This function is designed to be used from JavaScript. For use within Kotlin, see [getMarketBoardCurrentData].
 * @param itemIds The array of item ID to retrieve data for.
 * @param region The [Region] to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidParametersException The parameters were invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getMarketBoardCurrentDataListByRegion")
fun getMarketBoardCurrentDataAsync(
    itemIds: IntArray,
    region: Region,
    listings: Int? = null,
    entries: Int? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): Promise<Multi<CurrentlyShown>> = GlobalScope.promise {
    getMarketBoardCurrentDataList(
        itemIds.toList(),
        region.toString(),
        listings,
        entries,
        hq,
        statsWithin,
        entriesWithin,
    ).body()
}
