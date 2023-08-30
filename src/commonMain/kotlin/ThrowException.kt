package cloud.drakon.ktuniversalis

import cloud.drakon.ktuniversalis.entities.ProblemDetails
import cloud.drakon.ktuniversalis.exception.InvalidParametersException
import cloud.drakon.ktuniversalis.exception.InvalidWorldDataCenterException
import cloud.drakon.ktuniversalis.exception.InvalidWorldDataCenterItemException
import cloud.drakon.ktuniversalis.exception.InvalidWorldException
import cloud.drakon.ktuniversalis.exception.UniversalisException
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

internal suspend fun throwInvalidWorldDataCenterException(httpResponse: HttpResponse) =
    InvalidWorldDataCenterException((httpResponse.body() as ProblemDetails).toString())

internal suspend fun throwInvalidParametersException(httpResponse: HttpResponse) =
    InvalidParametersException((httpResponse.body() as ProblemDetails).toString())

internal suspend fun throwInvalidWorldDataCenterItemException(httpResponse: HttpResponse) =
    InvalidWorldDataCenterItemException((httpResponse.body() as ProblemDetails).toString())

internal suspend fun throwInvalidWorldException(httpResponse: HttpResponse) =
    InvalidWorldException((httpResponse.body() as ProblemDetails).toString())

internal suspend fun throwUniversalisException(httpResponse: HttpResponse) =
    UniversalisException((httpResponse.body() as ProblemDetails).toString())
