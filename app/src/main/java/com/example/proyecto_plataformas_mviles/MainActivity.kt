package com.example.proyecto_plataformas_mviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyecto_plataformas_mviles.ui.theme.Beige
import com.example.proyecto_plataformas_mviles.ui.theme.Proyecto_Plataformas_móvilesTheme
import com.example.proyecto_plataformas_mviles.ui.theme.transparent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proyecto_Plataformas_móvilesTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize() ,color = Beige ) {
                    Greeting("")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var text by remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = modifier
                .width(317.dp)
                .height(600.dp)
                .alpha(0.8f),
            shape = RoundedCornerShape(15.dp),
            color = transparent,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(
                    modifier = Modifier
                        .height(50.dp)
                )
                Surface(
                    modifier = Modifier
                        .width(276.dp)
                        .height(40.dp),
                    shape = RoundedCornerShape(15.dp),
                    color = Color.White,
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "Crear cuenta",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Black,
                        )

                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(50.dp)
                )
                Surface(
                    modifier = Modifier
                        .width(276.dp)
                        .height(60.dp),
                    shape = RoundedCornerShape(15.dp),
                    color = Color.White,
                ) {
                    TextField(
                        value = text,
                        onValueChange = { newText ->
                            if (newText.length <= 10) {
                                text = newText
                            }
                        },
                        label = { Text("Username") },
                        textStyle = androidx.compose.ui.text.TextStyle(fontSize = 20.sp),
                        modifier = Modifier
                            .width(276.dp)
                            .padding(0.dp)
                            .background(Color.Transparent)
                    )

                }
                }
            }
        }
    }



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Proyecto_Plataformas_móvilesTheme {
        Greeting("")
    }
}