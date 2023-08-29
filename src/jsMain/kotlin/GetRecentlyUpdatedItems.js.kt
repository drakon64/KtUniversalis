@file:OptIn(ExperimentalJsExport::class, DelicateCoroutinesApi::class)

package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.exception.UniversalisException
import cloud.drakon.ktuniversalis.world.DataCenter
import cloud.drakon.ktuniversalis.world.World
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

/**
 * Returns the least-recently updated items on the specified world, along with the upload times for each item.
 * @param world The world to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getLeastRecentlyUpdatedItemsByWorldAsync")
fun getLeastRecentlyUpdatedItemsAsync(
    world: World,
    entries: Short? = null,
) = GlobalScope.promise {
    getLeastRecentlyUpdatedItems(world, entries)
}

/**
 * Returns the least-recently updated items on the specified world or data center, along with the upload times for each item.
 * @param dcName The data center to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getLeastRecentlyUpdatedItemsByDataCenterAsync")
fun getLeastRecentlyUpdatedItemsAsync(
    dcName: DataCenter,
    entries: Short? = null,
) = GlobalScope.promise {
    getLeastRecentlyUpdatedItems(dcName, entries)
}

/**
 * Returns the most-recently updated items on the specified world, along with the upload times for each item.
 * @param world The world to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getMostRecentlyUpdatedItemsByWorldAsync")
fun getMostRecentlyUpdatedItemsAsync(
    world: World,
    entries: Short? = null,
) = GlobalScope.promise {
    getMostRecentlyUpdatedItems(world, entries)
}

/**
 * Returns the most-recently updated items on the specified data center, along with the upload times for each item.
 * @param dcName The data center to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JsExport @JsName("getMostRecentlyUpdatedItemsByDataCenterAsync")
fun getMostRecentlyUpdatedItemsAsync(
    dcName: DataCenter,
    entries: Short? = null,
) = GlobalScope.promise {
    getMostRecentlyUpdatedItems(dcName, entries)
}
