import cloud.drakon.ktuniversalis.KtUniversalisClient
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class KtUniversalisClientTest {
    @Test fun getMarketBoardCurrentData() {
        assertDoesNotThrow {
            runBlocking {
                KtUniversalisClient.getMarketBoardCurrentData(
                    "Europe", arrayOf(38264).toIntArray()
                )
            }
        }
    }
}
