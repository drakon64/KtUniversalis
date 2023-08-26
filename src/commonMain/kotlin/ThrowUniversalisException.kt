package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.entities.ProblemDetails
import cloud.drakon.ktuniversalis.exception.UniversalisException
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

internal suspend fun throwUniversalisException(httpResponse: HttpResponse) =
    UniversalisException((httpResponse.body() as ProblemDetails).toString())
