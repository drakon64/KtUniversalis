@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.exception

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * Thrown when the world/DC or item requested is invalid.
 */
@JsExport class InvalidWorldDataCenterItemException(message: String): Exception(message)
