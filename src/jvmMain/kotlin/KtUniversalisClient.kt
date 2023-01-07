package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.response.AvailableDataCenter
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

        expectSuccess = true
    }

    /**
     * Returns all data centers supported by the Universalis API
     */
    suspend fun getAvailableDataCenters(): Array<AvailableDataCenter> =
        ktorClient.get("data-centers").body()
}
