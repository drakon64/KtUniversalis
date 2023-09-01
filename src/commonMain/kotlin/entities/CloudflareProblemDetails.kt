package cloud.drakon.ktuniversalis.entities

import kotlinx.serialization.Serializable

@Serializable internal data class CloudflareProblemDetails(
    val status: Short,
    val traceId: String,
)
