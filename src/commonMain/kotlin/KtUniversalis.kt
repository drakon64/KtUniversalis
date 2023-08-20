package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.entities.CurrentlyShown
import cloud.drakon.ktuniversalis.entities.DataCenter
import cloud.drakon.ktuniversalis.entities.History
import cloud.drakon.ktuniversalis.entities.Multi
import cloud.drakon.ktuniversalis.entities.ProblemDetails
import cloud.drakon.ktuniversalis.entities.RecentlyUpdatedItems
import cloud.drakon.ktuniversalis.entities.SourceUploadCount
import cloud.drakon.ktuniversalis.entities.TaxRates
import cloud.drakon.ktuniversalis.entities.UploadCountHistory
import cloud.drakon.ktuniversalis.entities.World
import cloud.drakon.ktuniversalis.entities.WorldUploadCount
import cloud.drakon.ktuniversalis.exception.InvalidEntriesException
import cloud.drakon.ktuniversalis.exception.InvalidParameterException
import cloud.drakon.ktuniversalis.exception.InvalidWorldDcException
import cloud.drakon.ktuniversalis.exception.InvalidWorldDcItemException
import cloud.drakon.ktuniversalis.exception.InvalidWorldException
import cloud.drakon.ktuniversalis.exception.UniversalisException
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.coroutineScope

internal expect val ktorClient: HttpClient

