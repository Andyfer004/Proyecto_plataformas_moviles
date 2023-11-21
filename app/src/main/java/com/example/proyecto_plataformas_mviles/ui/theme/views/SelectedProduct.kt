package com.example.proyecto_plataformas_mviles.ui.theme.views

import InfoViewModel
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.proyecto_plataformas_mviles.R
import com.example.proyecto_plataformas_mviles.ui.theme.Proyecto_Plataformas_móvilesTheme
import com.example.proyecto_plataformas_mviles.ui.theme.colorb
import com.example.proyecto_plataformas_mviles.ui.theme.transparent

class SelectedProduct : ComponentActivity() {
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

@Composable
fun Greeting7(title: String,price : String, image : String,navController: NavController, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    var quantity by remember { mutableStateOf(1) }
    val viewModel: InfoViewModel = viewModel()
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        Surface(
            modifier = modifier
                .width(317.dp)
                .height(50.dp)
                .alpha(0.8f)
                .shadow(elevation = 0.dp, shape = RoundedCornerShape(15.dp)),
            color = transparent,
            shape = RoundedCornerShape(15.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = stringResource(R.string.selected_product),
                    fontSize = 20.sp,
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
                .width(317.dp)
                .height(300.dp)
                .alpha(0.8f)
                .shadow(elevation = 0.dp, shape = RoundedCornerShape(15.dp)),
            color = transparent,
            shape = RoundedCornerShape(15.dp),
        )
        {
            Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
            ) {

                Button(
                    onClick = {
                        // Aquí puedes poner la acción que se ejecutará cuando se haga clic en el botón.
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .shadow(
                            elevation = 10.dp,
                            shape = RoundedCornerShape(20.dp),
                        ),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp), // Espaciado entre elementos
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        // Imagen a la izquierda
                        Image(
                            painter = rememberImagePainter(data = image),
                            contentDescription = null, // Agrega descripción apropiada
                            modifier = Modifier
                                .size(95.dp) // Tamaño de la imagen
                        )
                        Column {

                            // Categoría a la derecha
                            Text(
                                text = "$title",
                                modifier = Modifier
                                    .padding(start = 16.dp)
                                    .fillMaxWidth(), // Espaciado entre imagen y texto
                                style = TextStyle(fontSize = 10.sp), // Tamaño de texto apropiado
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                                color = Color.Black
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "$price"+" $",
                                modifier = Modifier
                                    .padding(start = 16.dp), // Espaciado entre imagen y texto
                                style = TextStyle(fontSize = 10.sp), // Tamaño de texto apropiado
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                                color = Color.Black
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Button(
                                    onClick = {
                                        if (quantity > 0) {
                                            quantity--
                                        }
                                    },
                                    modifier = Modifier.size(30.dp)
                                        .shadow(
                                        elevation = 10.dp,
                                        shape = RoundedCornerShape(20.dp),
                                    ),
                                    shape = RoundedCornerShape(20.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)

                                ) {
                                    Text(
                                        text = "-",
                                        modifier = Modifier
                                            .padding(start = 0.dp), // Espaciado entre imagen y texto
                                        style = TextStyle(fontSize = 10.sp), // Tamaño de texto apropiado
                                        maxLines = 2,
                                        overflow = TextOverflow.Ellipsis,
                                        color = Color.Black
                                    )
                                }
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "$quantity",
                                    style = TextStyle(fontSize = 10.sp),
                                    color = Color.Black
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Button(
                                    onClick = {
                                        quantity++
                                    },
                                    modifier = Modifier.size(30.dp)
                                        .shadow(
                                            elevation = 10.dp,
                                            shape = RoundedCornerShape(20.dp),
                                        ),
                                    shape = RoundedCornerShape(20.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                                ) {
                                    Text(
                                        text = "+",
                                        modifier = Modifier
                                            .padding(start = 0.dp), // Espaciado entre imagen y texto
                                        style = TextStyle(fontSize = 10.sp), // Tamaño de texto apropiado
                                        maxLines = 2,
                                        overflow = TextOverflow.Ellipsis,
                                        color = Color.Black
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "Total: ${(quantity * price.toDouble()).toFloat()}"+" $",
                                style = TextStyle(fontSize = 10.sp),
                                color = Color.Black
                            )

                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            Row() {
                Surface(
                    modifier = modifier
                        .width(150.dp)
                        .height(50.dp)
                        .padding(5.dp)
                        .alpha(0.8f)
                        .shadow(elevation = 0.dp, shape = RoundedCornerShape(15.dp))
                        .clickable(
                            onClick = {
                                navController.navigate("SearchProduct")
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
                            text = stringResource(R.string.cancel),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Black,
                        )
                    }
                }
                Surface(
                    modifier = modifier
                        .width(150.dp)
                        .height(50.dp)
                        .alpha(0.8f)
                        .padding(5.dp)
                        .shadow(elevation = 0.dp, shape = RoundedCornerShape(15.dp))
                        .clickable(
                            onClick = {
                                viewModel.guardarDatosEnFirebase(
                                    Infodb(
                                        title = title,
                                        quantity = quantity,
                                        image = image,
                                        price = price
                                    )
                                )
                                navController.navigate("SearchProduct")
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
                            text = stringResource(R.string.save),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Black,
                        )
                    }
                }
            }
        }
    }
data class Infodb(
    val title: String,
    val quantity: Int,
    val image: String,
    val price: String
)




