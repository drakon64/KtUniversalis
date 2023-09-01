package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.entities.History
import cloud.drakon.ktuniversalis.entities.Multi
import cloud.drakon.ktuniversalis.exception.InvalidItemException
import cloud.drakon.ktuniversalis.exception.UniversalisException
import cloud.drakon.ktuniversalis.world.DataCenter
import cloud.drakon.ktuniversalis.world.Region
import cloud.drakon.ktuniversalis.world.World
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

internal suspend fun getMarketBoardSaleHistoryList(
    worldDcRegion: String,
    itemIds: List<Int>,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): HttpResponse = ktorClient.get(
    "history/$worldDcRegion/" + itemIds.joinToString(",")
) {
    url {
        if (entriesToReturn != null) parameters.append(
            "entriesToReturn", entriesToReturn.toString()
        )

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
        404  -> throw throwInvalidItemException(it)
        else -> throw throwUniversalisException(it)
    }
}

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
suspend fun getMarketBoardSaleHistory(
    world: World,
    itemId: Int,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): History = getMarketBoardSaleHistoryList(
    world.name, listOf(itemId), entriesToReturn, statsWithin, entriesWithin
).body()

/**
 * Returns the history data for the requested item ID and data center.
 * @param dcName The data center to retrieve data for.
 * @param itemId The item ID to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidItemException The item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMarketBoardSaleHistory(
    dcName: DataCenter,
    itemId: Int,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): History = getMarketBoardSaleHistoryList(
    dcName.name, listOf(itemId), entriesToReturn, statsWithin, entriesWithin
).body()

/**
 * Returns the history data for the requested item ID and region.
 * @param region The region to retrieve data for.
 * @param itemId The item ID to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidItemException The item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMarketBoardSaleHistory(
    region: Region,
    itemId: Int,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): History = getMarketBoardSaleHistoryList(
    if (region == Region.NorthAmerica) "North-America" else region.name,
    listOf(itemId),
    entriesToReturn,
    statsWithin,
    entriesWithin
).body()

/**
 * Returns the history data for the requested list of item IDs and world.
 * @param world The world to retrieve data for.
 * @param itemIds The list of item IDs to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidItemException The item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMarketBoardSaleHistory(
    world: World,
    itemIds: List<Int>,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): Multi<History> = getMarketBoardSaleHistoryList(
    world.name, itemIds, entriesToReturn, statsWithin, entriesWithin
).body()

/**
 * Returns the history data for the requested list of item IDs and data center.
 * @param dcName The data center to retrieve data for.
 * @param itemIds The list of item IDs to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidItemException The item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMarketBoardSaleHistory(
    dcName: DataCenter,
    itemIds: List<Int>,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): Multi<History> = getMarketBoardSaleHistoryList(
    dcName.name, itemIds, entriesToReturn, statsWithin, entriesWithin
).body()

/**
 * Returns the history data for the requested list of item IDs and region.
 * @param region The region to retrieve data for.
 * @param itemIds The list of item IDs to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidItemException The item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMarketBoardSaleHistory(
    region: Region,
    itemIds: List<Int>,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): Multi<History> = getMarketBoardSaleHistoryList(
    if (region == Region.NorthAmerica) "North-America" else region.name,
    itemIds,
    entriesToReturn,
    statsWithin,
    entriesWithin
).body()
