package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.entities.CloudflareProblemDetails
import cloud.drakon.ktuniversalis.entities.UniversalisProblemDetails
import cloud.drakon.ktuniversalis.exception.InvalidItemException
import cloud.drakon.ktuniversalis.exception.UniversalisException
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

@Suppress("IMPLICIT_CAST_TO_ANY")
private suspend fun getExceptionMessage(httpResponse: HttpResponse) =
    (
        if (httpResponse.status.value !in intArrayOf(502, 504)) {
            httpResponse.body() as UniversalisProblemDetails
        } else {
            httpResponse.body() as CloudflareProblemDetails
        }
        ).toString()

internal suspend fun throwInvalidItemException(httpResponse: HttpResponse) =
    InvalidItemException(getExceptionMessage(httpResponse))

internal suspend fun throwUniversalisException(httpResponse: HttpResponse) =
    UniversalisException(getExceptionMessage(httpResponse))
