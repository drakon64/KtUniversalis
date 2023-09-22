package cloud.drakon.ktuniversalis.exception

import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

internal suspend inline fun <reified T : KtUniversalisException> throwException(
    httpResponse: HttpResponse,
): T = httpResponse.body()
