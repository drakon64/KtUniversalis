import cloud.drakon.ktuniversalis.exception.InvalidItemException
import cloud.drakon.ktuniversalis.getMarketBoardSaleHistory
import cloud.drakon.ktuniversalis.world.DataCenter
import cloud.drakon.ktuniversalis.world.Region
import cloud.drakon.ktuniversalis.world.World
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class GetMarketBoardSaleHistoryTest {
    @Test
    fun getMarketBoardSaleHistoryWorldTest() = assertDoesNotThrow {
        runBlocking {
            println(getMarketBoardSaleHistory(38264, World.Cerberus))
        }
    }

    @Test
    fun getMarketBoardSaleHistoryWorldInvalidTest() {
        assertThrows<InvalidItemException> {
            runBlocking {
                println(getMarketBoardSaleHistory(-1, World.Cerberus))
            }
        }
    }

    @Test
    fun getMarketBoardSaleHistoryDataCenterTest() = assertDoesNotThrow {
        runBlocking {
            println(getMarketBoardSaleHistory(38264, DataCenter.Chaos))
        }
    }

    @Test
    fun getMarketBoardSaleHistoryDataCenterInvalidTest() {
        assertThrows<InvalidItemException> {
            runBlocking {
                println(getMarketBoardSaleHistory(-1, DataCenter.Chaos))
            }
        }
    }

    @Test
    fun getMarketBoardSaleHistoryRegionTest() = assertDoesNotThrow {
        runBlocking {
            println(getMarketBoardSaleHistory(38264, Region.NorthAmerica))
        }
    }

    @Test
    fun getMarketBoardSaleHistoryRegionInvalidTest() {
        assertThrows<InvalidItemException> {
            runBlocking {
                println(getMarketBoardSaleHistory(-1, Region.NorthAmerica))
            }
        }
    }

    @Test
    fun getMarketBoardSaleHistoryWorldMultiTest() = assertDoesNotThrow {
        runBlocking {
            println(getMarketBoardSaleHistory(listOf(39872, 38264), World.Cerberus))
        }
    }

    @Test
    fun getMarketBoardSaleHistoryDataCenterMultiTest() = assertDoesNotThrow {
        runBlocking {
            println(
                getMarketBoardSaleHistory(
                    listOf(39872, 38264),
                    DataCenter.Chaos,
                )
            )
        }
    }

    @Test
    fun getMarketBoardSaleHistoryRegionMultiTest() = assertDoesNotThrow {
        runBlocking {
            println(
                getMarketBoardSaleHistory(
                    listOf(39872, 38264),
                    Region.NorthAmerica,
                )
            )
        }
    }
}
