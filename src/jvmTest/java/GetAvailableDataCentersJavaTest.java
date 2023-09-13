import cloud.drakon.ktuniversalis.KtUniversalis;
import cloud.drakon.ktuniversalis.exception.UniversalisException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

final class GetAvailableDataCentersJavaTest {
    @Test
    void getAvailableDataCentersTest() {
        Assertions.assertDoesNotThrow(() -> {
            try {
                System.out.println(KtUniversalis.getAvailableDataCenters().get());
            } catch (UniversalisException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    void getAvailableDataCentersWorldNamesTest() {
        Assertions.assertDoesNotThrow(() -> {
            try {
                System.out.println(KtUniversalis.getAvailableDataCenters().get().get(0).getWorlds());
            } catch (UniversalisException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
