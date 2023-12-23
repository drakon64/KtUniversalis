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
 * Retrieves the history data for the requested item and [World].
 *
 * This function is designed to be used from non-Kotlin JVM languages. For use within Kotlin, see [getMarketBoardSaleHistory].
 * @param itemId The item ID to retrieve data for.
 * @param world The [World] to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.  By default, this is `7` days.
 * @param minSalePrice The inclusive minimum unit sale price of entries to return.
 * @param maxSalePrice The inclusive maximum unit sale price of entries to return.
 * @throws InvalidItemException The item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmName("getMarketBoardSaleHistory")
@JvmOverloads
@Throws(InvalidItemException::class, UniversalisException::class)
fun getMarketBoardSaleHistoryAsync(
    itemId: Int,
    world: World,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
    minSalePrice: Int? = null,
    maxSalePrice: Int? = null,
): CompletableFuture<History> = GlobalScope.future {
    getMarketBoardSaleHistoryList(
        listOf(itemId),
        world.name,
        entriesToReturn,
        statsWithin,
        entriesWithin,
        minSalePrice,
        maxSalePrice,
    ).body()
}

/**
 * Retrieves the history data for the requested item and [DataCenter].
 *
 * This function is designed to be used from non-Kotlin JVM languages. For use within Kotlin, see [getMarketBoardSaleHistory].
 * @param itemId The item ID to retrieve data for.
 * @param dataCenter The [DataCenter] to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.  By default, this is `7` days.
 * @param minSalePrice The inclusive minimum unit sale price of entries to return.
 * @param maxSalePrice The inclusive maximum unit sale price of entries to return.
 * @throws InvalidItemException The item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmName("getMarketBoardSaleHistory")
@JvmOverloads
@Throws(InvalidItemException::class, UniversalisException::class)
fun getMarketBoardSaleHistoryAsync(
    itemId: Int,
    dataCenter: DataCenter,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
    minSalePrice: Int? = null,
    maxSalePrice: Int? = null,
): CompletableFuture<History> = GlobalScope.future {
    getMarketBoardSaleHistoryList(
        listOf(itemId),
        dataCenter.name,
        entriesToReturn,
        statsWithin,
        entriesWithin,
        minSalePrice,
        maxSalePrice,
    ).body()
}

/**
 * Retrieves the history data for the requested item and [Region].
 *
 * This function is designed to be used from non-Kotlin JVM languages. For use within Kotlin, see [getMarketBoardSaleHistory].
 * @param itemId The item ID to retrieve data for.
 * @param region The [Region] to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.  By default, this is `7` days.
 * @param minSalePrice The inclusive minimum unit sale price of entries to return.
 * @param maxSalePrice The inclusive maximum unit sale price of entries to return.
 * @throws InvalidItemException The item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmName("getMarketBoardSaleHistory")
@JvmOverloads
@Throws(InvalidItemException::class, UniversalisException::class)
fun getMarketBoardSaleHistoryAsync(
    itemId: Int,
    region: Region,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
    minSalePrice: Int? = null,
    maxSalePrice: Int? = null,
): CompletableFuture<History> = GlobalScope.future {
    getMarketBoardSaleHistoryList(
        listOf(itemId),
        region.toString(),
        entriesToReturn,
        statsWithin,
        entriesWithin,
        minSalePrice,
        maxSalePrice,
    ).body()
}

/**
 * Retrieves the history data for the requested list of items and [World].
 *
 * This function is designed to be used from non-Kotlin JVM languages. For use within Kotlin, see [getMarketBoardSaleHistory].
 * @param itemIds The list of item IDs to retrieve data for.
 * @param world The [World] to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.  By default, this is `7` days.
 * @param minSalePrice The inclusive minimum unit sale price of entries to return.
 * @param maxSalePrice The inclusive maximum unit sale price of entries to return.
 * @throws InvalidItemException The item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmName("getMarketBoardSaleHistory")
@JvmOverloads
@Throws(UniversalisException::class)
fun getMarketBoardSaleHistoryAsync(
    itemIds: List<Int>,
    world: World,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
    minSalePrice: Int? = null,
    maxSalePrice: Int? = null,
): CompletableFuture<Multi<History>> = GlobalScope.future {
    getMarketBoardSaleHistoryList(
        itemIds,
        world.name,
        entriesToReturn,
        statsWithin,
        entriesWithin,
        minSalePrice,
        maxSalePrice,
    ).body()
}

/**
 * Retrieves the history data for the requested list of items and [DataCenter].
 *
 * This function is designed to be used from non-Kotlin JVM languages. For use within Kotlin, see [getMarketBoardSaleHistory].
 * @param itemIds The list of item IDs to retrieve data for.
 * @param dataCenter The [DataCenter] to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.  By default, this is `7` days.
 * @param minSalePrice The inclusive minimum unit sale price of entries to return.
 * @param maxSalePrice The inclusive maximum unit sale price of entries to return.
 * @throws InvalidItemException The item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmName("getMarketBoardSaleHistory")
@JvmOverloads
@Throws(UniversalisException::class)
fun getMarketBoardSaleHistoryAsync(
    itemIds: List<Int>,
    dataCenter: DataCenter,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
    minSalePrice: Int? = null,
    maxSalePrice: Int? = null,
): CompletableFuture<Multi<History>> = GlobalScope.future {
    getMarketBoardSaleHistoryList(
        itemIds,
        dataCenter.name,
        entriesToReturn,
        statsWithin,
        entriesWithin,
        minSalePrice,
        maxSalePrice,
    ).body()
}

/**
 * Retrieves the history data for the requested list of items and [Region].
 *
 * This function is designed to be used from non-Kotlin JVM languages. For use within Kotlin, see [getMarketBoardSaleHistory].
 * @param itemIds The list of item IDs to retrieve data for.
 * @param region The [Region] to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.  By default, this is `7` days.
 * @param minSalePrice The inclusive minimum unit sale price of entries to return.
 * @param maxSalePrice The inclusive maximum unit sale price of entries to return.
 * @throws InvalidItemException The item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmName("getMarketBoardSaleHistory")
@JvmOverloads
@Throws(UniversalisException::class)
fun getMarketBoardSaleHistoryAsync(
    itemIds: List<Int>,
    region: Region,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
    minSalePrice: Int? = null,
    maxSalePrice: Int? = null,
): CompletableFuture<Multi<History>> = GlobalScope.future {
    getMarketBoardSaleHistoryList(
        itemIds,
        region.toString(),
        entriesToReturn,
        statsWithin,
        entriesWithin,
        minSalePrice,
        maxSalePrice,
    ).body()
}
