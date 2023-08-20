package cloud.drakon.ktuniversalis.entities

import kotlinx.serialization.Serializable

@Serializable internal data class ProblemDetails(
    val type: String? = null,
    val title: String? = null,
    val status: Int? = null,
    val detail: String? = null,
    val instance: String? = null,
)
