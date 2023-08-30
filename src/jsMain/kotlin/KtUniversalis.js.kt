@file:OptIn(
    DelicateCoroutinesApi::class,
    ExperimentalJsExport::class,
    ExperimentalSerializationApi::class
)

package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.exception.InvalidWorldException
import cloud.drakon.ktuniversalis.exception.UniversalisException
import cloud.drakon.ktuniversalis.world.World
import io.ktor.client.HttpClient
import io.ktor.client.engine.js.Js
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToDynamic

internal actual val ktorClient = HttpClient(Js) {
    install(ContentNegotiation) {
        json(Json {
            ignoreUnknownKeys = true
        })
    }

    install(DefaultRequest) {
        url("https://universalis.app/api/v2/")
    }
}

/**
 * Returns all data centers supported by the Universalis API.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport fun getAvailableDataCentersAsync() = GlobalScope.promise {
    getAvailableDataCenters().toTypedArray()
}

/**
 * Returns the IDs and names of all worlds supported by the Universalis API.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport fun getAvailableWorldsAsync() = GlobalScope.promise {
    getAvailableWorlds().toTypedArray()
}

/**
 * Returns the current tax rate data for the specified world.
 * @param world The world or to retrieve data for. This may be an ID or a name.
 * @throws InvalidWorldException The world requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport fun getMarketTaxRatesAsync(world: World) = GlobalScope.promise {
    getMarketTaxRates(world)
}

/**
 * Returns an array of marketable item IDs.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport fun getMarketableItemsAsync() = GlobalScope.promise {
    getMarketableItems().toIntArray()
}

/**
 * Returns the total upload counts for each client application that uploads data to Universalis.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport fun getUploadCountsByUploadApplicationAsync() = GlobalScope.promise {
    getUploadCountsByUploadApplication().toTypedArray()
}

/**
 * Returns the world upload counts and proportions of the total uploads for each world.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport fun getUploadCountsByWorldAsync() = GlobalScope.promise {
    Json.encodeToDynamic(getUploadCountsByWorld())
}

/**
 * Returns the number of uploads per day over the past 30 days.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport fun getUploadsPerDayAsync() = GlobalScope.promise {
    getUploadsPerDay()
}
