@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.entities

import cloud.drakon.ktuniversalis.world.World
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property lastReviewTime The time that this listing was posted, in seconds since the UNIX epoch.
 * @property pricePerUnit The price per unit sold.
 * @property quantity The stack size sold.
 * @property stainId The ID of the dye on this item.
 * @property world The [World], if applicable.
 * @property creatorName The creator's character name.
 * @property creatorId A SHA256 hash of the creator's ID.
 * @property hq Whether or not the item is high-quality.
 * @property isCrafted Whether or not the item is crafted.
 * @property listingId A SHA256 hash of the ID of this listing.
 * @property materia The materia on this item.
 * @property onMannequin Whether or not the item is being sold on a mannequin.
 * @property retainerCity The [City] of the retainer.
 * @property retainerId A SHA256 hash of the retainer's ID.
 * @property retainerName The retainer's name.
 * @property sellerId A SHA256 hash of the seller's ID.
 * @property total The total price.
 */
@JsExport @Serializable
data class Listing(
    val lastReviewTime: Long,
    val pricePerUnit: Int,
    val quantity: Short,
    @SerialName("stainID") val stainId: Int,
    @SerialName("worldName") val world: World? = null,
    val creatorName: String? = null,
    @SerialName("creatorID") val creatorId: String? = null,
    val hq: Boolean,
    val isCrafted: Boolean,
    @SerialName("listingID") val listingId: String? = null,
    val materia: List<Materia>? = null,
    val onMannequin: Boolean,
    @SerialName("retainerCity") private val retainerCityId: Byte,
    @SerialName("retainerID") val retainerId: String? = null,
    val retainerName: String? = null,
    @SerialName("sellerID") val sellerId: String? = null,
    val total: Int,
) {
    @Transient val retainerCity = City.idToCity.getValue(retainerCityId)
}
