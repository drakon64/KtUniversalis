package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.entities.SourceUploadCount
import cloud.drakon.ktuniversalis.entities.SupportedDataCenter
import cloud.drakon.ktuniversalis.entities.SupportedWorld
import cloud.drakon.ktuniversalis.entities.TaxRates
import cloud.drakon.ktuniversalis.entities.UploadCountHistory
import cloud.drakon.ktuniversalis.entities.WorldUploadCount
import cloud.drakon.ktuniversalis.exception.InvalidWorldException
import cloud.drakon.ktuniversalis.exception.UniversalisException
import cloud.drakon.ktuniversalis.world.World
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

internal expect val ktorClient: HttpClient

/**
 * Returns all data centers supported by the Universalis API.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getAvailableDataCenters(): List<SupportedDataCenter> = ktorClient.get(
    "data-centers"
).let {
    if (it.status.value == 200) return it.body()

    throw throwUniversalisException(it)
}

/**
 * Returns the IDs and names of all worlds supported by the Universalis API.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getAvailableWorlds(): List<SupportedWorld> = ktorClient.get("worlds").let {
    if (it.status.value == 200) return it.body()

    throw throwUniversalisException(it)
}

/**
 * Returns the current tax rate data for the specified world.
 * @param world The world or to retrieve data for. This may be an ID or a name.
 * @throws InvalidWorldException The world requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMarketTaxRates(world: World): TaxRates = ktorClient.get("tax-rates") {
    url {
        parameters.append("world", world.name)
    }
}.let {
    when (it.status.value) {
        200  -> it.body()
        404  -> throw throwInvalidWorldException(it)
        else -> throw throwUniversalisException(it)
    }
}

/**
 * Returns a list of marketable item IDs.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMarketableItems(): List<Int> = ktorClient.get("marketable").let {
    when (it.status.value) {
        200  -> it.body()
        else -> throw throwUniversalisException(it)
    }
}

/**
 * Returns the total upload counts for each client application that uploads data to Universalis.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getUploadCountsByUploadApplication(): List<SourceUploadCount> =
    ktorClient.get("extra/stats/uploader-upload-counts").let {
        when (it.status.value) {
            200  -> it.body()
            else -> throw throwUniversalisException(it)
        }
    }

/**
 * Returns the world upload counts and proportions of the total uploads for each world.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getUploadCountsByWorld(): Map<World, WorldUploadCount> = ktorClient.get(
    "extra/stats/world-upload-counts"
).let {
    when (it.status.value) {
        200  -> it.body()
        else -> throw throwUniversalisException(it)
    }
}

/**
 * Returns the number of uploads per day over the past 30 days.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getUploadsPerDay(): UploadCountHistory = ktorClient.get(
    "extra/stats/upload-history"
).let {
    when (it.status.value) {
        200  -> it.body()
        else -> throw throwUniversalisException(it)
    }
}
