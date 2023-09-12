import cloud.drakon.ktuniversalis.getUploadCountsByUploadApplication
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class GetUploadCountsByUploadApplicationTest {
    @Test
    fun getUploadCountsByUploadApplicationTest() = assertDoesNotThrow {
        runBlocking {
            println(getUploadCountsByUploadApplication())
        }
    }
}
