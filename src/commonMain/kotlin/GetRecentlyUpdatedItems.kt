package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.entities.RecentlyUpdatedItems
import io.ktor.client.call.body
import io.ktor.client.request.get

/**
 * @param world The world to request data for.
 * @param dcName The data center to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
private suspend fun getRecentlyUpdatedItems(
    world: String? = null,
    dcName: String? = null,
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
        if (world != null) parameters.append("world", world)

        if (dcName != null) parameters.append("dcName", dcName)

        if (entries != null) parameters.append("entries", entries.toString())
    }
}.let {
    when (it.status.value) {
        200  -> return it.body()
        else -> throw throwUniversalisException(it)
    }
}

/**
 * Returns the least-recently updated items on the specified world or data center, along with the upload times for each item.
 * @param world The world to request data for.
 * @param dcName The data center to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getLeastRecentlyUpdatedItems(
    world: String? = null,
    dcName: String? = null,
    entries: Short? = null,
) = getRecentlyUpdatedItems(world, dcName, entries, true)

/**
 * Returns the most-recently updated items on the specified world or data center, along with the upload times for each item.
 * @param world The world to request data for.
 * @param dcName The data center to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMostRecentlyUpdatedItems(
    world: String? = null,
    dcName: String? = null,
    entries: Short? = null,
) = getRecentlyUpdatedItems(world, dcName, entries, false)
