import cloud.drakon.ktuniversalis.getUploadCountsByWorld
import kotlin.test.Test
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertDoesNotThrow

class GetUploadCountsByWorldTest {
    @Test fun getUploadCountsByWorldTest() = assertDoesNotThrow {
        runBlocking {
            println(getUploadCountsByWorld())
        }
    }
}
