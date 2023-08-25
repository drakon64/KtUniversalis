import cloud.drakon.ktuniversalis.KtUniversalis;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class KtUniversalisAsyncTest {
    @Test
    void getAvailableDataCentersTest() {
        assertDoesNotThrow(() -> System.out.println(
                KtUniversalis.getAvailableDataCentersAsync().get())
        );
    }

    @Test
    void getAvailableWorldsTest() {
        assertDoesNotThrow(() -> System.out.println(
                KtUniversalis.getAvailableWorldsAsync().get())
        );
    }

    @Test
    void getLeastRecentlyUpdatedItemsTest() {
        assertDoesNotThrow(() -> System.out.println(
                KtUniversalis.getLeastRecentlyUpdatedItemsAsync("Cerberus").get())
        );
    }

    @Test
    void getMarketBoardCurrentDataTest() {
        assertDoesNotThrow(() -> System.out.println(
                KtUniversalis.getMarketBoardCurrentDataAsync("Europe", 38264).get())
        );
    }

    @Test
    void getMarketBoardSaleHistoryTest() {
        assertDoesNotThrow(() -> System.out.println(
                KtUniversalis.getMarketBoardSaleHistoryAsync("Europe", 38264).get())
        );
    }

    @Test
    void getMarketTaxRatesTest() {
        assertDoesNotThrow(() -> System.out.println(
                KtUniversalis.getMarketTaxRatesAsync("Cerberus").get())
        );
    }

    @Test
    void getMarketableItemsTest() {
        assertDoesNotThrow(() -> System.out.println(
                KtUniversalis.getMarketableItemsAsync().get())
        );
    }

    @Test
    void getMostRecentlyUpdatedItemsTest() {
        assertDoesNotThrow(() -> System.out.println(
                KtUniversalis.getMostRecentlyUpdatedItemsAsync("Cerberus").get())
        );
    }

    @Test
    void getUploadCountsByUploadApplicationTest() {
        assertDoesNotThrow(() -> System.out.println(
                KtUniversalis.getUploadCountsByUploadApplicationAsync().get())
        );
    }

    @Test
    void getUploadCountsByWorldTest() {
        assertDoesNotThrow(() -> System.out.println(
                KtUniversalis.getUploadCountsByWorldAsync().get())
        );
    }

    @Test
    void getUploadsPerDayTest() {
        assertDoesNotThrow(() -> System.out.println(
                KtUniversalis.getUploadsPerDayAsync().get())
        );
    }
}
