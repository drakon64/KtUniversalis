package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.entities.CurrentlyShown
import cloud.drakon.ktuniversalis.entities.Multi
import cloud.drakon.ktuniversalis.exception.UniversalisException
import io.ktor.client.call.body
import io.ktor.client.request.get

/**
 * Returns the data currently shown on the market board for the requested set of item IDs and world or data center.
 * @param worldDcRegion The world, data center, or region to retrieve data for. This may be an ID or a name. Regions should be specified as Japan, Europe, North-America, Oceania, China, or 中国.
 * @param itemIds The set of item IDs to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param noGst If the result should not have Gil sales tax (GST) factored in. GST is applied to all consumer purchases in-game, and is separate from the retainer city tax that impacts what sellers receive. By default, GST is factored in.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is 7 days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @param fields A list of fields that should be included in the response, if omitted will return all fields. For example if you're only interested in the listings price per unit you can set this to `listings.pricePerUnit`.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
private suspend fun getMarketBoardCurrentDataSet(
    worldDcRegion: String,
    itemIds: Set<Int>,
    listings: Int? = null,
    entries: Int? = null,
    noGst: Boolean? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
    fields: Set<String>? = null,
): Any = ktorClient.get("$worldDcRegion/" + itemIds.joinToString(",")) {
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

        if (fields != null) parameters.append("fields", fields.joinToString(","))
    }
}.let {
    when (it.status.value) {
        200  -> if (itemIds.size == 1) {
            it.body() as CurrentlyShown
        } else {
            it.body() as Multi<CurrentlyShown>
        }

        else -> throw throwUniversalisException(it)
    }
}

/**
 * Returns the data currently shown on the market board for the requested item ID and world or data center.
 * @param worldDcRegion The world, data center, or region to retrieve data for. This may be an ID or a name. Regions should be specified as Japan, Europe, North-America, Oceania, China, or 中国.
 * @param itemId The item ID to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param noGst If the result should not have Gil sales tax (GST) factored in. GST is applied to all consumer purchases in-game, and is separate from the retainer city tax that impacts what sellers receive. By default, GST is factored in.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is 7 days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @param fields A list of fields that should be included in the response, if omitted will return all fields. For example if you're only interested in the listings price per unit you can set this to `listings.pricePerUnit`.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMarketBoardCurrentData(
    worldDcRegion: String,
    itemId: Int,
    listings: Int? = null,
    entries: Int? = null,
    noGst: Boolean? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
    fields: Set<String>? = null,
) = getMarketBoardCurrentDataSet(
    worldDcRegion,
    setOf(itemId),
    listings,
    entries,
    noGst,
    hq,
    statsWithin,
    entriesWithin,
    fields
) as CurrentlyShown

/**
 * Returns the data currently shown on the market board for the requested set of item IDs and world or data center. Up to 100 item IDs can be comma-separated in order to retrieve data for multiple items at once.
 * @param worldDcRegion The world, data center, or region to retrieve data for. This may be an ID or a name. Regions should be specified as Japan, Europe, North-America, Oceania, China, or 中国.
 * @param itemIds The set of item IDs to retrieve data for.
 * @param listings The number of listings to return. By default, all listings will be returned.
 * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
 * @param noGst If the result should not have Gil sales tax (GST) factored in. GST is applied to all consumer purchases in-game, and is separate from the retainer city tax that impacts what sellers receive. By default, GST is factored in.
 * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is 7 days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @param fields A set of fields that should be included in the response, if omitted will return all fields. For example if you're only interested in the listings price per unit you can set this to `listings.pricePerUnit`.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMarketBoardCurrentData(
    worldDcRegion: String,
    itemIds: Set<Int>,
    listings: Int? = null,
    entries: Int? = null,
    noGst: Boolean? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
    fields: Set<String>? = null,
) = getMarketBoardCurrentDataSet(
    worldDcRegion,
    itemIds,
    listings,
    entries,
    noGst,
    hq,
    statsWithin,
    entriesWithin,
    fields
) as Multi<CurrentlyShown>
