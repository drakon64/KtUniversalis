import cloud.drakon.ktuniversalis.getLeastRecentlyUpdatedItems
import cloud.drakon.ktuniversalis.getMostRecentlyUpdatedItems
import cloud.drakon.ktuniversalis.world.World
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class GetRecentlyUpdatedItemsTest {
    @Test fun getLeastRecentlyUpdatedItemsTest() = assertDoesNotThrow {
        runBlocking {
            println(getLeastRecentlyUpdatedItems(World.Cerberus))
        }
    }

    @Test fun getMostRecentlyUpdatedItemsTest() = assertDoesNotThrow {
        runBlocking {
            println(
                getMostRecentlyUpdatedItems(World.Cerberus)
            )
        }
    }
}
