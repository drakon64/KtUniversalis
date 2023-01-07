package cloud.drakon.ktuniversalis.response

import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@JsExport @Serializable class RecentlyUpdatedItem(
    @SerialName("itemID") val itemId: Short,
    val lastUploadTime: Long,
    @SerialName("worldID") val worldId: Short,
    val worldName: String,
)
