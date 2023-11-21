package com.example.proyecto_plataformas_mviles.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyecto_plataformas_mviles.ui.theme.views.Greeting
import com.example.proyecto_plataformas_mviles.ui.theme.views.Greeting2
import com.example.proyecto_plataformas_mviles.ui.theme.views.Greeting4
import com.example.proyecto_plataformas_mviles.ui.theme.views.Greeting5
import com.example.proyecto_plataformas_mviles.ui.theme.views.Greeting6
import com.example.proyecto_plataformas_mviles.ui.theme.views.Greeting7

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationState.products.route,
        modifier = modifier
    ) {
        composable("products") {
            Greeting(navController = navController) // Pass the NavController to Greeting
        }
        composable("MainActivity") {
            Greeting(navController = navController) // Pass the NavController to Greeting
        }

        composable("Supermarket") {
            Greeting2(navController = navController) // Navigate to the Supermarket
        }
        composable("New_Account") {
            Greeting4(navController = navController) // Navigate to the Supermarket
        }
        composable("SearchList") {
            Greeting5(navController = navController)
        }
        composable("SearchProduct") {
            Greeting6(navController = navController)
        }
        composable(route = "SelectedProduct/{title}/{price}/{image}") { backStackEntry ->
            val title: String? = backStackEntry.arguments?.getString("title")
            val price: String? = backStackEntry.arguments?.getString("price")
            val image: String? = backStackEntry.arguments?.getString("image")
            if (title != null && price != null && image != null) {
                Greeting7(navController = navController, title = title, price = price, image = image)
            }
        }


    }
}