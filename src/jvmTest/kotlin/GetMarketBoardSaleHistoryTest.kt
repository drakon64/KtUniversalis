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
            println(getMarketBoardSaleHistory(World.Cerberus, 38264))
        }
    }

    @Test
    fun getMarketBoardSaleHistoryWorldInvalidTest() {
        assertThrows<InvalidItemException> {
            runBlocking {
                println(getMarketBoardSaleHistory(World.Cerberus, -1))
            }
        }
    }

    @Test
    fun getMarketBoardSaleHistoryDataCenterTest() = assertDoesNotThrow {
        runBlocking {
            println(getMarketBoardSaleHistory(DataCenter.Chaos, 38264))
        }
    }

    @Test
    fun getMarketBoardSaleHistoryDataCenterInvalidTest() {
        assertThrows<InvalidItemException> {
            runBlocking {
                println(getMarketBoardSaleHistory(DataCenter.Chaos, -1))
            }
        }
    }

    @Test
    fun getMarketBoardSaleHistoryRegionTest() = assertDoesNotThrow {
        runBlocking {
            println(getMarketBoardSaleHistory(Region.NorthAmerica, 38264))
        }
    }

    @Test
    fun getMarketBoardSaleHistoryRegionInvalidTest() {
        assertThrows<InvalidItemException> {
            runBlocking {
                println(getMarketBoardSaleHistory(Region.NorthAmerica, -1))
            }
        }
    }

    @Test
    fun getMarketBoardSaleHistoryWorldMultiTest() = assertDoesNotThrow {
        runBlocking {
            println(getMarketBoardSaleHistory(World.Cerberus, listOf(39872, 38264)))
        }
    }

    @Test
    fun getMarketBoardSaleHistoryDataCenterMultiTest() = assertDoesNotThrow {
        runBlocking {
            println(
                getMarketBoardSaleHistory(
                    DataCenter.Chaos,
                    listOf(39872, 38264)
                )
            )
        }
    }

    @Test
    fun getMarketBoardSaleHistoryRegionMultiTest() = assertDoesNotThrow {
        runBlocking {
            println(
                getMarketBoardSaleHistory(
                    Region.NorthAmerica,
                    listOf(39872, 38264)
                )
            )
        }
    }
}
