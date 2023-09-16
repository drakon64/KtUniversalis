package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.exception.InvalidItemException
import cloud.drakon.ktuniversalis.exception.UniversalisException
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import kotlinx.serialization.Serializable

@Serializable
private class UniversalisProblemDetails(
    val type: String? = null,
    val title: String ? = null,
    val status: Short? = null,
    val detail: String? = null,
    val instance: String? = null
) {
    override fun toString() = "ProblemDetails(type=$type, title=$title, status=$status, detail=$detail, instance=$instance)"
}

@Serializable
private class CloudflareProblemDetails(
    val type: String,
    val title: String,
    val status: Short,
    val traceId: String,
) {
    override fun toString() = "ProblemDetails(type=$type, title=$title, status=$status, traceId=$traceId)"
}

internal suspend fun throwInvalidItemException(httpResponse: HttpResponse) = InvalidItemException(
    (httpResponse.body() as CloudflareProblemDetails).toString()
)

internal suspend fun throwUniversalisException(httpResponse: HttpResponse) = UniversalisException(
    (httpResponse.body() as UniversalisProblemDetails).toString()
)
