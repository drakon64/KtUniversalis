@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.exception

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * Thrown when the item requested is invalid.
 */
@JsExport
class InvalidItemException(
    val type: String,
    val title: String,
    val status: Short,
    val traceId: String,
) : Throwable(title), KtUniversalisException
