package com.example.proyecto_plataformas_mviles.ui.theme.views

import InfoViewModel
import android.content.ContentValues.TAG
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.google.android.play.core.integrity.e
import com.google.firebase.auth.FirebaseAuth

class SearchList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proyecto_Plataformas_móvilesTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = colorb) {
                    Greeting5(navController = rememberNavController())
                }
            }
        }
    }
}
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Greeting5(navController: NavController, modifier: Modifier = Modifier) {
        var elementobuscado by remember { mutableStateOf("") }
        val InfoViewModel: InfoViewModel = viewModel()
        val auth = FirebaseAuth.getInstance()
        val userId: String? = auth.currentUser?.uid

        val colecciones = remember { mutableStateOf<List<String>>(listOf()) }

        // Suponiendo que tienes una función que obtiene las colecciones y actualiza el estado
        LaunchedEffect(Unit) {
            colecciones.value = InfoViewModel.obtenerNombresDeColecciones(userId!!)
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
                            value = elementobuscado,
                            onValueChange = { newText ->
                                if (newText.length <= 30) {
                                    elementobuscado = newText
                                }
                            },
                            maxLines = 1,
                            label = { Text(
                                text = stringResource(R.string.search_list),
                                color = Color.Black
                            ) },
                            textStyle = TextStyle(fontSize = 15.sp, color = Color.Black),
                            modifier = Modifier
                                .width(276.dp)
                                .padding(0.dp)
                                .background(Color.White),
                            keyboardOptions = KeyboardOptions.Default.copy(
                                imeAction = ImeAction.Search
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
                        .padding(5.dp, 0.dp, 0.dp, 0.dp)
                        .alpha(0.8f)
                        .shadow(elevation = 0.dp, shape = RoundedCornerShape(15.dp))
                        .clickable(
                            onClick = {
                                navController.navigate("MainActivity")
                            }
                        ),
                    color = transparent,
                    shape = RoundedCornerShape(15.dp),
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_exit_to_app_24),
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
                    .height(20.dp)
            )
            Surface(
                modifier = modifier
                    .width(317.dp)
                    .height(500.dp)
                    .alpha(0.8f)
                    .shadow(elevation = 0.dp, shape = RoundedCornerShape(15.dp)),
                color = transparent,
                shape = RoundedCornerShape(15.dp),
            )
            {
                LazyColumn {
                    items(colecciones.value){ coleccion ->
                    Button(
                        onClick = {

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

                            Text(
                                text = coleccion,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp),
                                color = Color.Black
                            )
                        }

                    }
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
                                    InfoViewModel.crearNuevaColeccion()
                                        navController.navigate("Supermarket")
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
        }
    }

@Composable
@Preview(showBackground = true)
fun DefaultPreview5() {
    Proyecto_Plataformas_móvilesTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = colorb) {
            Greeting5(navController = rememberNavController())
        }
    }
}
