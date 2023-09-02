import cloud.drakon.ktuniversalis.KtUniversalis;
import cloud.drakon.ktuniversalis.exception.UniversalisException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class GetUploadsPerDayJavaTest {
    @Test
    public void GetUploadsPerDayTest() {
        Assertions.assertDoesNotThrow(() -> {
            try {
                System.out.println(KtUniversalis.getUploadsPerDay().get());
            } catch (UniversalisException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
