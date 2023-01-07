package cloud.drakon.ktuniversalis.response

import kotlin.js.JsExport
import kotlinx.serialization.Serializable

/**
 * ID and name of a world supported by the Universalis API
 */
@JsExport @Serializable class AvailableWorld(val id: Short, val name: String)
