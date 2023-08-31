@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.exception

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * Thrown when the parameters were invalid.
 */
@JsExport class InvalidParametersException(message: String): Exception(message)
