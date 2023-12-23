@file:OptIn(DelicateCoroutinesApi::class, ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.exception.UniversalisException
import cloud.drakon.ktuniversalis.world.World
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

/**
 * Returns the current tax rate data for the specified [World].
 *
 * This function is designed to be used from JavaScript. For use within Kotlin, see [getMarketTaxRates].
 * @param world The [World] to retrieve data for.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getMarketTaxRates")
fun getMarketTaxRatesAsync(world: World) = GlobalScope.promise {
    getMarketTaxRates(world)
}

/**
 * Returns a list of marketable item IDs.
 *
 * This function is designed to be used from JavaScript. For use within Kotlin, see [getMarketableItems].
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getMarketableItems")
fun getMarketableItemsAsync() = GlobalScope.promise {
    getMarketableItems()
}

/**
 * Returns the total upload counts for each client application that uploads data to Universalis.
 *
 * This function is designed to be used from JavaScript. For use within Kotlin, see [getUploadCountsByUploadApplication].
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getUploadCountsByUploadApplication")
fun getUploadCountsByUploadApplicationAsync() = GlobalScope.promise {
    getUploadCountsByUploadApplication()
}

/**
 * Returns the world upload counts and proportions of the total uploads for each world.
 *
 * This function is designed to be used from JavaScript. For use within Kotlin, see [getUploadCountsByWorld].
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getUploadCountsByWorld")
fun getUploadCountsByWorldAsync() = GlobalScope.promise {
    getUploadCountsByWorld()
}

/**
 * Returns the number of uploads per day over the past 30 days.
 *
 * This function is designed to be used from JavaScript. For use within Kotlin, see [getUploadsPerDay].
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getUploadsPerDay")
fun getUploadsPerDayAsync() = GlobalScope.promise {
    getUploadsPerDay()
}
