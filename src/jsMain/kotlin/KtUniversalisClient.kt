package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.response.AvailableDataCenter
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.js.Js
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlin.js.Promise
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@JsExport actual class KtUniversalisClient {
    private val ktorClient = HttpClient(Js) {
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
    fun getAvailableDataCenters(): Promise<Array<AvailableDataCenter>> =
        GlobalScope.promise {
            return@promise ktorClient.get("data-centers").body()
        }
}
