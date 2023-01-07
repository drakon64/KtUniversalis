package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.response.AvailableDataCenter
import cloud.drakon.ktuniversalis.response.AvailableWorld
import cloud.drakon.ktuniversalis.response.LeastRecentlyUpdatedItems
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.java.Java
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json

actual class KtUniversalisClient {
    private val ktorClient = HttpClient(Java) {
        install(ContentNegotiation) {
            json()
        }

        install(DefaultRequest) {
            url("https://universalis.app/api/v2/")
        }
    }

    /**
     * Returns all data centers supported by the Universalis API
     */
    suspend fun getAvailableDataCenters(): Array<AvailableDataCenter> =
        ktorClient.get("data-centers").body()

    /**
     * Returns the IDs and names of all worlds supported by the Universalis API
     */
    suspend fun getAvailableWorlds(): Array<AvailableWorld> =
        ktorClient.get("worlds").body()

    /**
     * Returns the least-recently updated items on the specified world or data center, along with the upload times for each item
     * @param world The world to request data for
     * @param dcName The data center to request data for
     * @param entries The number of entries to return (default `50`, max `200`)
     */
    suspend fun getLeastRecentlyUpdatedItems(
        world: String? = null,
        dcName: String? = null,
        entries: Short = 50,
    ): LeastRecentlyUpdatedItems {
        if (world == null && dcName == null) {
            throw Throwable()
        }

        when {
            entries > 200 -> throw Throwable()
            entries <= 0  -> throw Throwable()
        }

        val leastRecentlyUpdatedItems =
            ktorClient.get("extra/stats/least-recently-updated") {
                url {
                    if (world != null) {
                        parameters.append("world", world)
                    }
                    if (dcName != null) {
                        parameters.append("dcName", dcName)
                    }
                    parameters.append("entries", entries.toString())
                }
            }

        when (leastRecentlyUpdatedItems.status.value) {
            200  -> {
                return leastRecentlyUpdatedItems.body()
            }

            404  -> {
                throw Throwable()
            }

            else -> {
                throw Throwable()
            }
        }
    }
}
