package cloud.drakon.ktuniversalis.entities

import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property hq Whether or not the item was high-quality
 * @property pricePerUnit The price per unit sold
 * @property quantity The stack size sold
 * @property buyerName The buyer's character name
 * @property onMannequin Whether or not this was purchased from a mannequin
 * @property timestamp The sale time, in seconds since the UNIX epoch
 * @property worldName The world name, if applicable
 * @property worldId The world ID, if applicable
 */
@JsExport @Serializable class MinimizedSale(
    val hq: Boolean,
    val pricePerUnit: Int,
    val quantity: Int,
    val buyerName: String? = null,
    val onMannequin: Boolean? = null,
    val timestamp: Long,
    val worldName: String? = null,
    @SerialName("worldID") val worldId: Int? = null,
)
