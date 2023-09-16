package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.exception.InvalidItemException
import cloud.drakon.ktuniversalis.exception.UniversalisException
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import kotlinx.serialization.Serializable

@Serializable
private class ProblemDetails(
    val type: String,
    val title: String,
    val status: Short,
    val traceId: String,
) {
    override fun toString() = "ProblemDetails(type=$type, title=$title, status=$status, traceId=$traceId)"
}

private suspend fun getExceptionMessage(httpResponse: HttpResponse) = (httpResponse.body() as ProblemDetails).toString()

internal suspend fun throwInvalidItemException(httpResponse: HttpResponse) = InvalidItemException(
    getExceptionMessage(httpResponse)
)

internal suspend fun throwUniversalisException(httpResponse: HttpResponse) = UniversalisException(
    getExceptionMessage(httpResponse)
)
