import cloud.drakon.ktuniversalis.getMarketBoardSaleHistory
import cloud.drakon.ktuniversalis.world.Region
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class GetMarketBoardSaleHistoryTest {
    @Test
    fun getMarketBoardSaleHistoryTest() = assertDoesNotThrow {
        runBlocking {
            println(getMarketBoardSaleHistory(Region.Europe, 38264))
        }
    }

    @Test
    fun getMarketBoardSaleHistoryNorthAmericaTest() = assertDoesNotThrow {
        runBlocking {
            println(getMarketBoardSaleHistory(Region.NorthAmerica, 38264))
        }
    }

    @Test
    fun getMarketBoardSaleHistoryMultiTest() = assertDoesNotThrow {
        runBlocking {
            println(getMarketBoardSaleHistory(Region.Europe, intArrayOf(39872, 38264)))
        }
    }
}
