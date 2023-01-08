package cloud.drakon.ktuniversalis.entities

import kotlin.js.JsExport
import kotlinx.serialization.Serializable

/**
 * @property uploadCountByDay The list of upload counts per day, over the past 30 days
 */
@JsExport @Serializable class UploadCountHistory(val uploadCountByDay: IntArray? = null)
