import cloud.drakon.ktuniversalis.KtUniversalis;
import cloud.drakon.ktuniversalis.exception.UniversalisException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class GetAvailableWorldsJavaTest {
    @Test
    public void getAvailableWorldsTest() {
        Assertions.assertDoesNotThrow(() -> {
            try {
                System.out.println(KtUniversalis.getAvailableWorlds().get());
            } catch (UniversalisException e) {
                throw new RuntimeException(e);
            }
        });
    }
}