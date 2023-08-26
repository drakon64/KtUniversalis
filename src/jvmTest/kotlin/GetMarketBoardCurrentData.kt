import cloud.drakon.ktuniversalis.getMarketBoardCurrentData
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class GetMarketBoardCurrentData {
    @Test fun getMarketBoardCurrentDataTest() = assertDoesNotThrow {
        runBlocking {
            println(getMarketBoardCurrentData("Europe", 38264))
        }
    }

    @Test fun getMarketBoardCurrentDataFieldsTest() = assertDoesNotThrow {
        runBlocking {
            println(
                getMarketBoardCurrentData(
                    "Europe", 38264, fields = setOf(
                        "listing.pricePerUnit",
                        "listing.quantity",
                        "listing.worldName",
                        "currentAveragePrice",
                        "currentAveragePriceNQ",
                        "currentAveragePriceHQ"
                    )
                )
            )
        }
    }
}
