@file:JvmName("KtUniversalis") @file:JvmMultifileClass @file:OptIn(DelicateCoroutinesApi::class)

package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.entities.CurrentlyShown
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
 * Returns the data currently shown on the market board for the requested item ID and [World].
 *
 * This function is designed to be used from non-Kotlin JVM languages. For use within Kotlin, see [getMarketBoardCurrentData].
 * @param world The [World] to retrieve data for.
 * @param itemId The item ID to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param noGst If the result should not have Gil sales tax (GST) factored in. GST is applied to all consumer purchases in-game, and is separate from the retainer city tax that impacts what sellers receive. By default, GST is factored in.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is 7 days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidItemException The item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmName("getMarketBoardCurrentData")
@JvmOverloads
@Throws(InvalidItemException::class, UniversalisException::class)
fun getMarketBoardCurrentDataAsync(
    world: World,
    itemId: Int,
    listings: Int? = null,
    entries: Int? = null,
    noGst: Boolean? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): CompletableFuture<CurrentlyShown> = GlobalScope.future {
    getMarketBoardCurrentDataArray(
        world.name,
        intArrayOf(itemId),
        listings,
        entries,
        noGst,
        hq,
        statsWithin,
        entriesWithin,
    ).body()
}

/**
 * Returns the data currently shown on the market board for the requested item ID and [DataCenter].
 *
 * This function is designed to be used from non-Kotlin JVM languages. For use within Kotlin, see [getMarketBoardCurrentData].
 * @param dataCenter The [DataCenter] to retrieve data for.
 * @param itemId The item ID to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param noGst If the result should not have Gil sales tax (GST) factored in. GST is applied to all consumer purchases in-game, and is separate from the retainer city tax that impacts what sellers receive. By default, GST is factored in.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is 7 days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidItemException The item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmName("getMarketBoardCurrentData")
@JvmOverloads
@Throws(InvalidItemException::class, UniversalisException::class)
fun getMarketBoardCurrentDataAsync(
    dataCenter: DataCenter,
    itemId: Int,
    listings: Int? = null,
    entries: Int? = null,
    noGst: Boolean? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): CompletableFuture<CurrentlyShown> = GlobalScope.future {
    getMarketBoardCurrentDataArray(
        dataCenter.name,
        intArrayOf(itemId),
        listings,
        entries,
        noGst,
        hq,
        statsWithin,
        entriesWithin,
    ).body()
}

/**
 * Returns the data currently shown on the market board for the requested item ID and [Region].
 *
 * This function is designed to be used from non-Kotlin JVM languages. For use within Kotlin, see [getMarketBoardCurrentData].
 * @param region The [Region] to retrieve data for.
 * @param itemId The item ID to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param noGst If the result should not have Gil sales tax (GST) factored in. GST is applied to all consumer purchases in-game, and is separate from the retainer city tax that impacts what sellers receive. By default, GST is factored in.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is 7 days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidItemException The item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmName("getMarketBoardCurrentData")
@JvmOverloads
@Throws(InvalidItemException::class, UniversalisException::class)
fun getMarketBoardCurrentDataAsync(
    region: Region,
    itemId: Int,
    listings: Int? = null,
    entries: Int? = null,
    noGst: Boolean? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): CompletableFuture<CurrentlyShown> = GlobalScope.future {
    getMarketBoardCurrentDataArray(
        region.toString(),
        intArrayOf(itemId),
        listings,
        entries,
        noGst,
        hq,
        statsWithin,
        entriesWithin,
    ).body()
}

/**
 * Returns the data currently shown on the market board for the requested [IntArray] of item IDs and [World].
 *
 * This function is designed to be used from non-Kotlin JVM languages. For use within Kotlin, see [getMarketBoardCurrentData].
 * @param world The [World] to retrieve data for.
 * @param itemIds The [IntArray] of item IDs to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param noGst If the result should not have Gil sales tax (GST) factored in. GST is applied to all consumer purchases in-game, and is separate from the retainer city tax that impacts what sellers receive. By default, GST is factored in.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is 7 days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmName("getMarketBoardCurrentData")
@JvmOverloads
@Throws(UniversalisException::class)
fun getMarketBoardCurrentDataAsync(
    world: World,
    itemIds: IntArray,
    listings: Int? = null,
    entries: Int? = null,
    noGst: Boolean? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): CompletableFuture<Multi<CurrentlyShown>> = GlobalScope.future {
    getMarketBoardCurrentDataArray(
        world.name,
        itemIds,
        listings,
        entries,
        noGst,
        hq,
        statsWithin,
        entriesWithin,
    ).body()
}

/**
 * Returns the data currently shown on the market board for the requested array of item IDs and [DataCenter].
 *
 * This function is designed to be used from non-Kotlin JVM languages. For use within Kotlin, see [getMarketBoardCurrentData].
 * @param dataCenter The [DataCenter] to retrieve data for.
 * @param itemIds The array of item IDs to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param noGst If the result should not have Gil sales tax (GST) factored in. GST is applied to all consumer purchases in-game, and is separate from the retainer city tax that impacts what sellers receive. By default, GST is factored in.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is 7 days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmName("getMarketBoardCurrentData")
@JvmOverloads
@Throws(UniversalisException::class)
fun getMarketBoardCurrentDataAsync(
    dataCenter: DataCenter,
    itemIds: IntArray,
    listings: Int? = null,
    entries: Int? = null,
    noGst: Boolean? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): CompletableFuture<Multi<CurrentlyShown>> = GlobalScope.future {
    getMarketBoardCurrentDataArray(
        dataCenter.name,
        itemIds,
        listings,
        entries,
        noGst,
        hq,
        statsWithin,
        entriesWithin,
    ).body()
}

/**
 * Returns the data currently shown on the market board for the requested array of item IDs and [Region].
 *
 * This function is designed to be used from non-Kotlin JVM languages. For use within Kotlin, see [getMarketBoardCurrentData].
 * @param region The [Region] to retrieve data for.
 * @param itemIds The array of item IDs to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param noGst If the result should not have Gil sales tax (GST) factored in. GST is applied to all consumer purchases in-game, and is separate from the retainer city tax that impacts what sellers receive. By default, GST is factored in.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is 7 days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmName("getMarketBoardCurrentData")
@JvmOverloads
@Throws(UniversalisException::class)
fun getMarketBoardCurrentDataAsync(
    region: Region,
    itemIds: IntArray,
    listings: Int? = null,
    entries: Int? = null,
    noGst: Boolean? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): CompletableFuture<Multi<CurrentlyShown>> = GlobalScope.future {
    getMarketBoardCurrentDataArray(
        region.toString(),
        itemIds,
        listings,
        entries,
        noGst,
        hq,
        statsWithin,
        entriesWithin,
    ).body()
}
