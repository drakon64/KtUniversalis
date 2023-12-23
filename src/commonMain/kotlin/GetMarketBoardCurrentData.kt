package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.entities.CurrentlyShown
import cloud.drakon.ktuniversalis.entities.Multi
import cloud.drakon.ktuniversalis.exception.InvalidItemException
import cloud.drakon.ktuniversalis.exception.UniversalisException
import cloud.drakon.ktuniversalis.world.DataCenter
import cloud.drakon.ktuniversalis.world.Region
import cloud.drakon.ktuniversalis.world.World
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

internal suspend fun getMarketBoardCurrentDataList(
    itemIds: List<Int>,
    worldDataCenterRegion: String,
    listings: Int? = null,
    entries: Int? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): HttpResponse = ktorClient.get("$worldDataCenterRegion/${itemIds.joinToString(",")}") {
    url {
        if (listings != null) parameters.append("listings", listings.toString())

        if (entries != null) parameters.append("entries", entries.toString())

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
        200 -> it
        404 -> throw it.body<InvalidItemException>()
        else -> throw it.body<UniversalisException>()
    }
}

/**
 * Retrieves the data currently shown on the market board for the requested item and [World].
 * @param itemId The item ID to retrieve data for.
 * @param world The [World] to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidItemException The item requested is invalid. When requesting multiple items at once, an invalid item ID will not trigger this. Instead, the returned list of unresolved item IDs will contain the invalid item ID or IDs.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMarketBoardCurrentData(
    itemId: Int,
    world: World,
    listings: Int? = null,
    entries: Int? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): CurrentlyShown = getMarketBoardCurrentDataList(
    listOf(itemId),
    world.name,
    listings,
    entries,
    hq,
    statsWithin,
    entriesWithin,
).body()

/**
 * Retrieves the data currently shown on the market board for the requested item and [DataCenter].
 * @param itemId The item ID to retrieve data for.
 * @param dataCenter The [DataCenter] to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidItemException The item requested is invalid. When requesting multiple items at once, an invalid item ID will not trigger this. Instead, the returned list of unresolved item IDs will contain the invalid item ID or IDs.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMarketBoardCurrentData(
    itemId: Int,
    dataCenter: DataCenter,
    listings: Int? = null,
    entries: Int? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): CurrentlyShown = getMarketBoardCurrentDataList(
    listOf(itemId),
    dataCenter.name,
    listings,
    entries,
    hq,
    statsWithin,
    entriesWithin,
).body()

/**
 * Retrieves the data currently shown on the market board for the requested item and [Region].
 * @param itemId The item ID to retrieve data for.
 * @param region The [Region] to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidItemException The item requested is invalid. When requesting multiple items at once, an invalid item ID will not trigger this. Instead, the returned list of unresolved item IDs will contain the invalid item ID or IDs.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMarketBoardCurrentData(
    itemId: Int,
    region: Region,
    listings: Int? = null,
    entries: Int? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): CurrentlyShown = getMarketBoardCurrentDataList(
    listOf(itemId),
    region.toString(),
    listings,
    entries,
    hq,
    statsWithin,
    entriesWithin,
).body()

/**
 * Retrieves the data currently shown on the market board for the requested list of items and [World].
 * @param itemIds The list of item IDs to retrieve data for.
 * @param world The [World] to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidItemException The item requested is invalid. When requesting multiple items at once, an invalid item ID will not trigger this. Instead, the returned list of unresolved item IDs will contain the invalid item ID or IDs.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMarketBoardCurrentData(
    itemIds: List<Int>,
    world: World,
    listings: Int? = null,
    entries: Int? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): Multi<CurrentlyShown> = getMarketBoardCurrentDataList(
    itemIds,
    world.name,
    listings,
    entries,
    hq,
    statsWithin,
    entriesWithin,
).body()

/**
 * Retrieves the data currently shown on the market board for the requested list of items and [DataCenter].
 * @param itemIds The list of item IDs to retrieve data for.
 * @param dataCenter The [DataCenter] to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidItemException The item requested is invalid. When requesting multiple items at once, an invalid item ID will not trigger this. Instead, the returned list of unresolved item IDs will contain the invalid item ID or IDs.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMarketBoardCurrentData(
    itemIds: List<Int>,
    dataCenter: DataCenter,
    listings: Int? = null,
    entries: Int? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): Multi<CurrentlyShown> = getMarketBoardCurrentDataList(
    itemIds,
    dataCenter.name,
    listings,
    entries,
    hq,
    statsWithin,
    entriesWithin,
).body()

/**
 * Retrieves the data currently shown on the market board for the requested list of items and [Region].
 * @param itemIds The list of item IDs to retrieve data for.
 * @param region The [Region] to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidItemException The item requested is invalid. When requesting multiple items at once, an invalid item ID will not trigger this. Instead, the returned list of unresolved item IDs will contain the invalid item ID or IDs.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMarketBoardCurrentData(
    itemIds: List<Int>,
    region: Region,
    listings: Int? = null,
    entries: Int? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): Multi<CurrentlyShown> = getMarketBoardCurrentDataList(
    itemIds,
    region.toString(),
    listings,
    entries,
    hq,
    statsWithin,
    entriesWithin,
).body()
