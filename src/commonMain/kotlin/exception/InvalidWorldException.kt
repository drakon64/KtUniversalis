@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.exception

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * Thrown when the world requested is invalid.
 */
@JsExport class InvalidWorldException(message: String): Exception(message)
