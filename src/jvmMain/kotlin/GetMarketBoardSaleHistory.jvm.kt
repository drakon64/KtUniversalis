@file:JvmName("KtUniversalis") @file:JvmMultifileClass @file:OptIn(DelicateCoroutinesApi::class)

package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.exception.UniversalisException
import cloud.drakon.ktuniversalis.world.DataCenter
import cloud.drakon.ktuniversalis.world.Region
import cloud.drakon.ktuniversalis.world.World
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.future.future

/**
 * Returns the history data for the requested list of item IDs and world.
 * @param world The world to retrieve data for.
 * @param itemId List of item IDs to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmOverloads @Throws(UniversalisException::class) fun getMarketBoardSaleHistoryAsync(
    world: World,
    itemId: Int,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
) = GlobalScope.future {
    getMarketBoardSaleHistory(
        world, itemId, entriesToReturn, statsWithin, entriesWithin
    )
}

/**
 * Returns the history data for the requested list of item IDs and data center.
 * @param dcName The data center to retrieve data for.
 * @param itemId List of item IDs to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmOverloads @Throws(UniversalisException::class) fun getMarketBoardSaleHistoryAsync(
    dcName: DataCenter,
    itemId: Int,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
) = GlobalScope.future {
    getMarketBoardSaleHistory(
        dcName, itemId, entriesToReturn, statsWithin, entriesWithin
    )
}

/**
 * Returns the history data for the requested list of item IDs and region.
 * @param region The region to retrieve data for.
 * @param itemId List of item IDs to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmOverloads @Throws(UniversalisException::class) fun getMarketBoardSaleHistoryAsync(
    region: Region,
    itemId: Int,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
) = GlobalScope.future {
    getMarketBoardSaleHistory(
        region, itemId, entriesToReturn, statsWithin, entriesWithin
    )
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
@JvmOverloads @Throws(UniversalisException::class) fun getMarketBoardSaleHistoryAsync(
    world: World,
    itemIds: List<Int>,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
) = GlobalScope.future {
    getMarketBoardSaleHistory(
        world, itemIds, entriesToReturn, statsWithin, entriesWithin
    )
}

/**
 * Returns the history data for the requested list of item IDs and data center.
 * @param dcName The data center to retrieve data for.
 * @param itemIds The list of item IDs to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmOverloads @Throws(UniversalisException::class) fun getMarketBoardSaleHistoryAsync(
    dcName: DataCenter,
    itemIds: List<Int>,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
) = GlobalScope.future {
    getMarketBoardSaleHistory(
        dcName, itemIds, entriesToReturn, statsWithin, entriesWithin
    )
}

/**
 * Returns the history data for the requested list of item IDs and region.
 * @param region The region to retrieve data for.
 * @param itemIds The list of item IDs to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmOverloads @Throws(UniversalisException::class) fun getMarketBoardSaleHistoryAsync(
    region: Region,
    itemIds: List<Int>,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
) = GlobalScope.future {
    getMarketBoardSaleHistory(
        region, itemIds, entriesToReturn, statsWithin, entriesWithin
    )
}
