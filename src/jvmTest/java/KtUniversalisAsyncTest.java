import org.junit.jupiter.api.Test;

import static cloud.drakon.ktuniversalis.KtUniversalis.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class KtUniversalisAsyncTest {
    @Test
    void getAvailableDataCentersTest() {
        assertDoesNotThrow(() -> System.out.println(getAvailableDataCentersAsync().get()));
    }

    @Test
    void getAvailableWorldsTest() {
        assertDoesNotThrow(() -> System.out.println(getAvailableWorldsAsync().get()));
    }

    @Test
    void getLeastRecentlyUpdatedItemsTest() {
        assertDoesNotThrow(() -> System.out.println(getLeastRecentlyUpdatedItemsAsync("Cerberus").get()));
    }

    @Test
    void getMarketBoardCurrentDataTest() {
        assertDoesNotThrow(() -> System.out.println(getMarketBoardCurrentDataAsync("Europe", 38264).get()));
    }

    @Test
    void getMarketBoardSaleHistoryTest() {
        assertDoesNotThrow(() -> System.out.println(getMarketBoardSaleHistoryAsync("Europe", 38264).get()));
    }

    @Test
    void getMarketTaxRatesTest() {
        assertDoesNotThrow(() -> System.out.println(getMarketTaxRatesAsync("Cerberus").get()));
    }

    @Test
    void getMarketableItemsTest() {
        assertDoesNotThrow(() -> System.out.println(getMarketableItemsAsync().get()));
    }

    @Test
    void getMostRecentlyUpdatedItemsTest() {
        assertDoesNotThrow(() -> System.out.println(getMostRecentlyUpdatedItemsAsync("Cerberus").get()));
    }

    @Test
    void getUploadCountsByUploadApplicationTest() {
        assertDoesNotThrow(() -> System.out.println(getUploadCountsByUploadApplicationAsync().get()));
    }

    @Test
    void getUploadCountsByWorldTest() {
        assertDoesNotThrow(() -> System.out.println(getUploadCountsByWorldAsync().get()));
    }

    @Test
    void getUploadsPerDayTest() {
        assertDoesNotThrow(() -> System.out.println(getUploadsPerDayAsync().get()));
    }
}
