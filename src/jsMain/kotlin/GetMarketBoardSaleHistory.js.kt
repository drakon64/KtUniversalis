@file:OptIn(DelicateCoroutinesApi::class, ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.entities.History
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
 * Returns the history data for the requested item ID and [World].
 *
 * This function is designed to be used from JavaScript. For use within Kotlin, see [getMarketBoardSaleHistory].
 * @param world The [World] to retrieve data for.
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
    getMarketBoardSaleHistoryArray(
        world.name, listOf(itemId), entriesToReturn, statsWithin, entriesWithin,
    ).body()
}

/**
 * Returns the history data for the requested item ID and [DataCenter].
 *
 * This function is designed to be used from JavaScript. For use within Kotlin, see [getMarketBoardSaleHistory].
 * @param dataCenter The [DataCenter] to retrieve data for.
 * @param itemId The item ID to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidItemException The item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getMarketBoardSaleHistoryByDataCenter")
fun getMarketBoardSaleHistoryAsync(
    dataCenter: DataCenter,
    itemId: Int,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): Promise<History> = GlobalScope.promise {
    getMarketBoardSaleHistoryArray(
        dataCenter.name,
        listOf(itemId),
        entriesToReturn,
        statsWithin,
        entriesWithin,
    ).body()
}

/**
 * Returns the history data for the requested item ID and [Region].
 *
 * This function is designed to be used from JavaScript. For use within Kotlin, see [getMarketBoardSaleHistory].
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
    getMarketBoardSaleHistoryArray(
        region.toString(),
        listOf(itemId),
        entriesToReturn,
        statsWithin,
        entriesWithin,
    ).body()
}
