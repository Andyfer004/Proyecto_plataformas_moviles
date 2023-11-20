package com.zezzi.eventzezziapp.data.networking

import com.zezzi.eventzezziapp.data.networking.response.CoffeeResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface WalmartApi {
    @GET("search")
    suspend fun searchProducts(
        @Query("engine") engine: String = "walmart",
        @Query("query") query: String = "Coffee",
        @Query("store_id") storeId: String = "1634",
        @Query("api_key") apiKey: String = "09f276192e32500ed164f3aede7a149f5f87adc8fb08a094aad94efaaed30899" // Reemplaza con tu clave de API real
    ): CoffeeResponse
}
