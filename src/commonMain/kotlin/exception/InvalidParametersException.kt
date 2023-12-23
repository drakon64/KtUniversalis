@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.exception

import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport @Serializable
data class InvalidParametersException(
    val type: String? = null,
    val title: String? = null,
    val status: Short? = null,
    val detail: String? = null,
    val instance: String? = null,
) : Throwable(detail ?: title)
