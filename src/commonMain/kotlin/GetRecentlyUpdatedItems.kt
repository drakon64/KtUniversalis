package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.entities.RecentlyUpdatedItems
import cloud.drakon.ktuniversalis.exception.UniversalisException
import cloud.drakon.ktuniversalis.world.DataCenter
import cloud.drakon.ktuniversalis.world.World
import io.ktor.client.call.body
import io.ktor.client.request.get

internal suspend fun getRecentlyUpdatedItems(
    world: World? = null,
    dataCenter: DataCenter? = null,
    entries: Short? = null,
    least: Boolean,
): RecentlyUpdatedItems = ktorClient.get(
    "extra/stats/" + if (least) {
        "least"
    } else {
        "most"
    } + "-recently-updated",
) {
    url {
        when {
            world != null -> parameters.append("world", world.name)
            dataCenter != null -> parameters.append("dcName", dataCenter.name)
        }

        if (entries != null) parameters.append("entries", entries.toString())
    }
}.let {
    when (it.status.value) {
        200 -> return it.body()
        else -> throw it.body<UniversalisException>()
    }
}

/**
 * Returns the least-recently updated items on the specified [World], along with the upload times for each item.
 * @param world The [World] to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getLeastRecentlyUpdatedItems(
    world: World,
    entries: Short? = null,
) = getRecentlyUpdatedItems(world = world, entries = entries, least = true)

/**
 * Returns the least-recently updated items on the specified [DataCenter], along with the upload times for each item.
 * @param dataCenter The [DataCenter] to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getLeastRecentlyUpdatedItems(
    dataCenter: DataCenter,
    entries: Short? = null,
) = getRecentlyUpdatedItems(dataCenter = dataCenter, entries = entries, least = true)

/**
 * Returns the most-recently updated items on the specified [World], along with the upload times for each item.
 * @param world The [World] to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMostRecentlyUpdatedItems(
    world: World,
    entries: Short? = null,
) = getRecentlyUpdatedItems(world = world, entries = entries, least = false)

/**
 * Returns the most-recently updated items on the specified [DataCenter], along with the upload times for each item.
 * @param dataCenter The [DataCenter] to request data for.
 * @param entries The number of entries to return (default `50`, max `200`).
 * @throws UniversalisException The Universalis API returned an unexpected return code.
 */
suspend fun getMostRecentlyUpdatedItems(
    dataCenter: DataCenter,
    entries: Short? = null,
) = getRecentlyUpdatedItems(dataCenter = dataCenter, entries = entries, least = false)
