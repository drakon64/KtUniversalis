import cloud.drakon.ktuniversalis.KtUniversalis
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class KtUniversalisTest {
    @Test fun getAvailableDataCenters() {
        assertDoesNotThrow { runBlocking { KtUniversalis.getAvailableDataCenters() } }
    }

    @Test fun getAvailableWorlds() {
        assertDoesNotThrow { runBlocking { KtUniversalis.getAvailableWorlds() } }
    }

    @Test fun getLeastRecentlyUpdatedItems() {
        assertDoesNotThrow {
            runBlocking {
                KtUniversalis.getLeastRecentlyUpdatedItems(
                    "Cerberus"
                )
            }
        }
    }

    @Test fun getMarketBoardCurrentData() {
        assertDoesNotThrow {
            runBlocking {
                KtUniversalis.getMarketBoardCurrentData(
                    "Europe", arrayOf(38264).toIntArray()
                )
            }
        }
    }

    @Test fun getMarketBoardSaleHistory() {
        assertDoesNotThrow {
            runBlocking {
                KtUniversalis.getMarketBoardSaleHistory(
                    "Europe", arrayOf(38264).toIntArray()
                )
            }
        }
    }

    @Test fun getMarketTaxRates() {
        assertDoesNotThrow { runBlocking { KtUniversalis.getMarketTaxRates("Cerberus") } }
    }

    @Test fun getMarketableItems() {
        assertDoesNotThrow { runBlocking { KtUniversalis.getMarketableItems() } }
    }

    @Test fun getMostRecentlyUpdatedItems() {
        assertDoesNotThrow {
            runBlocking {
                KtUniversalis.getMostRecentlyUpdatedItems(
                    "Cerberus"
                )
            }
        }
    }

    @Test fun getUploadCountsByUploadApplication() {
        assertDoesNotThrow { runBlocking { KtUniversalis.getUploadCountsByUploadApplication() } }
    }

    @Test fun getUploadCountsByWorld() {
        assertDoesNotThrow { runBlocking { KtUniversalis.getUploadCountsByWorld() } }
    }

    @Test fun getUploadsPerDay() {
        assertDoesNotThrow { runBlocking { KtUniversalis.getUploadsPerDay() } }
    }
}
