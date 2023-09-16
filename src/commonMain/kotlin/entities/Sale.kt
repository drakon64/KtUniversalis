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
 * @property timestamp The sale time, in seconds since the UNIX epoch.
 * @property onMannequin Whether or not this was purchased from a mannequin.
 * @property world The [World], if applicable.
 * @property buyerName The buyer name.
 * @property total The total price.
 */
@JsExport @Serializable
data class Sale(
    val hq: Boolean,
    val pricePerUnit: Int,
    val quantity: Byte,
    val timestamp: Long,
    val onMannequin: Boolean? = null,
    @SerialName("worldName") val world: World? = null,
    val buyerName: String? = null,
    val total: Int,
)
