@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property uploadCountByDay The list of upload counts per day, over the past 30 days.
 */
@JsExport @Serializable
data class UploadCountHistory(val uploadCountByDay: List<Long>? = null)
