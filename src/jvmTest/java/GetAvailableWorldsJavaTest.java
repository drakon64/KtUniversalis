import cloud.drakon.ktuniversalis.KtUniversalis;
import cloud.drakon.ktuniversalis.exception.UniversalisException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

final class GetAvailableWorldsJavaTest {
    @Test
    void getAvailableWorldsTest() {
        Assertions.assertDoesNotThrow(() -> {
            try {
                System.out.println(KtUniversalis.getAvailableWorlds().get());
            } catch (UniversalisException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
