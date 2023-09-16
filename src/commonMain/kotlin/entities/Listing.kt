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
    val quantity: Byte,
    @SerialName("stainID") val stainId: Int,
    @SerialName("worldName") val world: World? = null,
    val creatorName: String? = null,
    @SerialName("creatorID") val creatorId: String? = null,
    val hq: Boolean,
    val isCrafted: Boolean,
    @SerialName("listingID") val listingId: String? = null,
    val materia: Array<Materia>? = null,
    val onMannequin: Boolean,
    @SerialName("retainerCity") private val retainerCityId: Byte,
    @SerialName("retainerID") val retainerId: String? = null,
    val retainerName: String? = null,
    @SerialName("sellerID") val sellerId: String? = null,
    val total: Int,
) {
    @Transient val retainerCity = idToCity.getValue(retainerCityId)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Listing

        if (lastReviewTime != other.lastReviewTime) return false
        if (pricePerUnit != other.pricePerUnit) return false
        if (quantity != other.quantity) return false
        if (stainId != other.stainId) return false
        if (world != other.world) return false
        if (creatorName != other.creatorName) return false
        if (creatorId != other.creatorId) return false
        if (hq != other.hq) return false
        if (isCrafted != other.isCrafted) return false
        if (listingId != other.listingId) return false
        if (materia != null) {
            if (other.materia == null) return false
            if (!materia.contentEquals(other.materia)) return false
        } else if (other.materia != null) return false
        if (onMannequin != other.onMannequin) return false
        if (retainerCity != other.retainerCity) return false
        if (retainerId != other.retainerId) return false
        if (retainerName != other.retainerName) return false
        if (sellerId != other.sellerId) return false
        if (total != other.total) return false

        return true
    }

    override fun hashCode(): Int {
        var result = lastReviewTime.hashCode()
        result = 31 * result + pricePerUnit
        result = 31 * result + quantity
        result = 31 * result + stainId
        result = 31 * result + (world?.hashCode() ?: 0)
        result = 31 * result + (creatorName?.hashCode() ?: 0)
        result = 31 * result + (creatorId?.hashCode() ?: 0)
        result = 31 * result + hq.hashCode()
        result = 31 * result + isCrafted.hashCode()
        result = 31 * result + (listingId?.hashCode() ?: 0)
        result = 31 * result + (materia?.contentHashCode() ?: 0)
        result = 31 * result + onMannequin.hashCode()
        result = 31 * result + retainerCity.hashCode()
        result = 31 * result + (retainerId?.hashCode() ?: 0)
        result = 31 * result + (retainerName?.hashCode() ?: 0)
        result = 31 * result + (sellerId?.hashCode() ?: 0)
        result = 31 * result + total
        return result
    }

    override fun toString() = "Listing(lastReviewTime=$lastReviewTime, pricePerUnit=$pricePerUnit, quantity=$quantity, stainId=$stainId, world=$world, creatorName=$creatorName, creatorId=$creatorId, hq=$hq, isCrafted=$isCrafted, listingId=$listingId, materia=${materia?.contentToString()}, onMannequin=$onMannequin, retainerCity=$retainerCity, retainerId=$retainerId, retainerName=$retainerName, sellerId=$sellerId, total=$total)"
}

private val idToCity = mapOf(
    1.toByte() to City.LimsaLominsa,
    2.toByte() to City.Gridania,
    3.toByte() to City.Uldah,
    4.toByte() to City.Ishgard,
    7.toByte() to City.Kugane,
    10.toByte() to City.Crystarium,
    12.toByte() to City.OldSharlayan
)
