@file:JvmName("KtUniversalis") @file:JvmMultifileClass @file:OptIn(DelicateCoroutinesApi::class)

package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.exception.UniversalisException
import cloud.drakon.ktuniversalis.world.DataCenter
import cloud.drakon.ktuniversalis.world.World
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.future.future

/**
 * Get the least-recently updated items on the specified [World], along with the upload times for each item.
 *
 * This function is designed to be used from non-Kotlin JVM languages. For use within Kotlin, see [getLeastRecentlyUpdatedItems].
 * @param world The [World] to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmName("getLeastRecentlyUpdatedItems")
@JvmOverloads
@Throws(UniversalisException::class)
fun getLeastRecentlyUpdatedItemsAsync(
    world: World,
    entries: Short? = null,
) = GlobalScope.future {
    getRecentlyUpdatedItems(world, null, entries, true)
}

/**
 * Get the least-recently updated items on the specified [DataCenter], along with the upload times for each item.
 *
 * This function is designed to be used from non-Kotlin JVM languages. For use within Kotlin, see [getLeastRecentlyUpdatedItems].
 * @param dataCenter The [DataCenter] to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmName("getLeastRecentlyUpdatedItems")
@JvmOverloads
@Throws(UniversalisException::class)
fun getLeastRecentlyUpdatedItemsAsync(
    dataCenter: DataCenter,
    entries: Short? = null,
) = GlobalScope.future {
    getRecentlyUpdatedItems(null, dataCenter, entries, true)
}

/**
 * Get the most-recently updated items on the specified [World], along with the upload times for each item.
 *
 * This function is designed to be used from non-Kotlin JVM languages. For use within Kotlin, see [getMostRecentlyUpdatedItems].
 * @param world The [World] to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmName("getMostRecentlyUpdatedItems")
@JvmOverloads
@Throws(UniversalisException::class)
fun getMostRecentlyUpdatedItemsAsync(
    world: World,
    entries: Short? = null,
) = GlobalScope.future {
    getRecentlyUpdatedItems(world, null, entries, false)
}

/**
 * Get the most-recently updated items on the specified [DataCenter], along with the upload times for each item.
 *
 * This function is designed to be used from non-Kotlin JVM languages. For use within Kotlin, see [getMostRecentlyUpdatedItems].
 * @param dataCenter The [DataCenter] to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmName("getMostRecentlyUpdatedItems")
@JvmOverloads
@Throws(UniversalisException::class)
fun getMostRecentlyUpdatedItemsAsync(
    dataCenter: DataCenter,
    entries: Short? = null,
) = GlobalScope.future {
    getRecentlyUpdatedItems(null, dataCenter, entries, false)
}
