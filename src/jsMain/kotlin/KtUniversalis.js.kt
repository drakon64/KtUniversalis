@file:OptIn(
    DelicateCoroutinesApi::class,
    ExperimentalJsExport::class,
    ExperimentalSerializationApi::class
)

package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.exception.UniversalisException
import cloud.drakon.ktuniversalis.world.World
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToDynamic

/**
 * Returns all data centers supported by the Universalis API.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getAvailableDataCenters") fun getAvailableDataCentersAsync() =
    GlobalScope.promise {
        getAvailableDataCenters().toTypedArray()
    }

/**
 * Returns the IDs and names of all worlds supported by the Universalis API.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getAvailableWorlds") fun getAvailableWorldsAsync() =
    GlobalScope.promise {
        getAvailableWorlds().toTypedArray()
    }

/**
 * Returns the current tax rate data for the specified world.
 * @param world The world or to retrieve data for. This may be an ID or a name.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getMarketTaxRates") fun getMarketTaxRatesAsync(world: World) =
    GlobalScope.promise {
        getMarketTaxRates(world)
    }

/**
 * Returns an array of marketable item IDs.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getMarketableItems") fun getMarketableItemsAsync() =
    GlobalScope.promise {
        getMarketableItems().toIntArray()
    }

/**
 * Returns the total upload counts for each client application that uploads data to Universalis.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getUploadCountsByUploadApplication")
fun getUploadCountsByUploadApplicationAsync() = GlobalScope.promise {
    getUploadCountsByUploadApplication().toTypedArray()
}

/**
 * Returns the world upload counts and proportions of the total uploads for each world.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getUploadCountsByWorld") fun getUploadCountsByWorldAsync() =
    GlobalScope.promise {
        Json.encodeToDynamic(getUploadCountsByWorld())
    }

/**
 * Returns the number of uploads per day over the past 30 days.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getUploadsPerDay") fun getUploadsPerDayAsync() =
    GlobalScope.promise {
        getUploadsPerDay()
    }
