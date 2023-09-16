@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property uploadCountByDay The list of upload counts per day, over the past 30 days.
 */
@JsExport @Serializable
data class UploadCountHistory(val uploadCountByDay: IntArray? = null) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as UploadCountHistory

        if (uploadCountByDay != null) {
            if (other.uploadCountByDay == null) return false
            if (!uploadCountByDay.contentEquals(other.uploadCountByDay)) return false
        } else if (other.uploadCountByDay != null) return false

        return true
    }

    override fun hashCode(): Int {
        return uploadCountByDay?.contentHashCode() ?: 0
    }
}
