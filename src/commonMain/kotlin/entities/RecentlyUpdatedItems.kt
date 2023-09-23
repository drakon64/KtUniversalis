@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property items An array of item IDs, with the least/most recent first.
 */
@JsExport @Serializable
data class RecentlyUpdatedItems(val items: Array<WorldItemRecency>? = null) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as RecentlyUpdatedItems

        if (items != null) {
            if (other.items == null) return false
            if (!items.contentEquals(other.items)) return false
        } else if (other.items != null) return false

        return true
    }

    override fun hashCode(): Int {
        return items?.contentHashCode() ?: 0
    }
}
