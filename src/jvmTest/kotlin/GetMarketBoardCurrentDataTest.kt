import cloud.drakon.ktuniversalis.getMarketBoardCurrentData
import cloud.drakon.ktuniversalis.world.Region
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class GetMarketBoardCurrentDataTest {
    @Test fun getMarketBoardCurrentDataTest() = assertDoesNotThrow {
        runBlocking {
            println(getMarketBoardCurrentData(Region.Europe, 38264))
        }
    }

    @Test fun getMarketBoardCurrentDataWorldNamesTest() = assertDoesNotThrow {
        runBlocking {
            println(
                getMarketBoardCurrentData(Region.Europe, 38264).worldNameUploadTimes,
            )
        }
    }

    @Test fun getMarketBoardCurrentDataMultiTest() = assertDoesNotThrow {
        runBlocking {
            println(getMarketBoardCurrentData(Region.Europe, listOf(39872, 38264)))
        }
    }
}
