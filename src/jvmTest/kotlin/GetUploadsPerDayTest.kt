import cloud.drakon.ktuniversalis.getUploadsPerDay
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class GetUploadsPerDayTest {
    @Test
    fun getUploadsPerDayTest() = assertDoesNotThrow {
        runBlocking {
            println(getUploadsPerDay())
        }
    }
}
