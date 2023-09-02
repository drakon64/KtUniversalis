import cloud.drakon.ktuniversalis.KtUniversalis;
import cloud.drakon.ktuniversalis.exception.UniversalisException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class GetAvailableDataCentersJavaTest {
    @Test
    public void getAvailableDataCentersTest() {
        Assertions.assertDoesNotThrow(() -> {
            try {
                System.out.println(KtUniversalis.getAvailableDataCenters().get());
            } catch (UniversalisException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
