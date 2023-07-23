@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.entities.CurrentlyShown
import cloud.drakon.ktuniversalis.entities.DataCenter
import cloud.drakon.ktuniversalis.entities.History
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
import cloud.drakon.ktuniversalis.exception.ItemIdsException
import cloud.drakon.ktuniversalis.exception.UniversalisException
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.js.Js
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@JsExport actual object KtUniversalis {
    private val ktorClient = HttpClient(Js) {
        install(ContentNegotiation) {
            json()
        }

        install(DefaultRequest) {
            url("https://universalis.app/api/v2/")
        }
    }

    /**
     * Returns all data centers supported by the Universalis API.
     * @throws UniversalisException The Universalis API returned an unexpected return code.
     */
    @JsExport.Ignore actual suspend fun getAvailableDataCenters(): List<DataCenter> {
        val response = ktorClient.get("data-centers")

        if (response.status.value == 200) {
            return response.body()
        } else {
            throw UniversalisException()
        }
    }

    /**
     * Returns all data centers supported by the Universalis API.
     * @throws UniversalisException The Universalis API returned an unexpected return code.
     */
    fun getAvailableDataCentersAsync() = GlobalScope.promise {
        return@promise getAvailableDataCenters().toTypedArray()
    }

    /**
     * Returns the IDs and names of all worlds supported by the Universalis API.
     * @throws UniversalisException The Universalis API returned an unexpected return code.
     */
    @JsExport.Ignore actual suspend fun getAvailableWorlds(): List<World> {
        val response = ktorClient.get("worlds")

        if (response.status.value == 200) {
            return response.body()
        } else {
            throw UniversalisException()
        }
    }

    /**
     * Returns the IDs and names of all worlds supported by the Universalis API.
     * @throws UniversalisException The Universalis API returned an unexpected return code.
     */
    fun getAvailableWorldsAsync() = GlobalScope.promise {
        return@promise getAvailableWorlds().toTypedArray()
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
    @JsExport.Ignore actual suspend fun getLeastRecentlyUpdatedItems(
        world: String?,
        dcName: String?,
        entries: Int?,
    ): RecentlyUpdatedItems {
        if (world == null && dcName == null) {
            throw InvalidWorldDcException()
        }

        val leastRecentlyUpdatedItems =
            ktorClient.get("extra/stats/least-recently-updated") {
                url {
                    if (world != null) {
                        parameters.append("world", world)
                    }
                    if (dcName != null) {
                        parameters.append("dcName", dcName)
                    }
                    if (entries != null) {
                        when {
                            (entries <= 0) || (entries > 200) -> throw InvalidEntriesException(
                                "`entries` must be between `0` and `200`"
                            )

                            else                              -> parameters.append(
                                "entries", entries.toString()
                            )
                        }
                    }
                }
            }

        when (leastRecentlyUpdatedItems.status.value) {
            200  -> return leastRecentlyUpdatedItems.body()
            404  -> throw InvalidWorldDcException()
            else -> throw UniversalisException()
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
    fun getLeastRecentlyUpdatedItemsAsync(
        world: String? = null,
        dcName: String? = null,
        entries: Int? = null,
    ) = GlobalScope.promise {
        return@promise getLeastRecentlyUpdatedItems(world, dcName, entries)
    }

    /**
     * Returns the data currently shown on the market board for the requested array of item IDs and world or data center.
     * @param worldDcRegion The world, data center, or region to retrieve data for. This may be an ID or a name. Regions should be specified as Japan, Europe, North-America, Oceania, China, or 中国.
     * @param itemIds Array of item IDs to retrieve data for.
     * @param listings The number of listings to return. By default, all listings will be returned.
     * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
     * @param noGst If the result should not have Gil sales tax (GST) factored in. GST is applied to all consumer purchases in-game, and is separate from the retainer city tax that impacts what sellers receive. By default, GST is factored in.
     * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
     * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is 7 days.
     * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
     * @param fields An array of fields that should be included in the response, if omitted will return all fields. For example if you're only interested in the listings price per unit you can set this to `listings.pricePerUnit`.
     * @throws ItemIdsException At least one and less than or equal to 100 item IDs are required.
     * @throws InvalidParameterException The parameters are invalid.
     * @throws InvalidWorldDcItemException The world/DC or item requested is invalid.
     * @throws UniversalisException The Universalis API returned an unexpected return code.
     */
    @JsExport.Ignore actual suspend fun getMarketBoardCurrentData(
        worldDcRegion: String,
        itemIds: List<Int>,
        listings: Int?,
        entries: Int?,
        noGst: Boolean?,
        hq: Boolean?,
        statsWithin: Int?,
        entriesWithin: Int?,
        fields: List<String>?,
    ): CurrentlyShown {
        if (itemIds.size in 1 .. 100) {
            val marketBoardCurrentData =
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
                }

            when (marketBoardCurrentData.status.value) {
                200  -> return marketBoardCurrentData.body()
                400  -> throw InvalidParameterException()
                404  -> throw InvalidWorldDcItemException()
                else -> throw UniversalisException()
            }
        } else {
            throw ItemIdsException()
        }
    }

    /**
     * Returns the data currently shown on the market board for the requested array of item IDs and world or data center.
     * @param worldDcRegion The world, data center, or region to retrieve data for. This may be an ID or a name. Regions should be specified as Japan, Europe, North-America, Oceania, China, or 中国.
     * @param itemIds Array of item IDs to retrieve data for.
     * @param listings The number of listings to return. By default, all listings will be returned.
     * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
     * @param noGst If the result should not have Gil sales tax (GST) factored in. GST is applied to all consumer purchases in-game, and is separate from the retainer city tax that impacts what sellers receive. By default, GST is factored in.
     * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
     * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is 7 days.
     * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
     * @param fields An array of fields that should be included in the response, if omitted will return all fields. For example if you're only interested in the listings price per unit you can set this to `listings.pricePerUnit`.
     * @throws ItemIdsException At least one and less than or equal to 100 item IDs are required.
     * @throws InvalidParameterException The parameters are invalid.
     * @throws InvalidWorldDcItemException The world/DC or item requested is invalid.
     * @throws UniversalisException The Universalis API returned an unexpected return code.
     */
    fun getMarketBoardCurrentDataAsync(
        worldDcRegion: String,
        itemIds: IntArray,
        listings: Int? = null,
        entries: Int? = null,
        noGst: Boolean? = null,
        hq: Boolean? = null,
        statsWithin: Int? = null,
        entriesWithin: Int? = null,
        fields: Array<String>? = null,
    ) = GlobalScope.promise {
        return@promise getMarketBoardCurrentData(
            worldDcRegion,
            itemIds.toList(),
            listings,
            entries,
            noGst,
            hq,
            statsWithin,
            entriesWithin,
            fields?.toList()
        )
    }

    /**
     * Returns the history data for the requested array of item IDs and world or data center.
     * @param worldDcRegion The world or data center to retrieve data for. This may be an ID or a name. Regions should be specified as Japan, Europe, North-America, Oceania, China, or 中国.
     * @param itemIds Array of item IDs to retrieve data for.
     * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
     * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
     * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
     * @throws ItemIdsException At least one and less than or equal to 100 item IDs are required.
     * @throws InvalidWorldDcItemException The world/DC or item requested is invalid.
     * @throws UniversalisException The Universalis API returned an unexpected return code.
     */
    @JsExport.Ignore actual suspend fun getMarketBoardSaleHistory(
        worldDcRegion: String,
        itemIds: List<Int>,
        entriesToReturn: Int?,
        statsWithin: Int?,
        entriesWithin: Int?,
    ): History {
        if (itemIds.size in 1 .. 100) {
            val marketBoardSaleHistory =
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
                }

            when (marketBoardSaleHistory.status.value) {
                200  -> return marketBoardSaleHistory.body()
                404  -> throw InvalidWorldDcItemException()
                else -> throw UniversalisException()
            }
        } else {
            throw ItemIdsException()
        }
    }

    /**
     * Returns the history data for the requested array of item IDs and world or data center.
     * @param worldDcRegion The world or data center to retrieve data for. This may be an ID or a name. Regions should be specified as Japan, Europe, North-America, Oceania, China, or 中国.
     * @param itemIds Array of item IDs to retrieve data for.
     * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
     * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
     * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
     * @throws ItemIdsException At least one and less than or equal to 100 item IDs are required.
     * @throws InvalidWorldDcItemException The world/DC or item requested is invalid.
     * @throws UniversalisException The Universalis API returned an unexpected return code.
     */
    fun getMarketBoardSaleHistoryAsync(
        worldDcRegion: String,
        itemIds: IntArray,
        entriesToReturn: Int? = null,
        statsWithin: Int? = null,
        entriesWithin: Int? = null,
    ) = GlobalScope.promise {
        return@promise getMarketBoardSaleHistory(
            worldDcRegion, itemIds.toList(), entriesToReturn, statsWithin, entriesWithin
        )
    }

    /**
     * Returns the current tax rate data for the specified world.
     * @param world The world or to retrieve data for. This may be an ID or a name.
     * @throws InvalidWorldException The world requested is invalid.
     * @throws UniversalisException The Universalis API returned an unexpected return code.
     */
    @JsExport.Ignore actual suspend fun getMarketTaxRates(world: String): TaxRates {
        val marketBoardTaxRates = ktorClient.get("tax-rates") {
            url {
                parameters.append("world", world)
            }
        }

        when (marketBoardTaxRates.status.value) {
            200  -> return marketBoardTaxRates.body()
            404  -> throw InvalidWorldException()
            else -> throw UniversalisException()
        }
    }

    /**
     * Returns the current tax rate data for the specified world.
     * @param world The world or to retrieve data for. This may be an ID or a name.
     * @throws InvalidWorldException The world requested is invalid.
     * @throws UniversalisException The Universalis API returned an unexpected return code.
     */
    fun getMarketTaxRatesAsync(world: String) = GlobalScope.promise {
        return@promise getMarketTaxRates(world)
    }

    /**
     * Returns an array of marketable item IDs.
     * @throws UniversalisException The Universalis API returned an unexpected return code.
     */
    @JsExport.Ignore actual suspend fun getMarketableItems(): List<Int> {
        val marketableItems = ktorClient.get("marketable")

        when (marketableItems.status.value) {
            200  -> return marketableItems.body()
            else -> throw UniversalisException()
        }
    }

    /**
     * Returns an array of marketable item IDs.
     * @throws UniversalisException The Universalis API returned an unexpected return code.
     */
    fun getMarketableItemsAsync() = GlobalScope.promise {
        return@promise getMarketableItems().toIntArray()
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
    @JsExport.Ignore actual suspend fun getMostRecentlyUpdatedItems(
        world: String?,
        dcName: String?,
        entries: Int?,
    ): RecentlyUpdatedItems {
        if (world == null && dcName == null) {
            throw InvalidWorldDcException()
        }

        val mostRecentlyUpdatedItems =
            ktorClient.get("extra/stats/most-recently-updated") {
                url {
                    if (world != null) {
                        parameters.append("world", world)
                    }
                    if (dcName != null) {
                        parameters.append("dcName", dcName)
                    }
                    if (entries != null) {
                        when {
                            entries <= 0 || entries > 200 -> throw InvalidEntriesException(
                                "`entries` must be between `0` and `200`"
                            )

                            else                          -> parameters.append(
                                "entries", entries.toString()
                            )
                        }
                    }
                }
            }

        when (mostRecentlyUpdatedItems.status.value) {
            200  -> return mostRecentlyUpdatedItems.body()
            404  -> throw InvalidWorldDcException()
            else -> throw UniversalisException()
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
    fun getMostRecentlyUpdatedItemsAsync(
        world: String? = null,
        dcName: String? = null,
        entries: Int? = null,
    ) = GlobalScope.promise {
        return@promise getMostRecentlyUpdatedItems(world, dcName, entries)
    }

    /**
     * Returns the total upload counts for each client application that uploads data to Universalis.
     * @throws UniversalisException The Universalis API returned an unexpected return code.
     */
    @JsExport.Ignore
    actual suspend fun getUploadCountsByUploadApplication(): List<SourceUploadCount> {
        val uploadCountsByUploadApplication =
            ktorClient.get("extra/stats/uploader-upload-counts")

        when (uploadCountsByUploadApplication.status.value) {
            200  -> return uploadCountsByUploadApplication.body()
            else -> throw UniversalisException()
        }
    }

    /**
     * Returns the total upload counts for each client application that uploads data to Universalis.
     * @throws UniversalisException The Universalis API returned an unexpected return code.
     */
    fun getUploadCountsByUploadApplicationAsync() = GlobalScope.promise {
        return@promise getUploadCountsByUploadApplication().toTypedArray()
    }

    /**
     * Returns the world upload counts and proportions of the total uploads for each world.
     * @throws UniversalisException The Universalis API returned an unexpected return code.
     */
    @JsExport.Ignore
    actual suspend fun getUploadCountsByWorld(): Map<String, WorldUploadCount> {
        val getUploadCountsByWorld = ktorClient.get("extra/stats/world-upload-counts")

        when (getUploadCountsByWorld.status.value) {
            200  -> return getUploadCountsByWorld.body()
            else -> throw UniversalisException()
        }
    }

    /**
     * Returns the world upload counts and proportions of the total uploads for each world.
     * @throws UniversalisException The Universalis API returned an unexpected return code.
     */
    fun getUploadCountsByWorldAsync() = GlobalScope.promise {
        return@promise getUploadCountsByWorld()
    }

    /**
     * Returns the number of uploads per day over the past 30 days.
     * @throws UniversalisException The Universalis API returned an unexpected return code.
     */
    @JsExport.Ignore actual suspend fun getUploadsPerDay(): UploadCountHistory {
        val getUploadsPerDay = ktorClient.get("extra/stats/upload-history")

        when (getUploadsPerDay.status.value) {
            200  -> return getUploadsPerDay.body()
            else -> throw UniversalisException()
        }
    }

    /**
     * Returns the number of uploads per day over the past 30 days.
     * @throws UniversalisException The Universalis API returned an unexpected return code.
     */
    fun getUploadsPerDayAsync() = GlobalScope.promise {
        return@promise getUploadsPerDay()
    }
}
