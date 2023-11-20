package com.zezzi.eventzezziapp.data.networking

import com.zezzi.eventzezziapp.data.networking.response.CoffeeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WalmartApi {
    @GET("search")
    suspend fun searchProducts(
        @Query("engine") engine: String = "walmart",
        @Query("query") query: String,
        @Query("store_id") storeId: String
    ): CoffeeResponse
}
