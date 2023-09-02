@file:JvmName("KtUniversalis") @file:JvmMultifileClass @file:OptIn(DelicateCoroutinesApi::class)

package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.exception.UniversalisException
import cloud.drakon.ktuniversalis.world.DataCenter
import cloud.drakon.ktuniversalis.world.World
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.future.future

/**
 * Returns the least-recently updated items on the specified world, along with the upload times for each item.
 * @param world The world to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmName("getLeastRecentlyUpdatedItems")
@JvmOverloads
@Throws(UniversalisException::class) fun getLeastRecentlyUpdatedItemsAsync(
    world: World,
    entries: Short? = null,
) = GlobalScope.future {
    getRecentlyUpdatedItems(world, null, entries, true)
}

/**
 * Returns the least-recently updated items on the specified data center, along with the upload times for each item.
 * @param dcName The data center to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmName("getLeastRecentlyUpdatedItems")
@JvmOverloads
@Throws(UniversalisException::class) fun getLeastRecentlyUpdatedItemsAsync(
    dcName: DataCenter,
    entries: Short? = null,
) = GlobalScope.future {
    getRecentlyUpdatedItems(null, dcName, entries, true)
}

/**
 * Returns the most-recently updated items on the specified world, along with the upload times for each item.
 * @param world The world to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmName("getMostRecentlyUpdatedItems")
@JvmOverloads
@Throws(UniversalisException::class) fun getMostRecentlyUpdatedItemsAsync(
    world: World,
    entries: Short? = null,
) = GlobalScope.future {
    getRecentlyUpdatedItems(world, null, entries, false)
}

/**
 * Returns the most-recently updated items on the specified data center, along with the upload times for each item.
 * @param dcName The data center to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
@JvmName("getMostRecentlyUpdatedItems")
@JvmOverloads
@Throws(UniversalisException::class) fun getMostRecentlyUpdatedItemsAsync(
    dcName: DataCenter,
    entries: Short? = null,
) = GlobalScope.future {
    getRecentlyUpdatedItems(null, dcName, entries, false)
}
