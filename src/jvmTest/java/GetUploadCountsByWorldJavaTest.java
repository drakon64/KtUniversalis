import cloud.drakon.ktuniversalis.KtUniversalis;
import cloud.drakon.ktuniversalis.exception.UniversalisException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class GetUploadCountsByWorldJavaTest {
    @Test
    public void GetUploadCountsByWorldTest() {
        Assertions.assertDoesNotThrow(() -> {
            try {
                System.out.println(KtUniversalis.getUploadCountsByWorld().get());
            } catch (UniversalisException e) {
                throw new RuntimeException(e);
            }
        });
    }
}