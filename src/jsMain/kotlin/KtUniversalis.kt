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
import kotlin.js.Promise
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
     * Returns all data centers supported by the Universalis API
     * @throws UniversalisException The Universalis API returned an unexpected return code
     */
    fun getAvailableDataCenters(): Promise<Array<DataCenter>> = GlobalScope.promise {
        val response = ktorClient.get("data-centers")

        if (response.status.value == 200) {
            return@promise response.body()
        } else {
            throw UniversalisException()
        }
    }

    /**
     * Returns the IDs and names of all worlds supported by the Universalis API
     * @throws UniversalisException The Universalis API returned an unexpected return code
     */
    fun getAvailableWorlds(): Promise<Array<World>> = GlobalScope.promise {
        val response = ktorClient.get("worlds")

        if (response.status.value == 200) {
            return@promise response.body()
        } else {
            throw UniversalisException()
        }
    }

    /**
     * Returns the least-recently updated items on the specified world or data center, along with the upload times for each item
     * @param world The world to request data for
     * @param dcName The data center to request data for
     * @param entries The number of entries to return (default `50`, max `200`)
     * @throws InvalidWorldDcException The world/DC requested is invalid
     * @throws InvalidEntriesException `entries` must be between `0` and `200`
     * @throws UniversalisException The Universalis API returned an unexpected return code
     */
    fun getLeastRecentlyUpdatedItems(
        world: String? = null,
        dcName: String? = null,
        entries: Int? = null,
    ): Promise<RecentlyUpdatedItems> = GlobalScope.promise {
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
            200  -> return@promise leastRecentlyUpdatedItems.body()
            404  -> throw InvalidWorldDcException()
            else -> throw UniversalisException()
        }
    }

    /**
     * Returns the data currently shown on the market board for the requested array of item IDs and world or data center
     * @param worldDcRegion The world, data center, or region to retrieve data for. This may be an ID or a name. Regions should be specified as Japan, Europe, North-America, Oceania, China, or 中国.
     * @param itemIds Array of item IDs to retrieve data for. Up to 100 item IDs can be provided.
     * @param listings The number of listings to return. By default, all listings will be returned.
     * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
     * @param noGst If the result should not have Gil sales tax (GST) factored in. GST is applied to all consumer purchases in-game, and is separate from the retainer city tax that impacts what sellers receive. By default, GST is factored in.
     * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
     * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is 7 days.
     * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
     * @param fields An array of fields that should be included in the response, if omitted will return all fields. For example if you're only interested in the listings price per unit you can set this to listings.pricePerUnit
     * @throws ItemIdsException At least one and less than or equal to 100 item IDs are required
     * @throws InvalidParameterException The parameters are invalid
     * @throws InvalidWorldDcItemException The world/DC or item requested is invalid
     * @throws UniversalisException The Universalis API returned an unexpected return code
     */
    fun getMarketBoardCurrentData(
        worldDcRegion: String,
        itemIds: IntArray,
        listings: Int? = null,
        entries: Int? = null,
        noGst: Boolean? = null,
        hq: Boolean? = null,
        statsWithin: Int? = null,
        entriesWithin: Int? = null,
        fields: Array<String>? = null,
    ): Promise<CurrentlyShown> = GlobalScope.promise {
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
                200  -> return@promise marketBoardCurrentData.body()
                400  -> throw InvalidParameterException()
                404  -> throw InvalidWorldDcItemException()
                else -> throw UniversalisException()
            }
        } else {
            throw ItemIdsException()
        }
    }

    /**
     * Returns the history data for the requested array of item IDs and world or data center
     * @param worldDcRegion The world or data center to retrieve data for. This may be an ID or a name. Regions should be specified as Japan, Europe, North-America, Oceania, China, or 中国.
     * @param itemIds Array of item IDs to retrieve data for
     * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
     * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
     * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
     * @throws ItemIdsException At least one and less than or equal to 100 item IDs are required
     * @throws InvalidWorldDcItemException The world/DC or item requested is invalid
     * @throws UniversalisException The Universalis API returned an unexpected return code
     */
    fun getMarketBoardSaleHistory(
        worldDcRegion: String,
        itemIds: IntArray,
        entriesToReturn: Int? = null,
        statsWithin: Int? = null,
        entriesWithin: Int? = null,
    ): Promise<History> = GlobalScope.promise {
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
                200  -> return@promise marketBoardSaleHistory.body()
                404  -> throw InvalidWorldDcItemException()
                else -> throw UniversalisException()
            }
        } else {
            throw ItemIdsException()
        }
    }

    /**
     * Returns the current tax rate data for the specified world
     * @param world The world or to retrieve data for. This may be an ID or a name.
     * @throws InvalidWorldException The world requested is invalid
     * @throws UniversalisException The Universalis API returned an unexpected return code
     */
    fun getMarketTaxRates(world: String): Promise<TaxRates> = GlobalScope.promise {
        val marketBoardTaxRates = ktorClient.get("tax-rates") {
            url {
                parameters.append("world", world)
            }
        }

        when (marketBoardTaxRates.status.value) {
            200  -> return@promise marketBoardTaxRates.body()
            404  -> throw InvalidWorldException()
            else -> throw UniversalisException()
        }
    }

    /**
     * Returns an array of marketable item IDs
     * @throws UniversalisException The Universalis API returned an unexpected return code
     */
    fun getMarketableItems(): Promise<IntArray> = GlobalScope.promise {
        val marketableItems = ktorClient.get("marketable")

        when (marketableItems.status.value) {
            200  -> return@promise marketableItems.body()
            else -> throw UniversalisException()
        }
    }

    /**
     * Returns the most-recently updated items on the specified world or data center, along with the upload times for each item
     * @param world The world to request data for
     * @param dcName The data center to request data for
     * @param entries The number of entries to return (default `50`, max `200`)
     * @throws InvalidWorldDcException The world/DC requested is invalid
     * @throws InvalidEntriesException `entries` must be between `0` and `200`
     * @throws UniversalisException The Universalis API returned an unexpected return code
     */
    fun getMostRecentlyUpdatedItems(
        world: String? = null,
        dcName: String? = null,
        entries: Int? = null,
    ): Promise<RecentlyUpdatedItems> = GlobalScope.promise {
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

        when (mostRecentlyUpdatedItems.status.value) {
            200  -> return@promise mostRecentlyUpdatedItems.body()
            404  -> throw InvalidWorldDcException()
            else -> throw UniversalisException()
        }
    }

    /**
     * Returns the total upload counts for each client application that uploads data to Universalis
     * @throws UniversalisException The Universalis API returned an unexpected return code
     */
    fun getUploadCountsByUploadApplication(): Promise<Array<SourceUploadCount>> =
        GlobalScope.promise {
            val uploadCountsByUploadApplication =
                ktorClient.get("extra/stats/uploader-upload-counts")

            when (uploadCountsByUploadApplication.status.value) {
                200  -> return@promise uploadCountsByUploadApplication.body()
                else -> throw UniversalisException()
            }
        }

    /**
     * Returns the world upload counts and proportions of the total uploads for each world
     * @throws UniversalisException The Universalis API returned an unexpected return code
     */
    fun getUploadCountsByWorld(): Promise<Map<String, WorldUploadCount>> =
        GlobalScope.promise {
            val getUploadCountsByWorld =
                ktorClient.get("extra/stats/world-upload-counts")

            when (getUploadCountsByWorld.status.value) {
                200  -> return@promise getUploadCountsByWorld.body()
                else -> throw UniversalisException()
            }
        }

    /**
     * Returns the number of uploads per day over the past 30 days
     * @throws UniversalisException The Universalis API returned an unexpected return code
     */
    fun getUploadsPerDay(): Promise<UploadCountHistory> = GlobalScope.promise {
        val getUploadsPerDay = ktorClient.get("extra/stats/upload-history")

        when (getUploadsPerDay.status.value) {
            200  -> return@promise getUploadsPerDay.body()
            else -> throw UniversalisException()
        }
    }
}
