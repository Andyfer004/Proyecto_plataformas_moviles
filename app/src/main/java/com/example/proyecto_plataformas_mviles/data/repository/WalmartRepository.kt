package com.zezzi.eventzezziapp.data.repository

import com.zezzi.eventzezziapp.data.networking.WalmartWebService
import com.zezzi.eventzezziapp.data.networking.response.OrganicResult
import com.zezzi.eventzezziapp.data.networking.response.PrimaryOffer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WalmartRepository(private val WalmartWebService: WalmartWebService = WalmartWebService()) {

    suspend fun searchProducts(query: String, storeId: String): List<ProductInfo>? {
        return withContext(Dispatchers.IO) {
            try {
                // Llamar a la función suspendida en el webService para obtener los datos.
                val response = WalmartWebService.searchProducts(query, storeId)
                val organicResults = response.organicResults

                // Mapear la respuesta a una lista de ProductInfo
                val products = organicResults.map { result ->
                    ProductInfo(
                        title = result.title,
                        thumbnail = result.thumbnail,
                        offerPrice = result.primaryOffer.offerPrice
                    )
                }

                products

            } catch (e: Exception) {
                // Manejar errores si es necesario.
                null
            }
        }
    }
}

data class ProductInfo(
    val title: String,
    val thumbnail: String,
    val offerPrice: Double
)

