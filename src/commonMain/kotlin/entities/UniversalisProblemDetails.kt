package cloud.drakon.ktuniversalis.entities

import kotlinx.serialization.Serializable

@Serializable internal data class UniversalisProblemDetails(
    val type: String? = null,
    val title: String? = null,
    val status: Short? = null,
    val detail: String? = null,
    val instance: String? = null,
): ProblemDetails