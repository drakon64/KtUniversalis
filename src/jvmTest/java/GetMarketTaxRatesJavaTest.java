import cloud.drakon.ktuniversalis.KtUniversalis;
import cloud.drakon.ktuniversalis.exception.UniversalisException;
import cloud.drakon.ktuniversalis.world.World;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class GetMarketTaxRatesJavaTest {
    @Test
    public void GetMarketTaxRatesTest() {
        Assertions.assertDoesNotThrow(() -> {
            try {
                System.out.println(KtUniversalis.getMarketTaxRates(World.Cerberus).get());
            } catch (UniversalisException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
