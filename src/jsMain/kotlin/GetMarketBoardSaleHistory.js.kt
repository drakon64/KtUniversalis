@file:OptIn(DelicateCoroutinesApi::class, ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.entities.History
import cloud.drakon.ktuniversalis.entities.Multi
import cloud.drakon.ktuniversalis.exception.InvalidItemException
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
 * Returns the history data for the requested item ID and world.
 * @param world The world to retrieve data for.
 * @param itemId The item ID to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidItemException The item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getMarketBoardSaleHistoryByWorld")
fun getMarketBoardSaleHistoryAsync(
    world: World,
    itemId: Int,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): Promise<History> = GlobalScope.promise {
    getMarketBoardSaleHistoryList(
        world.name,
        listOf(itemId),
        entriesToReturn,
        statsWithin,
        entriesWithin,
    ).body()
}

/**
 * Returns the history data for the requested item ID and [DataCenter].
 * @param dcName The [DataCenter] to retrieve data for.
 * @param itemId The item ID to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidItemException The item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getMarketBoardSaleHistoryByDataCenter")
fun getMarketBoardSaleHistoryAsync(
    dcName: DataCenter,
    itemId: Int,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): Promise<History> = GlobalScope.promise {
    getMarketBoardSaleHistoryList(
        dcName.name,
        listOf(itemId),
        entriesToReturn,
        statsWithin,
        entriesWithin,
    ).body()
}

/**
 * Returns the history data for the requested item ID and [Region].
 * @param region The [Region] to retrieve data for.
 * @param itemId The item ID to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidItemException The item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getMarketBoardSaleHistoryByRegion")
fun getMarketBoardSaleHistoryAsync(
    region: Region,
    itemId: Int,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): Promise<History> = GlobalScope.promise {
    getMarketBoardSaleHistoryList(
        region.name,
        listOf(itemId),
        entriesToReturn,
        statsWithin,
        entriesWithin,
    ).body()
}

/**
 * Returns the history data for the requested array of item IDs and world.
 * @param world The world to retrieve data for.
 * @param itemIds The array of item IDs to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidItemException The item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getMarketBoardSaleHistoryByWorldMulti")
fun getMarketBoardSaleHistoryAsync(
    world: World,
    itemIds: IntArray,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): Promise<Multi<History>> = GlobalScope.promise {
    getMarketBoardSaleHistoryList(
        world.name,
        itemIds.toList(),
        entriesToReturn,
        statsWithin,
        entriesWithin,
    ).body()
}

/**
 * Returns the history data for the requested array of item IDs and [DataCenter].
 * @param dcName The [DataCenter] to retrieve data for.
 * @param itemIds The array of item IDs to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidItemException The item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getMarketBoardSaleHistoryByDataCenterMulti")
fun getMarketBoardSaleHistoryAsync(
    dcName: DataCenter,
    itemIds: IntArray,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): Promise<Multi<History>> = GlobalScope.promise {
    getMarketBoardSaleHistoryList(
        dcName.name,
        itemIds.toList(),
        entriesToReturn,
        statsWithin,
        entriesWithin,
    ).body()
}

/**
 * Returns the history data for the requested array of item IDs and [Region].
 * @param region The world to retrieve data for.
 * @param itemIds The array of item IDs to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidItemException The item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getMarketBoardSaleHistoryByRegionMulti")
fun getMarketBoardSaleHistoryAsync(
    region: Region,
    itemIds: IntArray,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): Promise<Multi<History>> = GlobalScope.promise {
    getMarketBoardSaleHistoryList(
        region.name,
        itemIds.toList(),
        entriesToReturn,
        statsWithin,
        entriesWithin,
    ).body()
}
