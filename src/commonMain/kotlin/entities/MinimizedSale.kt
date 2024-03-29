@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import cloud.drakon.ktuniversalis.world.World
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property hq Whether or not the item was high-quality.
 * @property pricePerUnit The price per unit sold.
 * @property quantity The stack size sold.
 * @property buyerName The buyer's character name.
 * @property onMannequin Whether or not this was purchased from a mannequin.
 * @property timestamp The sale time, in seconds since the UNIX epoch.
 * @property world The [World], if applicable.
 */
@JsExport @Serializable
data class MinimizedSale(
    val hq: Boolean,
    val pricePerUnit: Int,
    val quantity: Short,
    val buyerName: String? = null,
    val onMannequin: Boolean? = null,
    val timestamp: Long,
    @SerialName("worldName") val world: World? = null,
)
