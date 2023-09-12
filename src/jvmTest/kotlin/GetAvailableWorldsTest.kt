import cloud.drakon.ktuniversalis.getAvailableWorlds
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class GetAvailableWorldsTest {
    @Test
    fun getAvailableWorldsTest() = assertDoesNotThrow {
        runBlocking {
            println(getAvailableWorlds())
        }
    }
}
