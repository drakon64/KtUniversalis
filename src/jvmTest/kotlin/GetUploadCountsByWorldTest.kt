import cloud.drakon.ktuniversalis.getUploadCountsByWorld
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import kotlin.test.Test

class GetUploadCountsByWorldTest {
    @Test
    fun getUploadCountsByWorldTest() = assertDoesNotThrow {
        runBlocking {
            println(getUploadCountsByWorld())
        }
    }
}
