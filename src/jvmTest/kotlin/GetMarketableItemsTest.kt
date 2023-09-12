import cloud.drakon.ktuniversalis.getMarketableItems
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class GetMarketableItemsTest {
    @Test
    fun getMarketableItemsTest() = assertDoesNotThrow {
        runBlocking {
            println(getMarketableItems())
        }
    }
}
