package com.example.proyecto_plataformas_mviles.ui.theme.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.proyecto_plataformas_mviles.R
import com.example.proyecto_plataformas_mviles.ui.theme.Proyecto_Plataformas_móvilesTheme
import com.example.proyecto_plataformas_mviles.ui.theme.colorb
import com.example.proyecto_plataformas_mviles.ui.theme.transparent
import com.zezzi.eventzezziapp.data.repository.ProductInfo
import com.zezzi.eventzezziapp.ui.products.ProductsViewModel

class SearchProduct : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proyecto_Plataformas_móvilesTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = colorb) {
                    Greeting6(navController = rememberNavController())
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting6(navController: NavController, modifier: Modifier = Modifier) {
    var elementoBuscado by remember { mutableStateOf("") }

    val rememberedProducts: MutableState<List<ProductInfo>> =
        remember { mutableStateOf(emptyList<ProductInfo>()) }
    val isLoading: MutableState<Boolean> = remember { mutableStateOf(true) }
    val productsViewModel: ProductsViewModel =
        viewModel() // Debes crear un ViewModel adecuado para gestionar los platos de esta categoría

    LaunchedEffect(Unit) {
        try {
            val response = productsViewModel.searchProducts()
            rememberedProducts.value = response.orEmpty()
            isLoading.value = false
        } catch (e: Exception) {
            isLoading.value = false
            // Manejar errores si es necesario.
        }
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = modifier
                .padding(5.dp)
        ) {
            Surface(
                modifier = modifier
                    .width(235.dp)
                    .height(50.dp)
                    .alpha(0.8f)
                    .shadow(elevation = 0.dp, shape = RoundedCornerShape(15.dp)),
                color = transparent,
                shape = RoundedCornerShape(15.dp),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_search_24),
                        contentDescription = null,
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp)
                            .padding(10.dp)
                    )
                    TextField(
                        value = elementoBuscado,
                        onValueChange = { newText ->
                            elementoBuscado = newText
                                        },
                        maxLines = 1,
                        label = { Text(
                            text = stringResource(R.string.search_product),
                            color = Color.Black
                        ) },
                        textStyle = TextStyle(fontSize = 15.sp, color = Color.Black),
                        modifier = Modifier
                            .width(276.dp)
                            .padding(0.dp)
                            .background(Color.White),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Next
                        ),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = transparent,
                        ),
                        singleLine = true,
                    )

                }
            }
            Surface(
                modifier = modifier
                    .width(70.dp)
                    .height(50.dp)
                    .alpha(0.8f)
                    .padding(5.dp, 0.dp, 0.dp, 0.dp)
                    .shadow(elevation = 0.dp, shape = RoundedCornerShape(15.dp)),
                color = transparent,
                shape = RoundedCornerShape(15.dp),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_filter_alt_24),
                    contentDescription = null,
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .padding(10.dp),

                    )
            }
        }
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        Surface(
            modifier = modifier
                .width(300.dp)
                .height(50.dp)
                .alpha(0.8f)
                .shadow(elevation = 0.dp, shape = RoundedCornerShape(15.dp)),
            color = transparent,
            shape = RoundedCornerShape(15.dp),
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.select_product),
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black,
                )
            }
        }

        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        Surface(
            modifier = modifier
                .width(300.dp)
                .height(480.dp)
                .alpha(0.8f)
                .shadow(elevation = 0.dp, shape = RoundedCornerShape(15.dp)),
            color = transparent,
            shape = RoundedCornerShape(15.dp),
        )
        {
            rememberedProducts.value.forEach { product ->
                Text(text = product.title)


            }
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomEnd
            ) {
                Surface(
                    modifier = modifier
                        .width(80.dp)
                        .height(80.dp)
                        .alpha(0.8f)
                        .shadow(elevation = 0.dp, shape = RoundedCornerShape(15.dp))
                        .padding(10.dp)
                        .clickable(
                            onClick = {
                                navController.navigate("SelectedProduct")
                            }
                        ),
                    color = Color.White,
                    shape = RoundedCornerShape(15.dp),
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_playlist_add_24),
                        contentDescription = null,
                        modifier = Modifier
                            .width(80.dp)
                            .height(80.dp)
                            .padding(10.dp),

                        )
                }
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        Surface(
            modifier = modifier
                .width(150.dp)
                .height(50.dp)
                .alpha(0.8f)
                .shadow(elevation = 0.dp, shape = RoundedCornerShape(15.dp))
                .clickable(
                    onClick = {
                        navController.navigate("SearchList")
                    }
                ),
            color = transparent,
            shape = RoundedCornerShape(15.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.end_list),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black,
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DefaultPreview6() {
    Proyecto_Plataformas_móvilesTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = colorb) {
            Greeting6(navController = rememberNavController())
        }
    }
}