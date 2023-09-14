package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.entities.SourceUploadCount
import cloud.drakon.ktuniversalis.entities.TaxRates
import cloud.drakon.ktuniversalis.entities.UploadCountHistory
import cloud.drakon.ktuniversalis.entities.WorldUploadCount
import cloud.drakon.ktuniversalis.exception.UniversalisException
import cloud.drakon.ktuniversalis.world.World
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlin.js.JsName

internal val ktorClient = HttpClient {
    install(ContentNegotiation) {
        json(Json { ignoreUnknownKeys = true })
    }

    install(DefaultRequest) {
        url("https://universalis.app/api/v2/")
    }
}

/**
 * Returns the current tax rate data for the specified [World].
 * @param world The [World] to retrieve data for.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsName("getMarketTaxRatesSuspend")
suspend fun getMarketTaxRates(world: World): TaxRates = ktorClient.get("tax-rates") {
    url {
        parameters.append("world", world.name)
    }
}.let {
    when (it.status.value) {
        200 -> it.body()
        else -> throw throwUniversalisException(it)
    }
}

/**
 * Returns a list of marketable item IDs.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsName("getMarketableItemsSuspend")
suspend fun getMarketableItems(): List<Int> = ktorClient.get("marketable").let {
    when (it.status.value) {
        200 -> it.body()
        else -> throw throwUniversalisException(it)
    }
}

/**
 * Returns the total upload counts for each client application that uploads data to Universalis.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsName("getUploadCountsByUploadApplicationSuspend")
suspend fun getUploadCountsByUploadApplication(): List<SourceUploadCount> = ktorClient.get(
    "extra/stats/uploader-upload-counts"
).let {
    when (it.status.value) {
        200 -> it.body()
        else -> throw throwUniversalisException(it)
    }
}

/**
 * Returns the world upload counts and proportions of the total uploads for each [World].
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsName("getUploadCountsByWorldSuspend")
suspend fun getUploadCountsByWorld(): Map<World, WorldUploadCount> = ktorClient.get(
    "extra/stats/world-upload-counts",
).let {
    when (it.status.value) {
        200 -> it.body()
        else -> throw throwUniversalisException(it)
    }
}

/**
 * Returns the number of uploads per day over the past 30 days.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsName("getUploadsPerDaySuspend")
suspend fun getUploadsPerDay(): UploadCountHistory = ktorClient.get(
    "extra/stats/upload-history",
).let {
    when (it.status.value) {
        200 -> it.body()
        else -> throw throwUniversalisException(it)
    }
}
