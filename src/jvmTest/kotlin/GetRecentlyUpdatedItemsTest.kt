import cloud.drakon.ktuniversalis.getLeastRecentlyUpdatedItems
import cloud.drakon.ktuniversalis.getMostRecentlyUpdatedItems
import cloud.drakon.ktuniversalis.world.DataCenter
import cloud.drakon.ktuniversalis.world.World
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class GetRecentlyUpdatedItemsTest {
    @Test
    fun getLeastRecentlyUpdatedItemsWorldTest() = assertDoesNotThrow {
        runBlocking {
            println(getLeastRecentlyUpdatedItems(World.Cerberus))
        }
    }

    @Test
    fun getLeastRecentlyUpdatedItemsDataCenterTest() = assertDoesNotThrow {
        runBlocking {
            println(getLeastRecentlyUpdatedItems(DataCenter.Chaos))
        }
    }

    @Test
    fun getMostRecentlyUpdatedItemsWorldTest() = assertDoesNotThrow {
        runBlocking {
            println(getMostRecentlyUpdatedItems(World.Cerberus))
        }
    }

    @Test
    fun getMostRecentlyUpdatedItemsDataCenterTest() = assertDoesNotThrow {
        runBlocking {
            println(getMostRecentlyUpdatedItems(DataCenter.Chaos))
        }
    }
}
