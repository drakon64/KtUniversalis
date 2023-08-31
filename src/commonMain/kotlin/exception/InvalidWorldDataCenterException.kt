@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.exception

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * Thrown when the world/DC requested is invalid.
 */
@JsExport class InvalidWorldDataCenterException(message: String): Exception(message)
