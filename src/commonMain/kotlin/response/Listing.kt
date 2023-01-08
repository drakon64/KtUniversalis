package cloud.drakon.ktuniversalis.response

import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@JsExport @Serializable class Listing(
    val lastReviewTime: Long,
    val pricePerUnit: Int,
    val quantity: Byte,
    @SerialName("stainID") val stainId: Byte,
    val creatorName: String,
    @SerialName("creatorID") val creatorId: String,
    val hq: Boolean,
    val isCrafted: Boolean,
    @SerialName("listingID") val listingId: String,
    val materia: Array<Materia>,
    val onMannequin: Boolean,
    val retainerCity: Byte,
    @SerialName("retainerID") val retainerId: String,
    val retainerName: String,
    @SerialName("sellerID") val sellerId: String,
    val total: Int,
)
