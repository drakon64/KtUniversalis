@file:OptIn(ExperimentalJsExport::class, ExperimentalSerializationApi::class)

package cloud.drakon.ktuniversalis.world

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToDynamic

/**
 * @suppress
 */
@JsExport @JsName("idToWorld") val idToWorldDynamic: dynamic =
    Json.encodeToDynamic(idToWorld)
