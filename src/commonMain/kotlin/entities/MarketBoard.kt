package cloud.drakon.ktuniversalis.entities

import kotlinx.serialization.Serializable

@Deprecated(
    "Will be removed when union types are available within Kotlin.",
    level = DeprecationLevel.WARNING
)
@Serializable
sealed interface MarketBoard
