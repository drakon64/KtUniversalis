@file:JvmName("KtUniversalis") @file:JvmMultifileClass @file:OptIn(DelicateCoroutinesApi::class)

package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.exception.UniversalisException
import cloud.drakon.ktuniversalis.world.World
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.future.future

/**
 * Returns the current tax rate data for the specified [World].
 * @param world The [World] to retrieve data for.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@Throws(UniversalisException::class)
fun getMarketTaxRatesAsync(world: World) = GlobalScope.future {
    getMarketTaxRates(world)
}

/**
 * Returns a list of marketable item IDs.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@Throws(UniversalisException::class)
fun getMarketableItemsAsync() = GlobalScope.future {
    getMarketableItems()
}

/**
 * Returns the total upload counts for each client application that uploads data to Universalis.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@Throws(UniversalisException::class)
fun getUploadCountsByUploadApplicationAsync() = GlobalScope.future {
    getUploadCountsByUploadApplication()
}

/**
 * Returns the world upload counts and proportions of the total uploads for each world.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@Throws(UniversalisException::class)
fun getUploadCountsByWorldAsync() = GlobalScope.future {
    getUploadCountsByWorld()
}

/**
 * Returns the number of uploads per day over the past 30 days.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@Throws(UniversalisException::class)
fun getUploadsPerDayAsync() = GlobalScope.future {
    getUploadsPerDay()
}
