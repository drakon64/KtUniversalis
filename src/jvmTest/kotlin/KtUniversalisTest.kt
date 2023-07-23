import cloud.drakon.ktuniversalis.KtUniversalis
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class KtUniversalisTest {
    @Test fun getAvailableDataCenters() {
        assertDoesNotThrow { runBlocking { println(KtUniversalis.getAvailableDataCenters()) } }
    }

    @Test fun getAvailableWorlds() {
        assertDoesNotThrow { runBlocking { println(KtUniversalis.getAvailableWorlds()) } }
    }

    @Test fun getLeastRecentlyUpdatedItems() {
        assertDoesNotThrow {
            runBlocking {
                println(
                    KtUniversalis.getLeastRecentlyUpdatedItems(
                        "Cerberus"
                    )
                )
            }
        }
    }

    @Test fun getMarketBoardCurrentData() {
        assertDoesNotThrow {
            runBlocking {
                println(
                    KtUniversalis.getMarketBoardCurrentData(
                        "Europe", listOf(38264)
                    )
                )
            }
        }
    }

    @Test fun getMarketBoardSaleHistory() {
        assertDoesNotThrow {
            runBlocking {
                println(
                    KtUniversalis.getMarketBoardSaleHistory(
                        "Europe", listOf(38264)
                    )
                )
            }
        }
    }

    @Test fun getMarketTaxRates() {
        assertDoesNotThrow { runBlocking { println(KtUniversalis.getMarketTaxRates("Cerberus")) } }
    }

    @Test fun getMarketableItems() {
        assertDoesNotThrow { runBlocking { println(KtUniversalis.getMarketableItems()) } }
    }

    @Test fun getMostRecentlyUpdatedItems() {
        assertDoesNotThrow {
            runBlocking {
                println(
                    KtUniversalis.getMostRecentlyUpdatedItems(
                        "Cerberus"
                    )
                )
            }
        }
    }

    @Test fun getUploadCountsByUploadApplication() {
        assertDoesNotThrow { runBlocking { println(KtUniversalis.getUploadCountsByUploadApplication()) } }
    }

    @Test fun getUploadCountsByWorld() {
        assertDoesNotThrow { runBlocking { println(KtUniversalis.getUploadCountsByWorld()) } }
    }

    @Test fun getUploadsPerDay() {
        assertDoesNotThrow { runBlocking { println(KtUniversalis.getUploadsPerDay()) } }
    }
}
