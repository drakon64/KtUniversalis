package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.entities.CurrentlyShown
import cloud.drakon.ktuniversalis.entities.Multi
import cloud.drakon.ktuniversalis.exception.InvalidWorldDataCenterItemException
import cloud.drakon.ktuniversalis.exception.UniversalisException
import cloud.drakon.ktuniversalis.world.DataCenter
import cloud.drakon.ktuniversalis.world.Region
import cloud.drakon.ktuniversalis.world.World
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

internal suspend fun getMarketBoardCurrentDataList(
    worldDcRegion: String,
    itemIds: List<Int>,
    listings: Int? = null,
    entries: Int? = null,
    noGst: Boolean? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): HttpResponse = ktorClient.get("$worldDcRegion/" + itemIds.joinToString(",")) {
    url {
        if (listings != null) parameters.append("listings", listings.toString())

        if (entries != null) parameters.append("entries", entries.toString())

        if (noGst != null) parameters.append("noGst", noGst.toString())

        if (hq != null) parameters.append("hq", hq.toString())

        if (statsWithin != null) parameters.append(
            "statsWithin", statsWithin.toString()
        )

        if (entriesWithin != null) parameters.append(
            "entriesWithin", entriesWithin.toString()
        )
    }
}.let {
    when (it.status.value) {
        200  -> it
        404  -> throw throwInvalidWorldDataCenterItemException(it)
        else -> throw throwUniversalisException(it)
    }
}

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
 * @throws InvalidWorldDataCenterItemException The world/DC or item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMarketBoardCurrentData(
    world: World,
    itemId: Int,
    listings: Int? = null,
    entries: Int? = null,
    noGst: Boolean? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): CurrentlyShown = getMarketBoardCurrentDataList(
    world.name,
    listOf(itemId),
    listings,
    entries,
    noGst,
    hq,
    statsWithin,
    entriesWithin,
).body()

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
 * @throws InvalidWorldDataCenterItemException The world/DC or item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMarketBoardCurrentData(
    dcName: DataCenter,
    itemId: Int,
    listings: Int? = null,
    entries: Int? = null,
    noGst: Boolean? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): CurrentlyShown = getMarketBoardCurrentDataList(
    dcName.name,
    listOf(itemId),
    listings,
    entries,
    noGst,
    hq,
    statsWithin,
    entriesWithin,
).body()

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
 * @throws InvalidWorldDataCenterItemException The world/DC or item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMarketBoardCurrentData(
    region: Region,
    itemId: Int,
    listings: Int? = null,
    entries: Int? = null,
    noGst: Boolean? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): CurrentlyShown = getMarketBoardCurrentDataList(
    if (region == Region.NorthAmerica) "North-America" else region.name,
    listOf(itemId),
    listings,
    entries,
    noGst,
    hq,
    statsWithin,
    entriesWithin,
).body()

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
 * @throws InvalidWorldDataCenterItemException The world/DC or item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMarketBoardCurrentData(
    world: World,
    itemIds: List<Int>,
    listings: Int? = null,
    entries: Int? = null,
    noGst: Boolean? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): Multi<CurrentlyShown> = getMarketBoardCurrentDataList(
    world.name,
    itemIds,
    listings,
    entries,
    noGst,
    hq,
    statsWithin,
    entriesWithin,
).body()

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
 * @throws InvalidWorldDataCenterItemException The world/DC or item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMarketBoardCurrentData(
    dcName: DataCenter,
    itemIds: List<Int>,
    listings: Int? = null,
    entries: Int? = null,
    noGst: Boolean? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): Multi<CurrentlyShown> = getMarketBoardCurrentDataList(
    dcName.name,
    itemIds,
    listings,
    entries,
    noGst,
    hq,
    statsWithin,
    entriesWithin,
).body()

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
 * @throws InvalidWorldDataCenterItemException The world/DC or item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMarketBoardCurrentData(
    region: Region,
    itemIds: List<Int>,
    listings: Int? = null,
    entries: Int? = null,
    noGst: Boolean? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): Multi<CurrentlyShown> = getMarketBoardCurrentDataList(
    if (region == Region.NorthAmerica) "North-America" else region.name,
    itemIds,
    listings,
    entries,
    noGst,
    hq,
    statsWithin,
    entriesWithin,
).body()
