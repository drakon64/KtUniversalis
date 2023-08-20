import cloud.drakon.ktuniversalis.getAvailableDataCenters
import cloud.drakon.ktuniversalis.getAvailableWorlds
import cloud.drakon.ktuniversalis.getLeastRecentlyUpdatedItems
import cloud.drakon.ktuniversalis.getMarketBoardCurrentData
import cloud.drakon.ktuniversalis.getMarketBoardSaleHistory
import cloud.drakon.ktuniversalis.getMarketTaxRates
import cloud.drakon.ktuniversalis.getMarketableItems
import cloud.drakon.ktuniversalis.getMostRecentlyUpdatedItems
import cloud.drakon.ktuniversalis.getUploadCountsByUploadApplication
import cloud.drakon.ktuniversalis.getUploadCountsByWorld
import cloud.drakon.ktuniversalis.getUploadsPerDay
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class KtUniversalisTest {
    @Test fun getAvailableDataCentersTest() = assertDoesNotThrow {
        runBlocking {
            println(getAvailableDataCenters())
        }
    }

    @Test fun getAvailableWorldsTest() = assertDoesNotThrow {
        runBlocking {
            println(getAvailableWorlds())
        }
    }

    @Test fun getLeastRecentlyUpdatedItemsTest() = assertDoesNotThrow {
        runBlocking {
            println(getLeastRecentlyUpdatedItems("Cerberus"))
        }
    }

    @Test fun getMarketBoardCurrentDataTest() = assertDoesNotThrow {
        runBlocking {
            println(getMarketBoardCurrentData("Europe", listOf(38264)))
        }
    }

    @Test fun getMarketBoardSaleHistoryTest() = assertDoesNotThrow {
        runBlocking {
            println(getMarketBoardSaleHistory("Europe", listOf(38264)))
        }
    }

    @Test fun getMarketTaxRatesTest() = assertDoesNotThrow {
        runBlocking { println(getMarketTaxRates("Cerberus")) }
    }

    @Test fun getMarketableItemsTest() = assertDoesNotThrow {
        runBlocking {
            println(getMarketableItems())
        }
    }

    @Test fun getMostRecentlyUpdatedItemsTest() = assertDoesNotThrow {
        runBlocking {
            println(
                getMostRecentlyUpdatedItems("Cerberus")
            )
        }
    }

    @Test fun getUploadCountsByUploadApplicationTest() = assertDoesNotThrow {
        runBlocking {
            println(getUploadCountsByUploadApplication())
        }
    }

    @Test fun getUploadCountsByWorldTest() = assertDoesNotThrow {
        runBlocking {
            println(getUploadCountsByWorld())
        }
    }

    @Test fun getUploadsPerDayTest() = assertDoesNotThrow {
        runBlocking {
            println(getUploadsPerDay())
        }
    }
}
