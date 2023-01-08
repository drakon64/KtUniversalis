package cloud.drakon.ktuniversalis.response

import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@JsExport @Serializable class RecentlyUpdatedItem(
    @SerialName("itemID") val itemId: Int,
    val lastUploadTime: Long,
    @SerialName("worldID") val worldId: Int,
    val worldName: String,
)
