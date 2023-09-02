import cloud.drakon.ktuniversalis.KtUniversalis;
import cloud.drakon.ktuniversalis.exception.InvalidItemException;
import cloud.drakon.ktuniversalis.exception.UniversalisException;
import cloud.drakon.ktuniversalis.world.Region;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class GetMarketBoardCurrentDataJavaTest {
    @Test
    public void getMarketBoardCurrentDataTest() {
        Assertions.assertDoesNotThrow(() -> {
            try {
                System.out.println(KtUniversalis.getMarketBoardCurrentData(Region.Europe, 38264).get());
            } catch (UniversalisException | InvalidItemException e) {
                throw new RuntimeException(e);
            }
        });
    }
}