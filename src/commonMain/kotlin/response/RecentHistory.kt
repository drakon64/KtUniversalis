package cloud.drakon.ktuniversalis.response

import kotlin.js.JsExport
import kotlinx.serialization.Serializable

@JsExport @Serializable class RecentHistory(
    val hq: Boolean,
    val pricePerUnit: Int,
    val quantity: Byte,
    val timestamp: Int,
    val onMannequin: Boolean,
    val buyerName: String,
    val total: Int,
)
