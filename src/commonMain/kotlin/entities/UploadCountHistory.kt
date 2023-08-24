@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.Serializable

/**
 * @property uploadCountByDay The list of upload counts per day, over the past 30 days
 */
@JsExport
@Serializable
data class UploadCountHistory(val uploadCountByDay: List<Int>? = null)
