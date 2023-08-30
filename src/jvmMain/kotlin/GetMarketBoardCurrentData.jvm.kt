@file:JvmName("KtUniversalis") @file:JvmMultifileClass @file:OptIn(DelicateCoroutinesApi::class)

package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.exception.InvalidParametersException
import cloud.drakon.ktuniversalis.exception.InvalidWorldDataCenterItemException
import cloud.drakon.ktuniversalis.exception.UniversalisException
import cloud.drakon.ktuniversalis.world.DataCenter
import cloud.drakon.ktuniversalis.world.Region
import cloud.drakon.ktuniversalis.world.World
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.future.future

/**
 * Returns the data currently shown on the market board for the requested item ID and world.
 * @param world The world to retrieve data for.
 * @param itemId The item ID to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param noGst If the result should not have Gil sales tax (GST) factored in. GST is applied to all consumer purchases in-game, and is separate from the retainer city tax that impacts what sellers receive. By default, GST is factored in.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is 7 days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidParametersException The parameters were invalid.
 * @throws InvalidWorldDataCenterItemException The world/DC or item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmOverloads @Throws(
    InvalidParametersException::class,
    InvalidWorldDataCenterItemException::class,
    UniversalisException::class
) fun getMarketBoardCurrentDataAsync(
    world: World,
    itemId: Int,
    listings: Int? = null,
    entries: Int? = null,
    noGst: Boolean? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
) = GlobalScope.future {
    getMarketBoardCurrentData(
        world,
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
 * Returns the data currently shown on the market board for the requested item ID and data center.
 * @param dcName The data center to retrieve data for.
 * @param itemId The item ID to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param noGst If the result should not have Gil sales tax (GST) factored in. GST is applied to all consumer purchases in-game, and is separate from the retainer city tax that impacts what sellers receive. By default, GST is factored in.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is 7 days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidParametersException The parameters were invalid.
 * @throws InvalidWorldDataCenterItemException The world/DC or item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmOverloads @Throws(
    InvalidParametersException::class,
    InvalidWorldDataCenterItemException::class,
    UniversalisException::class
) fun getMarketBoardCurrentDataAsync(
    dcName: DataCenter,
    itemId: Int,
    listings: Int? = null,
    entries: Int? = null,
    noGst: Boolean? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
) = GlobalScope.future {
    getMarketBoardCurrentData(
        dcName,
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
 * Returns the data currently shown on the market board for the requested item ID and region.
 * @param region The region to retrieve data for.
 * @param itemId The item ID to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param noGst If the result should not have Gil sales tax (GST) factored in. GST is applied to all consumer purchases in-game, and is separate from the retainer city tax that impacts what sellers receive. By default, GST is factored in.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is 7 days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidParametersException The parameters were invalid.
 * @throws InvalidWorldDataCenterItemException The world/DC or item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmOverloads @Throws(
    InvalidParametersException::class,
    InvalidWorldDataCenterItemException::class,
    UniversalisException::class
) fun getMarketBoardCurrentDataAsync(
    region: Region,
    itemId: Int,
    listings: Int? = null,
    entries: Int? = null,
    noGst: Boolean? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
) = GlobalScope.future {
    getMarketBoardCurrentData(
        region,
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
 * Returns the data currently shown on the market board for the requested list of item IDs and world.
 * @param world The world to retrieve data for.
 * @param itemIds The list of item IDs to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param noGst If the result should not have Gil sales tax (GST) factored in. GST is applied to all consumer purchases in-game, and is separate from the retainer city tax that impacts what sellers receive. By default, GST is factored in.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is 7 days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidParametersException The parameters were invalid.
 * @throws InvalidWorldDataCenterItemException The world/DC or item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmOverloads @Throws(
    InvalidParametersException::class,
    InvalidWorldDataCenterItemException::class,
    UniversalisException::class
) fun getMarketBoardCurrentDataAsync(
    world: World,
    itemIds: List<Int>,
    listings: Int? = null,
    entries: Int? = null,
    noGst: Boolean? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
) = GlobalScope.future {
    getMarketBoardCurrentData(
        world,
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
 * Returns the data currently shown on the market board for the requested list of item IDs and data center.
 * @param dcName The data center to retrieve data for.
 * @param itemIds The list of item IDs to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param noGst If the result should not have Gil sales tax (GST) factored in. GST is applied to all consumer purchases in-game, and is separate from the retainer city tax that impacts what sellers receive. By default, GST is factored in.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is 7 days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidParametersException The parameters were invalid.
 * @throws InvalidWorldDataCenterItemException The world/DC or item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmOverloads @Throws(
    InvalidParametersException::class,
    InvalidWorldDataCenterItemException::class,
    UniversalisException::class
) fun getMarketBoardCurrentDataAsync(
    dcName: DataCenter,
    itemIds: List<Int>,
    listings: Int? = null,
    entries: Int? = null,
    noGst: Boolean? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
) = GlobalScope.future {
    getMarketBoardCurrentData(
        dcName,
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
 * Returns the data currently shown on the market board for the requested list of item IDs and region.
 * @param region The region to retrieve data for.
 * @param itemIds The list of item IDs to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param noGst If the result should not have Gil sales tax (GST) factored in. GST is applied to all consumer purchases in-game, and is separate from the retainer city tax that impacts what sellers receive. By default, GST is factored in.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is 7 days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidParametersException The parameters were invalid.
 * @throws InvalidWorldDataCenterItemException The world/DC or item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmOverloads
@Throws(
    InvalidParametersException::class,
    InvalidWorldDataCenterItemException::class,
    UniversalisException::class
) fun getMarketBoardCurrentDataAsync(
    region: Region,
    itemIds: List<Int>,
    listings: Int? = null,
    entries: Int? = null,
    noGst: Boolean? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
) = GlobalScope.future {
    getMarketBoardCurrentData(
        region,
        itemIds,
        listings,
        entries,
        noGst,
        hq,
        statsWithin,
        entriesWithin,
    )
}
