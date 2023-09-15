package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.exception.InvalidItemException
import cloud.drakon.ktuniversalis.exception.UniversalisException
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import kotlinx.serialization.Serializable

@Serializable
private data class ProblemDetails(
    val type: String? = null,
    val title: String? = null,
    val status: Short? = null,
    val detail: String? = null,
    val instance: String? = null,
)

private suspend fun getExceptionMessage(httpResponse: HttpResponse) = (httpResponse.body() as ProblemDetails).toString()

internal suspend fun throwInvalidItemException(httpResponse: HttpResponse) = InvalidItemException(
    getExceptionMessage(httpResponse)
)

internal suspend fun throwUniversalisException(httpResponse: HttpResponse) = UniversalisException(
    getExceptionMessage(httpResponse)
)
