import cloud.drakon.ktuniversalis.getMarketBoardCurrentData
import cloud.drakon.ktuniversalis.world.DataCenter
import cloud.drakon.ktuniversalis.world.Region
import cloud.drakon.ktuniversalis.world.World
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class GetMarketBoardCurrentDataTest {
    @Test
    fun getMarketBoardCurrentDataWorldTest() = assertDoesNotThrow {
        runBlocking {
            println(getMarketBoardCurrentData(38264, World.Cerberus))
        }
    }

    @Test
    fun getMarketBoardCurrentDataDataCenterTest() = assertDoesNotThrow {
        runBlocking {
            println(getMarketBoardCurrentData(38264, DataCenter.Chaos))
        }
    }

    @Test
    fun getMarketBoardCurrentDataRegionTest() = assertDoesNotThrow {
        runBlocking {
            println(getMarketBoardCurrentData(38264, Region.NorthAmerica))
        }
    }

    @Test
    fun getMarketBoardCurrentDataWorldMultiTest() = assertDoesNotThrow {
        runBlocking {
            println(
                getMarketBoardCurrentData(
                    listOf(39872, 38264),
                    World.Cerberus,
                )
            )
        }
    }

    @Test
    fun getMarketBoardCurrentDataDataCenterMultiTest() = assertDoesNotThrow {
        runBlocking {
            println(
                getMarketBoardCurrentData(
                    listOf(39872, 38264),
                    DataCenter.Chaos,
                )
            )
        }
    }

    @Test
    fun getMarketBoardCurrentDataRegionMultiTest() = assertDoesNotThrow {
        runBlocking {
            println(
                getMarketBoardCurrentData(
                    listOf(39872, 38264),
                    Region.NorthAmerica,
                )
            )
        }
    }
}
