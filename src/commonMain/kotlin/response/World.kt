package cloud.drakon.ktuniversalis.response

import kotlin.js.JsExport
import kotlinx.serialization.Serializable

/**
 * ID and name of a world supported by the Universalis API
 * @property id ID of a world supported by the Universalis API
 * @property name Name of a world supported by the Universalis API
 */
@JsExport @Serializable class World(val id: Int, val name: String? = null)
