import cloud.drakon.ktuniversalis.KtUniversalis;
import cloud.drakon.ktuniversalis.exception.UniversalisException;
import cloud.drakon.ktuniversalis.world.DataCenter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class GetRecentlyUpdatedItemsJavaTest {
    @Test
    public void GetLeastRecentlyUpdatedItemsTest() {
        Assertions.assertDoesNotThrow(() -> {
            try {
                System.out.println(KtUniversalis.getLeastRecentlyUpdatedItems(DataCenter.Chaos).get());
            } catch (UniversalisException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    public void GetMostRecentlyUpdatedItemsTest() {
        Assertions.assertDoesNotThrow(() -> {
            try {
                System.out.println(KtUniversalis.getMostRecentlyUpdatedItems(DataCenter.Chaos).get());
            } catch (UniversalisException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
