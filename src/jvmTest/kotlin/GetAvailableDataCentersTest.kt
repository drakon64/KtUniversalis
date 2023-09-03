import cloud.drakon.ktuniversalis.getAvailableDataCenters
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class GetAvailableDataCentersTest {
    @Test fun getAvailableDataCentersTest() = assertDoesNotThrow {
        runBlocking {
            println(getAvailableDataCenters())
        }
    }

    @Test fun getAvailableDataCentersWorldNamesTest() = assertDoesNotThrow {
        runBlocking {
            println(getAvailableDataCenters()[0].worldNames)
        }
    }
}
