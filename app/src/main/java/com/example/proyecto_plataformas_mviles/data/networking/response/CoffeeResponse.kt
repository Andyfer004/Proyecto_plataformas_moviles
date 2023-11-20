package com.zezzi.eventzezziapp.data.networking.response

import com.google.gson.annotations.SerializedName

    data class CoffeeResponse(
    @SerializedName("search_metadata") val searchMetadata: SearchMetadata,
    @SerializedName("search_parameters") val searchParameters: SearchParameters,
    @SerializedName("search_information") val searchInformation: SearchInformation,
    @SerializedName("organic_results") val organicResults: List<OrganicResult>
)

data class SearchMetadata(
    @SerializedName("id") val id: String,
    @SerializedName("status") val status: String,
    @SerializedName("json_endpoint") val jsonEndpoint: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("processed_at") val processedAt: String,
    @SerializedName("walmart_url") val walmartUrl: String,
    @SerializedName("raw_html_file") val rawHtmlFile: String,
    @SerializedName("total_time_taken") val totalTimeTaken: Double
)

data class SearchParameters(
    @SerializedName("engine") val engine: String,
    @SerializedName("device") val device: String,
    @SerializedName("query") val query: String,
    @SerializedName("store_id") val storeId: String
)

data class SearchInformation(
    @SerializedName("location") val location: Location,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("query_displayed") val queryDisplayed: String,
    @SerializedName("organic_results_state") val organicResultsState: String
)

data class Location(
    @SerializedName("postal_code") val postalCode: String,
    @SerializedName("province_code") val provinceCode: String,
    @SerializedName("city") val city: String,
    @SerializedName("store_id") val storeId: String
)

data class OrganicResult(
    @SerializedName("us_item_id") val usItemId: String,
    @SerializedName("product_id") val productId: String,
    @SerializedName("title") val title: String,
    @SerializedName("thumbnail") val thumbnail: String,
    @SerializedName("primary_offer") val primaryOffer: PrimaryOffer
)

data class PrimaryOffer(
    @SerializedName("offer_id") val offerId: String,
    @SerializedName("offer_price") val offerPrice: Double
)
