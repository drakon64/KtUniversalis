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
            println(getMarketBoardCurrentData(World.Cerberus, 38264))
        }
    }

    @Test
    fun getMarketBoardCurrentDataDataCenterTest() = assertDoesNotThrow {
        runBlocking {
            println(getMarketBoardCurrentData(DataCenter.Chaos, 38264))
        }
    }

    @Test
    fun getMarketBoardCurrentDataRegionTest() = assertDoesNotThrow {
        runBlocking {
            println(getMarketBoardCurrentData(Region.NorthAmerica, 38264))
        }
    }

    @Test
    fun getMarketBoardCurrentDataWorldMultiTest() = assertDoesNotThrow {
        runBlocking {
            println(
                getMarketBoardCurrentData(
                    World.Cerberus,
                    listOf(39872, 38264)
                )
            )
        }
    }

    @Test
    fun getMarketBoardCurrentDataDataCenterMultiTest() = assertDoesNotThrow {
        runBlocking {
            println(
                getMarketBoardCurrentData(
                    DataCenter.Chaos,
                    listOf(39872, 38264)
                )
            )
        }
    }

    @Test
    fun getMarketBoardCurrentDataRegionMultiTest() = assertDoesNotThrow {
        runBlocking {
            println(
                getMarketBoardCurrentData(
                    Region.NorthAmerica,
                    listOf(39872, 38264)
                )
            )
        }
    }
}
