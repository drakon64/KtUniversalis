@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.exception

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport
class UniversalisException(
    val type: String? = null,
    val title: String? = null,
    val status: Short? = null,
    val detail: String? = null,
    val instance: String? = null,
) : Throwable(detail ?: title)
