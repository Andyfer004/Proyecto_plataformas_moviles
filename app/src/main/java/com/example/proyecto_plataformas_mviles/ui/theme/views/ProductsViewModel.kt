package com.zezzi.eventzezziapp.ui.products

import androidx.lifecycle.ViewModel
import com.zezzi.eventzezziapp.data.repository.ProductInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import android.util.Log
import com.zezzi.eventzezziapp.data.repository.WalmartRepository

class ProductsViewModel(private val repository: WalmartRepository = WalmartRepository()) : ViewModel() {

    suspend fun searchProducts(query: String, storeId: String): List<ProductInfo>? {
        return withContext(Dispatchers.IO) {
            try {
                // Llamar a la función suspendida en el repositorio para obtener los datos.
                val response = repository.searchProducts(query, storeId)
                // Agregar registro de depuración para verificar la respuesta
                Log.d("ProductsViewModel", "Response: $response")
                response
            } catch (e: Exception) {
                // Manejar errores si es necesario.
                null
            }
        }
    }
}
