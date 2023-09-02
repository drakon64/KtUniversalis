import cloud.drakon.ktuniversalis.KtUniversalis;
import cloud.drakon.ktuniversalis.exception.UniversalisException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class GetUploadCountsByUploadApplicationJavaTest {
    @Test
    public void GetUploadCountsByUploadApplicationTest() {
        Assertions.assertDoesNotThrow(() -> {
            try {
                System.out.println(KtUniversalis.getUploadCountsByUploadApplication().get());
            } catch (UniversalisException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
