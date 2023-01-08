package cloud.drakon.ktuniversalis.response

import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property hq Whether or not the item was high-quality
 * @property pricePerUnit The price per unit sold
 * @property quantity The stack size sold
 * @property timestamp The sale time, in seconds since the UNIX epoch
 * @property onMannequin Whether or not this was purchased from a mannequin
 * @property worldName The world name, if applicable
 * @property worldId The world ID, if applicable
 * @property buyerName The buyer name
 * @property total The total price
 */
@JsExport @Serializable class Sale(
    val hq: Boolean,
    val pricePerUnit: Int,
    val quantity: Int,
    val timestamp: Long,
    val onMannequin: Boolean? = null,
    val worldName: String? = null,
    @SerialName("worldID") val worldId: Int? = null,
    val buyerName: String? = null,
    val total: Int,
)
