import cloud.drakon.ktuniversalis.KtUniversalis;
import cloud.drakon.ktuniversalis.exception.InvalidItemException;
import cloud.drakon.ktuniversalis.exception.UniversalisException;
import cloud.drakon.ktuniversalis.world.Region;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

final class GetMarketBoardCurrentDataJavaTest {
    @Test
    void getMarketBoardCurrentDataTest() {
        Assertions.assertDoesNotThrow(() -> {
            try {
                System.out.println(KtUniversalis.getMarketBoardCurrentData(Region.Europe, 38264).get());
            } catch (UniversalisException | InvalidItemException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    void getMarketBoardCurrentDataWorldNamesTest() {
        Assertions.assertDoesNotThrow(() -> {
            try {
                System.out.println(KtUniversalis.getMarketBoardCurrentData(Region.Europe, 38264).get().getWorldNameUploadTimes());
            } catch (UniversalisException | InvalidItemException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