/**
 * Returns all data centers supported by the Universalis API.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getAvailableDataCenters(): List<DataCenter> = coroutineScope {
    ktorClient.get("data-centers").let {
        if (it.status.value == 200) {
            return@coroutineScope it.body()
        } else {
            throw UniversalisException((it.body() as ProblemDetails).toString())
        }
    }
}

/**
 * Returns the IDs and names of all worlds supported by the Universalis API.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getAvailableWorlds(): List<World> = coroutineScope {
    ktorClient.get("worlds").let {
        if (it.status.value == 200) {
            return@coroutineScope it.body()
        } else {
            throw UniversalisException((it.body() as ProblemDetails).toString())
        }
    }
}

/**
 * Returns the least-recently updated items on the specified world or data center, along with the upload times for each item.
 * @param world The world to request data for.
 * @param dcName The data center to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws InvalidWorldDcException The world/DC requested is invalid.
 * @throws InvalidEntriesException `entries` must be between `0` and `200`.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getLeastRecentlyUpdatedItems(
    world: String? = null,
    dcName: String? = null,
    entries: Int? = null,
): RecentlyUpdatedItems = coroutineScope {
    if (world == null && dcName == null) {
        throw InvalidWorldDcException()
    }

    ktorClient.get("extra/stats/least-recently-updated") {
        url {
            if (world != null) {
                parameters.append("world", world)
            }
            if (dcName != null) {
                parameters.append("dcName", dcName)
            }
            if (entries != null) {
                if ((entries <= 0) || (entries > 200)) {
                    throw InvalidEntriesException(
                        "`entries` must be between `0` and `200`"
                    )
                } else {
                    parameters.append(
                        "entries", entries.toString()
                    )
                }
            }
        }
    }.let {
        when (it.status.value) {
            200  -> return@coroutineScope it.body()
            404  -> throw InvalidWorldDcException()
            else -> throw UniversalisException((it.body() as ProblemDetails).toString())
        }
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
 * @throws InvalidParameterException The parameters are invalid.
 * @throws InvalidWorldDcItemException The world/DC or item requested is invalid.
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
    fields: List<String>? = null,
): CurrentlyShown = coroutineScope {
    ktorClient.get("$worldDcRegion/$itemId") {
        url {
            if (listings != null) {
                parameters.append("listings", listings.toString())
            }
            if (entries != null) {
                parameters.append("entries", entries.toString())
            }
            if (noGst != null) {
                parameters.append("noGst", noGst.toString())
            }
            if (hq != null) {
                parameters.append("hq", hq.toString())
            }
            if (statsWithin != null) {
                parameters.append("statsWithin", statsWithin.toString())
            }
            if (entriesWithin != null) {
                parameters.append("entriesWithin", entriesWithin.toString())
            }
            if (fields != null) {
                parameters.append("fields", fields.joinToString(","))
            }
        }
    }.let {
        when (it.status.value) {
            200  -> return@coroutineScope it.body()
            400  -> throw InvalidParameterException()
            404  -> throw InvalidWorldDcItemException()
            else -> throw UniversalisException((it.body() as ProblemDetails).toString())
        }
    }
}

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
 * @throws InvalidParameterException The parameters are invalid.
 * @throws InvalidWorldDcItemException The world/DC or item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMarketBoardCurrentDataMulti(
    worldDcRegion: String,
    itemIds: Set<Int>,
    listings: Int? = null,
    entries: Int? = null,
    noGst: Boolean? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
    fields: Set<String>? = null,
): Multi<CurrentlyShown> = coroutineScope {
    ktorClient.get("$worldDcRegion/" + itemIds.joinToString(",")) {
        url {
            if (listings != null) {
                parameters.append("listings", listings.toString())
            }
            if (entries != null) {
                parameters.append("entries", entries.toString())
            }
            if (noGst != null) {
                parameters.append("noGst", noGst.toString())
            }
            if (hq != null) {
                parameters.append("hq", hq.toString())
            }
            if (statsWithin != null) {
                parameters.append("statsWithin", statsWithin.toString())
            }
            if (entriesWithin != null) {
                parameters.append("entriesWithin", entriesWithin.toString())
            }
            if (fields != null) {
                parameters.append("fields", fields.joinToString(","))
            }
        }
    }.let {
        when (it.status.value) {
            200  -> return@coroutineScope it.body()
            400  -> throw InvalidParameterException()
            404  -> throw InvalidWorldDcItemException()
            else -> throw UniversalisException((it.body() as ProblemDetails).toString())
        }
    }
}

/**
 * Returns the history data for the requested item ID and world or data center.
 * @param worldDcRegion The world or data center to retrieve data for. This may be an ID or a name. Regions should be specified as Japan, Europe, North-America, Oceania, China, or 中国.
 * @param itemId The item ID to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidWorldDcItemException The world/DC or item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMarketBoardSaleHistory(
    worldDcRegion: String,
    itemId: Int,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): History = coroutineScope {
    ktorClient.get("history/$worldDcRegion/$itemId") {
        url {
            if (entriesToReturn != null) {
                parameters.append(
                    "entriesToReturn", entriesToReturn.toString()
                )
            }
            if (statsWithin != null) {
                parameters.append("statsWithin", statsWithin.toString())
            }
            if (entriesWithin != null) {
                parameters.append("entriesWithin", entriesWithin.toString())
            }
        }
    }.let {
        when (it.status.value) {
            200  -> return@coroutineScope it.body()
            404  -> throw InvalidWorldDcItemException()
            else -> throw UniversalisException((it.body() as ProblemDetails).toString())
        }
    }
}

/**
 * Returns the history data for the requested set of item IDs and world or data center.
 * @param worldDcRegion The world or data center to retrieve data for. This may be an ID or a name. Regions should be specified as Japan, Europe, North-America, Oceania, China, or 中国.
 * @param itemIds The set of item IDs to retrieve data for.
 * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
 * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
 * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
 * @throws InvalidWorldDcItemException The world/DC or item requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMarketBoardSaleHistoryMulti(
    worldDcRegion: String,
    itemIds: Set<Int>,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
): Multi<History> = coroutineScope {
    ktorClient.get("history/$worldDcRegion/" + itemIds.joinToString(",")) {
        url {
            if (entriesToReturn != null) {
                parameters.append(
                    "entriesToReturn", entriesToReturn.toString()
                )
            }
            if (statsWithin != null) {
                parameters.append("statsWithin", statsWithin.toString())
            }
            if (entriesWithin != null) {
                parameters.append("entriesWithin", entriesWithin.toString())
            }
        }
    }.let {
        when (it.status.value) {
            200  -> return@coroutineScope it.body()
            404  -> throw InvalidWorldDcItemException()
            else -> throw UniversalisException((it.body() as ProblemDetails).toString())
        }
    }
}

/**
 * Returns the current tax rate data for the specified world.
 * @param world The world or to retrieve data for. This may be an ID or a name.
 * @throws InvalidWorldException The world requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMarketTaxRates(world: String): TaxRates = coroutineScope {
    ktorClient.get("tax-rates") {
        url {
            parameters.append("world", world)
        }
    }.let {
        when (it.status.value) {
            200  -> return@coroutineScope it.body()
            404  -> throw InvalidWorldException()
            else -> throw UniversalisException((it.body() as ProblemDetails).toString())
        }
    }
}

/**
 * Returns a list of marketable item IDs.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMarketableItems(): List<Int> = coroutineScope {
    ktorClient.get("marketable").let {
        when (it.status.value) {
            200  -> return@coroutineScope it.body()
            else -> throw UniversalisException((it.body() as ProblemDetails).toString())
        }
    }
}

/**
 * Returns the most-recently updated items on the specified world or data center, along with the upload times for each item.
 * @param world The world to request data for.
 * @param dcName The data center to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws InvalidWorldDcException The world/DC requested is invalid.
 * @throws InvalidEntriesException `entries` must be between `0` and `200`.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMostRecentlyUpdatedItems(
    world: String? = null,
    dcName: String? = null,
    entries: Int? = null,
): RecentlyUpdatedItems = coroutineScope {
    if (world == null && dcName == null) {
        throw InvalidWorldDcException()
    }

    ktorClient.get("extra/stats/most-recently-updated") {
        url {
            if (world != null) {
                parameters.append("world", world)
            }
            if (dcName != null) {
                parameters.append("dcName", dcName)
            }
            if (entries != null) {
                if (entries <= 0 || entries > 200) {
                    throw InvalidEntriesException(
                        "`entries` must be between `0` and `200`"
                    )
                } else {
                    parameters.append(
                        "entries", entries.toString()
                    )
                }
            }
        }
    }.let {
        when (it.status.value) {
            200  -> return@coroutineScope it.body()
            404  -> throw InvalidWorldDcException()
            else -> throw UniversalisException((it.body() as ProblemDetails).toString())
        }
    }
}

/**
 * Returns the total upload counts for each client application that uploads data to Universalis.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getUploadCountsByUploadApplication(): List<SourceUploadCount> =
    coroutineScope {
        ktorClient.get("extra/stats/uploader-upload-counts").let {
            when (it.status.value) {
                200  -> return@coroutineScope it.body()
                else -> throw UniversalisException((it.body() as ProblemDetails).toString())
            }
        }
    }

/**
 * Returns the world upload counts and proportions of the total uploads for each world.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getUploadCountsByWorld(): Map<String, WorldUploadCount> = coroutineScope {
    ktorClient.get("extra/stats/world-upload-counts").let {
        when (it.status.value) {
            200  -> return@coroutineScope it.body()
            else -> throw UniversalisException((it.body() as ProblemDetails).toString())
        }
    }
}

/**
 * Returns the number of uploads per day over the past 30 days.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getUploadsPerDay(): UploadCountHistory = coroutineScope {
    ktorClient.get("extra/stats/upload-history").let {
        when (it.status.value) {
            200  -> return@coroutineScope it.body()
            else -> throw UniversalisException((it.body() as ProblemDetails).toString())
        }
    }
}
