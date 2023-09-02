import cloud.drakon.ktuniversalis.KtUniversalis;
import cloud.drakon.ktuniversalis.exception.UniversalisException;
import cloud.drakon.ktuniversalis.world.DataCenter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

final class GetRecentlyUpdatedItemsJavaTest {
    @Test
    void GetLeastRecentlyUpdatedItemsTest() {
        Assertions.assertDoesNotThrow(() -> {
            try {
                System.out.println(KtUniversalis.getLeastRecentlyUpdatedItems(DataCenter.Chaos).get());
            } catch (UniversalisException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    void GetMostRecentlyUpdatedItemsTest() {
        Assertions.assertDoesNotThrow(() -> {
            try {
                System.out.println(KtUniversalis.getMostRecentlyUpdatedItems(DataCenter.Chaos).get());
            } catch (UniversalisException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
