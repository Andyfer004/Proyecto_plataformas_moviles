package com.zezzi.eventzezziapp.data.networking

import com.zezzi.eventzezziapp.data.networking.response.CoffeeResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WalmartWebService {

    private val api: WalmartApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://serpapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(WalmartApi::class.java)
    }

    suspend fun searchProducts(): CoffeeResponse {
        return api.searchProducts()
    }
}
