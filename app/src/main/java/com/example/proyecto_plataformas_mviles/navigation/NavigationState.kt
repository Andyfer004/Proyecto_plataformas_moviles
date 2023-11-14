package com.example.proyecto_plataformas_mviles.navigation

sealed class NavigationState(val route: String) {
    object products: NavigationState("products")
}