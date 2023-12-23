@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis.world

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport @Serializable
enum class Region(val dataCenters: List<DataCenter>) {
    Japan(
        listOf(
            DataCenter.Elemental,
            DataCenter.Gaia,
            DataCenter.Mana,
            DataCenter.Meteor
        )
    ),

    @SerialName("North-America") NorthAmerica(
        listOf(
            DataCenter.Aether,
            DataCenter.Primal,
            DataCenter.Crystal,
            DataCenter.Dynamis,
            DataCenter.NACloudDCBeta
        )
    ) {
        override fun toString() = "North-America"
    },

    Europe(listOf(DataCenter.Chaos, DataCenter.Light)),
    Oceania(listOf(DataCenter.Materia)),
    中国(
        listOf(
            DataCenter.陆行鸟,
            DataCenter.莫古力,
            DataCenter.猫小胖,
            DataCenter.豆豆柴
        )
    ),
    한국(listOf(DataCenter.한국)),
}
