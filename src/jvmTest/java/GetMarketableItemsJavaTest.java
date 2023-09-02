import cloud.drakon.ktuniversalis.KtUniversalis;
import cloud.drakon.ktuniversalis.exception.UniversalisException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

final class GetMarketableItemsJavaTest {
    @Test
    void getMarketableItemsTest() {
        Assertions.assertDoesNotThrow(() -> {
            try {
                System.out.println(KtUniversalis.getMarketableItems().get());
            } catch (UniversalisException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
