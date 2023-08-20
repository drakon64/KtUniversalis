@file:OptIn(DelicateCoroutinesApi::class, ExperimentalJsExport::class)

package cloud.drakon.ktuniversalis

import io.ktor.client.HttpClient
import io.ktor.client.engine.js.Js
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

internal actual val ktorClient = HttpClient(Js) {
    install(ContentNegotiation) {
        json()
    }

    install(DefaultRequest) {
        url("https://universalis.app/api/v2/")
    }
}

@JsExport fun getAvailableDataCentersAsync() = GlobalScope.promise {
    getAvailableDataCenters().toTypedArray()
}

@JsExport fun getAvailableWorldsAsync() = GlobalScope.promise {
    getAvailableWorlds().toTypedArray()
}

@JsExport fun getLeastRecentlyUpdatedItemsAsync(
    world: String? = null,
    dcName: String? = null,
    entries: Int? = null,
) = GlobalScope.promise {
    getLeastRecentlyUpdatedItems(world, dcName, entries)
}

@JsExport fun getMarketBoardCurrentDataAsync(
    worldDcRegion: String,
    itemIds: Array<Int>,
    listings: Int? = null,
    entries: Int? = null,
    noGst: Boolean? = null,
    hq: Boolean? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
    fields: Array<String>? = null,
) = GlobalScope.promise {
    getMarketBoardCurrentData(
        worldDcRegion,
        itemIds.toList(),
        listings,
        entries,
        noGst,
        hq,
        statsWithin,
        entriesWithin,
        fields?.toList()
    )
}

@JsExport fun getMarketBoardSaleHistoryAsync(
    worldDcRegion: String,
    itemIds: Array<Int>,
    entriesToReturn: Int? = null,
    statsWithin: Int? = null,
    entriesWithin: Int? = null,
) = GlobalScope.promise {
    getMarketBoardSaleHistory(
        worldDcRegion, itemIds.toList(), entriesToReturn, statsWithin, entriesWithin
    )
}

@JsExport fun getMarketTaxRatesAsync(world: String) = GlobalScope.promise {
    getMarketTaxRates(world)
}

@JsExport fun getMarketableItemsAsync() = GlobalScope.promise {
    getMarketableItems().toIntArray()
}

@JsExport fun getMostRecentlyUpdatedItemsAsync(
    world: String? = null,
    dcName: String? = null,
    entries: Int? = null,
) = GlobalScope.promise {
    getMostRecentlyUpdatedItems(world, dcName, entries)
}

@JsExport fun getUploadCountsByUploadApplicationAsync() = GlobalScope.promise {
    getUploadCountsByUploadApplication().toTypedArray()
}

@JsExport fun getUploadCountsByWorldAsync() = GlobalScope.promise {
    getUploadCountsByWorld()
}

@JsExport fun getUploadsPerDayAsync() = GlobalScope.promise {
    getUploadsPerDay()
}
