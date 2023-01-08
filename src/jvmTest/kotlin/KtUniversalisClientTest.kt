import cloud.drakon.ktuniversalis.KtUniversalisClient
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class KtUniversalisClientTest {
    @Test fun getAvailableDataCenters() {
        assertDoesNotThrow { runBlocking { KtUniversalisClient.getAvailableDataCenters() } }
    }

    @Test fun getAvailableWorlds() {
        assertDoesNotThrow { runBlocking { KtUniversalisClient.getAvailableWorlds() } }
    }

    @Test fun getLeastRecentlyUpdatedItems() {
        assertDoesNotThrow {
            runBlocking {
                KtUniversalisClient.getLeastRecentlyUpdatedItems(
                    "Cerberus"
                )
            }
        }
    }

    @Test fun getMarketBoardCurrentData() {
        assertDoesNotThrow {
            runBlocking {
                KtUniversalisClient.getMarketBoardCurrentData(
                    "Europe", arrayOf(38264).toIntArray()
                )
            }
        }
    }

    @Test fun getMarketBoardSaleHistory() {
        assertDoesNotThrow {
            runBlocking {
                KtUniversalisClient.getMarketBoardSaleHistory(
                    "Europe", arrayOf(38264).toIntArray()
                )
            }
        }
    }

    @Test fun getMarketTaxRates() {
        assertDoesNotThrow { runBlocking { KtUniversalisClient.getMarketTaxRates("Cerberus") } }
    }

    @Test fun getMarketableItems() {
        assertDoesNotThrow { runBlocking { KtUniversalisClient.getMarketableItems() } }
    }

    @Test fun getMostRecentlyUpdatedItems() {
        assertDoesNotThrow {
            runBlocking {
                KtUniversalisClient.getMostRecentlyUpdatedItems(
                    "Cerberus"
                )
            }
        }
    }

    @Test fun getUploadCountsByUploadApplication() {
        assertDoesNotThrow { runBlocking { KtUniversalisClient.getUploadCountsByUploadApplication() } }
    }

    @Test fun getUploadCountsByWorld() {
        assertDoesNotThrow { runBlocking { KtUniversalisClient.getUploadCountsByWorld() } }
    }

    @Test fun getUploadsPerDay() {
        assertDoesNotThrow { runBlocking { KtUniversalisClient.getUploadsPerDay() } }
    }
}
