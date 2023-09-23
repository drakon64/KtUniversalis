@file:JvmName("KtUniversalis") @file:JvmMultifileClass @file:OptIn(DelicateCoroutinesApi::class)

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
import kotlinx.coroutines.future.future
import java.util.concurrent.CompletableFuture

/**
 * Returns the history data for the requested list of item IDs and [World].
 * @param world The world to retrieve data for.
 * @param itemId List of item IDs to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidItemException The item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmName("getMarketBoardSaleHistory")
@JvmOverloads
@Throws(InvalidItemException::class, UniversalisException::class)
fun getMarketBoardSaleHistoryAsync(
    world: World,
    itemId: Int,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): CompletableFuture<History> = GlobalScope.future {
    getMarketBoardSaleHistoryArray(
        world.name, intArrayOf(itemId), entriesToReturn, statsWithin, entriesWithin,
    ).body()
}

/**
 * Returns the history data for the requested list of item IDs and [DataCenter].
 * @param dataCenter The [DataCenter] to retrieve data for.
 * @param itemId List of item IDs to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidItemException The item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmName("getMarketBoardSaleHistory")
@JvmOverloads
@Throws(InvalidItemException::class, UniversalisException::class)
fun getMarketBoardSaleHistoryAsync(
    dataCenter: DataCenter,
    itemId: Int,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): CompletableFuture<History> = GlobalScope.future {
    getMarketBoardSaleHistoryArray(
        dataCenter.name,
        intArrayOf(itemId),
        entriesToReturn,
        statsWithin,
        entriesWithin,
    ).body()
}

/**
 * Returns the history data for the requested list of item IDs and [Region].
 * @param region The [Region] to retrieve data for.
 * @param itemId List of item IDs to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidItemException The item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmName("getMarketBoardSaleHistory")
@JvmOverloads
@Throws(InvalidItemException::class, UniversalisException::class)
fun getMarketBoardSaleHistoryAsync(
    region: Region,
    itemId: Int,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): CompletableFuture<History> = GlobalScope.future {
    getMarketBoardSaleHistoryArray(
        if (region == Region.NorthAmerica) "North-America" else region.name,
        intArrayOf(itemId),
        entriesToReturn,
        statsWithin,
        entriesWithin,
    ).body()
}

/**
 * Returns the history data for the requested list of item IDs and world.
 * @param world The world to retrieve data for.
 * @param itemIds The list of item IDs to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmName("getMarketBoardSaleHistory")
@JvmOverloads
@Throws(UniversalisException::class)
fun getMarketBoardSaleHistoryAsync(
    world: World,
    itemIds: IntArray,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): CompletableFuture<Multi<History>> = GlobalScope.future {
    getMarketBoardSaleHistoryArray(
        world.name, itemIds, entriesToReturn, statsWithin, entriesWithin,
    ).body()
}

/**
 * Returns the history data for the requested list of item IDs and [DataCenter].
 * @param dataCenter The [DataCenter] to retrieve data for.
 * @param itemIds The list of item IDs to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmName("getMarketBoardSaleHistory")
@JvmOverloads
@Throws(UniversalisException::class)
fun getMarketBoardSaleHistoryAsync(
    dataCenter: DataCenter,
    itemIds: IntArray,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): CompletableFuture<Multi<History>> = GlobalScope.future {
    getMarketBoardSaleHistoryArray(
        dataCenter.name, itemIds, entriesToReturn, statsWithin, entriesWithin,
    ).body()
}

/**
 * Returns the history data for the requested list of item IDs and [Region].
 * @param region The [Region] to retrieve data for.
 * @param itemIds The list of item IDs to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmName("getMarketBoardSaleHistory")
@JvmOverloads
@Throws(UniversalisException::class)
fun getMarketBoardSaleHistoryAsync(
    region: Region,
    itemIds: IntArray,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): CompletableFuture<Multi<History>> = GlobalScope.future {
    getMarketBoardSaleHistoryArray(
        if (region == Region.NorthAmerica) "North-America" else region.name,
        itemIds,
        entriesToReturn,
        statsWithin,
        entriesWithin,
    ).body()
}
