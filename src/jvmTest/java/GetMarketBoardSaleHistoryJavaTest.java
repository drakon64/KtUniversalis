import cloud.drakon.ktuniversalis.KtUniversalis;
import cloud.drakon.ktuniversalis.exception.InvalidItemException;
import cloud.drakon.ktuniversalis.exception.UniversalisException;
import cloud.drakon.ktuniversalis.world.Region;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

final class GetMarketBoardSaleHistoryJavaTest {
    @Test
    void GetMarketBoardSaleHistoryTest() {
        Assertions.assertDoesNotThrow(() -> {
            try {
                System.out.println(KtUniversalis.getMarketBoardSaleHistory(Region.Europe, 38264).get());
            } catch (UniversalisException | InvalidItemException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
