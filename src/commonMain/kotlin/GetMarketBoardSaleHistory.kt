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
    itemIds: List<Int>,
    worldDataCenterRegion: String,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
    minSalePrice: Int? = null,
    maxSalePrice: Int? = null,
): HttpResponse = ktorClient.get(
    "history/$worldDataCenterRegion/${itemIds.joinToString(",")}"
) {
    url {
        if (entriesToReturn != null) parameters.append(
            "entriesToReturn", entriesToReturn.toString(),
        )

        if (statsWithin != null) parameters.append(
            "statsWithin", statsWithin.toString()
        )

        if (entriesWithin != null) parameters.append(
            "entriesWithin", entriesWithin.toString(),
        )

        if (minSalePrice != null) parameters.append(
            "miNSalePrice", minSalePrice.toString(),
        )

        if (maxSalePrice != null) parameters.append(
            "maxSalePrice", maxSalePrice.toString(),
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
 * Retrieves the history data for the requested item and [World].
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
suspend fun getMarketBoardSaleHistory(
    itemId: Int,
    world: World,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
    minSalePrice: Int? = null,
    maxSalePrice: Int? = null,
): History = getMarketBoardSaleHistoryList(
    listOf(itemId),
    world.name,
    entriesToReturn,
    statsWithin,
    entriesWithin,
    minSalePrice,
    maxSalePrice
).body()

/**
 * Retrieves the history data for the requested item and [DataCenter].
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
suspend fun getMarketBoardSaleHistory(
    itemId: Int,
    dataCenter: DataCenter,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
    minSalePrice: Int? = null,
    maxSalePrice: Int? = null,
): History = getMarketBoardSaleHistoryList(
    listOf(itemId),
    dataCenter.name,
    entriesToReturn,
    statsWithin,
    entriesWithin,
    minSalePrice,
    maxSalePrice
).body()

/**
 * Retrieves the history data for the requested item and [Region].
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
suspend fun getMarketBoardSaleHistory(
    itemId: Int,
    region: Region,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
    minSalePrice: Int? = null,
    maxSalePrice: Int? = null,
): History = getMarketBoardSaleHistoryList(
    listOf(itemId),
    region.toString(),
    entriesToReturn,
    statsWithin,
    entriesWithin,
    minSalePrice,
    maxSalePrice
).body()

/**
 * Retrieves the history data for the requested list of items and [World].
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
suspend fun getMarketBoardSaleHistory(
    itemIds: List<Int>,
    world: World,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
    minSalePrice: Int? = null,
    maxSalePrice: Int? = null,
): Multi<History> = getMarketBoardSaleHistoryList(
    itemIds,
    world.name,
    entriesToReturn,
    statsWithin,
    entriesWithin,
    minSalePrice,
    maxSalePrice
).body()

/**
 * Retrieves the history data for the requested list of items and [DataCenter].
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
suspend fun getMarketBoardSaleHistory(
    itemIds: List<Int>,
    dataCenter: DataCenter,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
    minSalePrice: Int? = null,
    maxSalePrice: Int? = null,
): Multi<History> = getMarketBoardSaleHistoryList(
    itemIds,
    dataCenter.name,
    entriesToReturn,
    statsWithin,
    entriesWithin,
    minSalePrice,
    maxSalePrice
).body()

/**
 * Retrieves the history data for the requested list of items and [Region].
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
suspend fun getMarketBoardSaleHistory(
    itemIds: List<Int>,
    region: Region,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
    minSalePrice: Int? = null,
    maxSalePrice: Int? = null,
): Multi<History> = getMarketBoardSaleHistoryList(
    itemIds,
    region.toString(),
    entriesToReturn,
    statsWithin,
    entriesWithin,
    minSalePrice,
    maxSalePrice
).body()
