@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.exception

import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * Thrown when the item requested is invalid.
 */
@JsExport @Serializable
data class InvalidItemException(
    val type: String,
    val title: String,
    val status: Short,
    val traceId: String,
) : Throwable(title)
