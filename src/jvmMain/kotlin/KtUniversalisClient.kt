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
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.java.Java
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json

actual object KtUniversalisClient {
    private val ktorClient = HttpClient(Java) {
        install(ContentNegotiation) {
            json()
        }

        install(DefaultRequest) {
            url("https://universalis.app/api/v2/")
        }
    }

    /**
     * Returns all data centers supported by the Universalis API
     */
    suspend fun getAvailableDataCenters(): Array<DataCenter> =
        ktorClient.get("data-centers").body()

    /**
     * Returns the IDs and names of all worlds supported by the Universalis API
     */
    suspend fun getAvailableWorlds(): Array<World> = ktorClient.get("worlds").body()

    /**
     * Returns the least-recently updated items on the specified world or data center, along with the upload times for each item
     * @param world The world to request data for
     * @param dcName The data center to request data for
     * @param entries The number of entries to return (default `50`, max `200`)
     */
    suspend fun getLeastRecentlyUpdatedItems(
        world: String? = null,
        dcName: String? = null,
        entries: Int? = null,
    ): RecentlyUpdatedItems {
        if (world == null && dcName == null) {
            throw Throwable()
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
                            entries > 200 -> throw Throwable()
                            entries <= 0  -> throw Throwable()
                            else          -> parameters.append(
                                "entries", entries.toString()
                            )
                        }
                    }
                }
            }

        when (leastRecentlyUpdatedItems.status.value) {
            200  -> return leastRecentlyUpdatedItems.body()
            404  -> throw Throwable()
            else -> throw Throwable()
        }
    }

    /**
     * Returns the data currently shown on the market board for the requested array of item IDs and world or data center
     * @param worldDcRegion The world, data center, or region to retrieve data for. This may be an ID or a name. Regions should be specified as Japan, Europe, North-America, Oceania, China, or 中国.
     * @param itemIds Array of item IDs to retrieve data for
     * @param listings The number of listings to return. By default, all listings will be returned.
     * @param entries The number of recent history entries to return. By default, a maximum of `5` entries will be returned.
     * @param noGst If the result should not have Gil sales tax (GST) factored in. GST is applied to all consumer purchases in-game, and is separate from the retainer city tax that impacts what sellers receive. By default, GST is factored in.
     * @param hq Filter for HQ listings and entries. By default, both HQ and NQ listings and entries will be returned.
     * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is 7 days.
     * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
     * @param fields An array of fields that should be included in the response, if omitted will return all fields. For example if you're only interested in the listings price per unit you can set this to listings.pricePerUnit
     */
    suspend fun getMarketBoardCurrentData(
        worldDcRegion: String,
        itemIds: IntArray,
        listings: Int? = null,
        entries: Int? = null,
        noGst: Boolean? = null,
        hq: Boolean? = null,
        statsWithin: Int? = null,
        entriesWithin: Int? = null,
        fields: Array<String>? = null,
    ): CurrentlyShown {
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
            400  -> throw Throwable()
            404  -> throw Throwable()
            else -> throw Throwable()
        }
    }

    /**
     * Returns the history data for the requested array of item IDs and world or data center
     * @param worldDcRegion The world or data center to retrieve data for. This may be an ID or a name. Regions should be specified as Japan, Europe, North-America, Oceania, China, or 中国.
     * @param itemIds Array of item IDs to retrieve data for
     * @param entriesToReturn The number of entries to return. By default, this is set to `1800`, but may be set to a maximum of `999999`.
     * @param statsWithin The amount of time before now to calculate stats over, in milliseconds. By default, this is `7` days.
     * @param entriesWithin The amount of time before now to take entries within, in seconds. Negative values will be ignored.
     */
    suspend fun getMarketBoardSaleHistory(
        worldDcRegion: String,
        itemIds: IntArray,
        entriesToReturn: Int? = null,
        statsWithin: Int? = null,
        entriesWithin: Int? = null,
    ): History {
        val marketBoardSaleHistory =
            ktorClient.get("history/$worldDcRegion/" + itemIds.joinToString(",")) {
                url {
                    if (entriesToReturn != null) {
                        parameters.append("entriesToReturn", entriesToReturn.toString())
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
            404  -> throw Throwable()
            else -> throw Throwable()
        }
    }

    /**
     * Returns the current tax rate data for the specified world
     * @param world The world or to retrieve data for. This may be an ID or a name.
     */
    suspend fun getMarketTaxRates(world: String): TaxRates {
        val marketBoardTaxRates = ktorClient.get("tax-rates") {
            url {
                parameters.append("world", world)
            }
        }

        when (marketBoardTaxRates.status.value) {
            200  -> return marketBoardTaxRates.body()
            404  -> throw Throwable()
            else -> throw Throwable()
        }
    }

    /**
     * Returns an array of marketable item IDs
     */
    suspend fun getMarketableItems(): IntArray {
        val marketBoardTaxRates = ktorClient.get("marketable")

        when (marketBoardTaxRates.status.value) {
            200  -> return marketBoardTaxRates.body()
            else -> throw Throwable()
        }
    }

    /**
     * Returns the most-recently updated items on the specified world or data center, along with the upload times for each item
     * @param world The world to request data for
     * @param dcName The data center to request data for
     * @param entries The number of entries to return (default `50`, max `200`)
     */
    suspend fun getMostRecentlyUpdatedItems(
        world: String? = null,
        dcName: String? = null,
        entries: Int? = null,
    ): RecentlyUpdatedItems {
        if (world == null && dcName == null) {
            throw Throwable()
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
                            entries > 200 -> throw Throwable()
                            entries <= 0  -> throw Throwable()
                            else          -> parameters.append(
                                "entries", entries.toString()
                            )
                        }
                    }
                }
            }

        when (mostRecentlyUpdatedItems.status.value) {
            200  -> return mostRecentlyUpdatedItems.body()
            404  -> throw Throwable()
            else -> throw Throwable()
        }
    }

    /**
     * Returns the total upload counts for each client application that uploads data to Universalis
     */
    suspend fun getUploadCountsByUploadApplication(): Array<SourceUploadCount> {
        val uploadCountsByUploadApplication =
            ktorClient.get("extra/stats/uploader-upload-counts")

        when (uploadCountsByUploadApplication.status.value) {
            200  -> return uploadCountsByUploadApplication.body()
            else -> throw Throwable()
        }
    }

    /**
     * Returns the world upload counts and proportions of the total uploads for each world
     */
    suspend fun getUploadCountsByWorld(): Map<String, WorldUploadCount> {
        val getUploadCountsByWorld = ktorClient.get("extra/stats/world-upload-counts")

        when (getUploadCountsByWorld.status.value) {
            200  -> return getUploadCountsByWorld.body()
            else -> throw Throwable()
        }
    }

    /**
     * Returns the number of uploads per day over the past 30 days
     */
    suspend fun getUploadsPerDay(): UploadCountHistory {
        val getUploadsPerDay = ktorClient.get("extra/stats/upload-history")

        when (getUploadsPerDay.status.value) {
            200  -> return getUploadsPerDay.body()
            else -> throw Throwable()
        }
    }
}
