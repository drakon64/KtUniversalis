@file:OptIn(DelicateCoroutinesApi::class, ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.exception.UniversalisException
import cloud.drakon.ktuniversalis.world.DataCenter
import cloud.drakon.ktuniversalis.world.World
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

/**
 * Returns the least-recently updated items on the specified [World], along with the upload times for each item.
 *
 * This function is designed to be used from JavaScript. For use within Kotlin, see [getLeastRecentlyUpdatedItems].
 * @param world The [World] to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getLeastRecentlyUpdatedItemsByWorld")
fun getLeastRecentlyUpdatedItemsAsync(
    world: World,
    entries: Short? = null,
) = GlobalScope.promise {
    getRecentlyUpdatedItems(world, null, entries, true)
}

/**
 * Returns the least-recently updated items on the specified [DataCenter], along with the upload times for each item.
 *
 * This function is designed to be used from JavaScript. For use within Kotlin, see [getLeastRecentlyUpdatedItems].
 * @param dataCenter The [DataCenter] to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getLeastRecentlyUpdatedItemsByDataCenter")
fun getLeastRecentlyUpdatedItemsAsync(
    dataCenter: DataCenter,
    entries: Short? = null,
) = GlobalScope.promise {
    getRecentlyUpdatedItems(null, dataCenter, entries, true)
}

/**
 * Returns the most-recently updated items on the specified [World], along with the upload times for each item.
 *
 * This function is designed to be used from JavaScript. For use within Kotlin, see [getMostRecentlyUpdatedItems].
 * @param world The [World] to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getMostRecentlyUpdatedItemsByWorld")
fun getMostRecentlyUpdatedItemsAsync(
    world: World,
    entries: Short? = null,
) = GlobalScope.promise {
    getRecentlyUpdatedItems(world, null, entries, false)
}

/**
 * Returns the most-recently updated items on the specified [DataCenter], along with the upload times for each item.
 *
 * This function is designed to be used from JavaScript. For use within Kotlin, see [getMostRecentlyUpdatedItems].
 * @param dataCenter The [DataCenter] to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getMostRecentlyUpdatedItemsByDataCenter")
fun getMostRecentlyUpdatedItemsAsync(
    dataCenter: DataCenter,
    entries: Short? = null,
) = GlobalScope.promise {
    getRecentlyUpdatedItems(null, dataCenter, entries, false)
}
