package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.entities.RecentlyUpdatedItems
import cloud.drakon.ktuniversalis.exception.InvalidWorldDataCenterException
import cloud.drakon.ktuniversalis.exception.UniversalisException
import cloud.drakon.ktuniversalis.world.DataCenter
import cloud.drakon.ktuniversalis.world.World
import io.ktor.client.call.body
import io.ktor.client.request.get

private suspend fun getRecentlyUpdatedItems(
    world: World? = null,
    dcName: DataCenter? = null,
    entries: Short? = null,
    least: Boolean,
): RecentlyUpdatedItems = ktorClient.get(
    "extra/stats/" + if (least) {
        "least"
    } else {
        "most"
    } + "-recently-updated"
) {
    url {
        when {
            world != null  -> parameters.append("world", world.name)
            dcName != null -> parameters.append("dcName", dcName.name)
        }

        if (entries != null) parameters.append("entries", entries.toString())
    }
}.let {
    when (it.status.value) {
        200  -> return it.body()
        404  -> throw throwInvalidWorldDataCenterException(it)
        else -> throw throwUniversalisException(it)
    }
}

/**
 * Returns the least-recently updated items on the specified world, along with the upload times for each item.
 * @param world The world to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws InvalidWorldDataCenterException The world/DC requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getLeastRecentlyUpdatedItems(
    world: World,
    entries: Short? = null,
) = getRecentlyUpdatedItems(world = world, entries = entries, least = true)

/**
 * Returns the least-recently updated items on the specified data center, along with the upload times for each item.
 * @param dcName The data center to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws InvalidWorldDataCenterException The world/DC requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getLeastRecentlyUpdatedItems(
    dcName: DataCenter,
    entries: Short? = null,
) = getRecentlyUpdatedItems(dcName = dcName, entries = entries, least = true)

/**
 * Returns the most-recently updated items on the specified world, along with the upload times for each item.
 * @param world The world to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws InvalidWorldDataCenterException The world/DC requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMostRecentlyUpdatedItems(
    world: World,
    entries: Short? = null,
) = getRecentlyUpdatedItems(world = world, entries = entries, least = false)

/**
 * Returns the most-recently updated items on the specified data center, along with the upload times for each item.
 * @param dcName The data center to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws InvalidWorldDataCenterException The world/DC requested is invalid.
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMostRecentlyUpdatedItems(
    dcName: DataCenter,
    entries: Short? = null,
) = getRecentlyUpdatedItems(dcName = dcName, entries = entries, least = false)
