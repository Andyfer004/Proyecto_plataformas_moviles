package com.example.proyecto_plataformas_mviles

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyecto_plataformas_mviles.ui.theme.Beige
import com.example.proyecto_plataformas_mviles.ui.theme.Proyecto_Plataformas_móvilesTheme
import com.example.proyecto_plataformas_mviles.ui.theme.colora
import com.example.proyecto_plataformas_mviles.ui.theme.colorb
import com.example.proyecto_plataformas_mviles.ui.theme.transparent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proyecto_Plataformas_móvilesTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize() ,color = colorb ) {
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
    var text2 by remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = modifier
                .width(317.dp)
                .height(600.dp)
                .alpha(0.8f)
                .shadow(elevation = 0.dp, shape = RoundedCornerShape(15.dp)) ,
            color = transparent,
            shape = RoundedCornerShape(15.dp),
        )
        {
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
                        .height(70.dp),
                    shape = RoundedCornerShape(15.dp),
                    color = colora,
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "Welcome",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Black,
                        )
                        Text(
                            text = "To lista chapina",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Black,
                        )
                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(100.dp)
                )
                Surface(
                    modifier = Modifier
                        .width(276.dp)
                        .height(60.dp)
                        .border(1.dp, Color.Black, RoundedCornerShape(15.dp)),
                    shape = RoundedCornerShape(15.dp),
                    color = Color.White,
                ) {
                    Row() {
                        Icon(
                            painter = painterResource(id = R.drawable.gmail),
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier
                                .padding(10.dp),

                            )

                        TextField(
                            value = text,
                            onValueChange = { newText ->
                                if (newText.length <= 25) {
                                    text = newText
                                }
                            },
                            label = { Text("Correo electrónico") },
                            textStyle = TextStyle(fontSize = 15.sp, color = Color.Black),
                            modifier = Modifier
                                .width(276.dp)
                                .padding(0.dp)
                                .background(Color.White),

                            )

                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                Surface(
                    modifier = Modifier
                        .width(276.dp)
                        .height(60.dp)
                        .border(1.dp, Color.Black, RoundedCornerShape(15.dp)),
                    shape = RoundedCornerShape(15.dp),
                    color = Color.White,
                ) {
                    Row() {
                        Icon(
                            painter = painterResource(id = R.drawable.key),
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier
                                .padding(10.dp),

                            )

                        TextField(
                            value = text2,
                            onValueChange = { newText2 ->
                                if (newText2.length <= 10) {
                                    text2 = newText2
                                }
                            },
                            label = { Text("Contraseña") },
                            textStyle = TextStyle(fontSize = 15.sp, color = Color.Black),
                            modifier = Modifier
                                .width(276.dp)
                                .padding(0.dp)
                                .background(Color.White),
                            visualTransformation = PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Password

                            )
                        )

                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(100.dp)
                )

                Button(
                    onClick = {
                        if (ValidUser( text ,text2)) {
                            val intent = Intent(context, Supermarket::class.java)
                            context.startActivity(intent)
                        }
                    },
                    modifier = Modifier
                        .width(150.dp)
                        .align(Alignment.CenterHorizontally),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                    )
                ){
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "Sign in",
                            fontSize = 30.sp,
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
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp)
                ) {
                    Text(
                        text = "No tienes cuenta?, presiona aquí",
                        fontSize = 13.sp,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Black,
                        textDecoration = TextDecoration.Underline,
                    )

                }
            }
            }
                }
            }

private val correos = mapOf(
    "Jorge1805@gmail.com" to "CR7MESSI",
    "Admin@gmail.com" to "Admin1",
    "Sergio23@gmail.com" to "Sergio23",
    "Admin2@gmail.com" to "Admin2",
)
private fun ValidUser(text: String, text2: String): Boolean {
    return correos[text] == text2
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Proyecto_Plataformas_móvilesTheme {
        Greeting("")
    }
}