package com.example.proyecto_plataformas_mviles.ui.theme.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.proyecto_plataformas_mviles.R
import com.example.proyecto_plataformas_mviles.ui.theme.Proyecto_Plataformas_móvilesTheme
import com.example.proyecto_plataformas_mviles.ui.theme.colora
import com.example.proyecto_plataformas_mviles.ui.theme.colorb
import com.example.proyecto_plataformas_mviles.ui.theme.transparent

class ListProducts : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proyecto_Plataformas_móvilesTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = colorb) {
                    Greeting8(navController = rememberNavController())
                }
            }
        }
    }
}

@Composable
fun Greeting8(navController: NavController, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
                    text = stringResource(R.string.list_products),
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
                .padding(5.dp)
                .shadow(elevation = 0.dp, shape = RoundedCornerShape(15.dp)),
            color = transparent,
            shape = RoundedCornerShape(15.dp),
        )
        {
            Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
            ) {
                //Lista de los productos
                //remeberedProductos.value.forEach { product ->
                Surface (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                        .shadow(elevation = 0.dp, shape = RoundedCornerShape(15.dp)), // Espaciado entre elementos
                    shape = RoundedCornerShape(15.dp),
                    color = colora,
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp), // Espaciado entre elementos
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        // Imagen a la izquierda
                        Image(
                            painter = painterResource(id = R.drawable.img),
                            contentDescription = null, // Agrega descripción apropiada
                            modifier = Modifier
                                .size(80.dp) // Tamaño de la imagen
                        )
                        Column {
                            // Categoría a la derecha
                            Text(
                                text = stringResource(id = R.string.titleProduct) + ": Café",
                                modifier = Modifier
                                    .padding(start = 14.dp)
                                    .fillMaxWidth(), // Espaciado entre imagen y texto
                                style = TextStyle(fontSize = 14.sp), // Tamaño de texto apropiado
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                                color = Color.Black
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = stringResource(id = R.string.precio) + ": 200 $",
                                modifier = Modifier
                                    .padding(start = 14.dp)
                                    .fillMaxWidth(), // Espaciado entre imagen y texto
                                style = TextStyle(fontSize = 14.sp), // Tamaño de texto apropiado
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                                color = Color.Black
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = stringResource(id = R.string.cantidad) + ": 2",
                                modifier = Modifier
                                    .padding(start = 14.dp)
                                    .fillMaxWidth(), // Espaciado entre imagen y texto
                                style = TextStyle(fontSize = 14.sp), // Tamaño de texto apropiado
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                                color = Color.Black
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = stringResource(id = R.string.total) + ": 400 $",
                                modifier = Modifier
                                    .padding(start = 14.dp)
                                    .fillMaxWidth(), // Espaciado entre imagen y texto
                                style = TextStyle(fontSize = 14.sp), // Tamaño de texto apropiado
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                                color = Color.Black
                            )
                        }
                    }
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
                    text = stringResource(R.string.back),
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
fun DefaultPreview8() {
    Proyecto_Plataformas_móvilesTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = colorb) {
            Greeting8(navController = rememberNavController())
        }
    }
}
