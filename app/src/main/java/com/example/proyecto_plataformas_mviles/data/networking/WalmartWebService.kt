package com.zezzi.eventzezziapp.data.networking

import com.zezzi.eventzezziapp.data.networking.response.CoffeeResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WalmartWebService {

    private val api: WalmartApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://serpapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(WalmartApi::class.java)
    }

    suspend fun searchProducts(query: String, storeId: String): CoffeeResponse {
        return api.searchProducts(query = query, storeId = storeId)
    }
}
