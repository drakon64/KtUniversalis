import cloud.drakon.ktuniversalis.getMarketTaxRates
import cloud.drakon.ktuniversalis.world.World
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class GetMarketTaxRatesTest {
    @Test fun getMarketTaxRatesTest() = assertDoesNotThrow {
        runBlocking { println(getMarketTaxRates(World.Cerberus)) }
    }
}
