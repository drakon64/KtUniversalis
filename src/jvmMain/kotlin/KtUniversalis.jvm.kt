@file:JvmName("KtUniversalis") @file:JvmMultifileClass @file:OptIn(DelicateCoroutinesApi::class)

package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.exception.UniversalisException
import cloud.drakon.ktuniversalis.world.World
import io.ktor.client.HttpClient
import io.ktor.client.engine.java.Java
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.future.future
import kotlinx.serialization.json.Json

internal actual val ktorClient = HttpClient(Java) {
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
@Throws(UniversalisException::class) fun getAvailableDataCentersAsync() =
    GlobalScope.future {
        getAvailableDataCenters()
    }

/**
 * Returns the IDs and names of all worlds supported by the Universalis API.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@Throws(UniversalisException::class) fun getAvailableWorldsAsync() =
    GlobalScope.future {
        getAvailableWorlds()
    }

/**
 * Returns the current tax rate data for the specified world.
 * @param world The world or to retrieve data for. This may be an ID or a name.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@Throws(UniversalisException::class) fun getMarketTaxRatesAsync(world: World) =
    GlobalScope.future {
        getMarketTaxRates(world)
    }

/**
 * Returns a list of marketable item IDs.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@Throws(UniversalisException::class) fun getMarketableItemsAsync() =
    GlobalScope.future {
        getMarketableItems()
    }

/**
 * Returns the total upload counts for each client application that uploads data to Universalis.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@Throws(UniversalisException::class) fun getUploadCountsByUploadApplicationAsync() =
    GlobalScope.future {
        getUploadCountsByUploadApplication()
    }

/**
 * Returns the world upload counts and proportions of the total uploads for each world.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@Throws(UniversalisException::class) fun getUploadCountsByWorldAsync() =
    GlobalScope.future {
        getUploadCountsByWorld()
    }

/**
 * Returns the number of uploads per day over the past 30 days.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@Throws(UniversalisException::class) fun getUploadsPerDayAsync() = GlobalScope.future {
    getUploadsPerDay()
}
