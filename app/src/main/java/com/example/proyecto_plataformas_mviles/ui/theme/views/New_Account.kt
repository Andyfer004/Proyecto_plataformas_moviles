package com.example.proyecto_plataformas_mviles.ui.theme.views

import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
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
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class New_Account : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proyecto_Plataformas_móvilesTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize() ,color = colorb ) {
                    Greeting4(navController = rememberNavController() )
                }
            }
        }
        val auth = FirebaseAuth.getInstance()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting4(modifier: Modifier = Modifier,navController: NavController) {
    val context = LocalContext.current
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var secondpassword by remember { mutableStateOf("") }
    val error = stringResource(R.string.error_user_password)
    val auth = Firebase.auth
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
                        .height(50.dp),
                    shape = RoundedCornerShape(15.dp),
                    color = colora,
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = stringResource(R.string.create_account),
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Black,
                        )
                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(60.dp)
                )
                Surface(
                    modifier = Modifier
                        .width(276.dp)
                        .height(60.dp)
                        .border(1.dp, Color.Black, RoundedCornerShape(15.dp)),
                    shape = RoundedCornerShape(15.dp),
                    color = Color.White,
                ) {
                    Row {
                        Icon(
                            painter = painterResource(id = R.drawable.gmail),
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier
                                .padding(10.dp),

                            )

                        TextField(
                            value = user,
                            onValueChange = { newText ->
                                if (newText.length <= 25) {
                                    user = newText
                                }
                            },
                            singleLine = true,
                            placeholder = { Text(stringResource(R.string.correo)) },
                            label = { Text(stringResource(R.string.user)) },
                            textStyle = TextStyle(fontSize = 15.sp, color = Color.Black),
                            modifier = Modifier
                                .width(276.dp)
                                .padding(0.dp)
                                .background(Color.White),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color(218, 215, 205)
                            ),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Email,
                                imeAction = ImeAction.Next
                            )
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
                    Row {
                        Icon(
                            painter = painterResource(id = R.drawable.key),
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier
                                .padding(10.dp),
                        )

                        TextField(
                            value = password,
                            onValueChange = { newText2 ->
                                if (newText2.length <= 10) {
                                    password = newText2
                                }
                            },
                            maxLines = 1,
                            label = { Text(stringResource(R.string.password)) },
                            textStyle = TextStyle(fontSize = 15.sp, color = Color.Black),
                            modifier = Modifier
                                .width(276.dp)
                                .padding(0.dp)
                                .background(Color.White),
                            visualTransformation = PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Password,
                                imeAction = ImeAction.Next
                            ),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color(218, 215, 205)
                            ),
                            singleLine = true,
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
                        Row {
                            Icon(
                                painter = painterResource(id = R.drawable.key),
                                contentDescription = null,
                                tint = Color.Black,
                                modifier = Modifier
                                    .padding(10.dp),
                            )

                            TextField(
                                value = secondpassword,
                                onValueChange = { newText3 ->
                                    if (newText3.length <= 10 ) {
                                        secondpassword = newText3
                                    }
                                },
                                maxLines = 1,
                                label = { Text(stringResource(R.string.password2)) },
                                textStyle = TextStyle(fontSize = 15.sp, color = Color.Black),
                                modifier = Modifier
                                    .width(276.dp)
                                    .padding(0.dp)
                                    .background(Color.White),
                                visualTransformation = PasswordVisualTransformation(),
                                keyboardOptions = KeyboardOptions.Default.copy(
                                    keyboardType = KeyboardType.Password,
                                    imeAction = ImeAction.Next
                                ),
                                colors = TextFieldDefaults.textFieldColors(
                                    containerColor = Color(218, 215, 205)
                                ),
                                singleLine = true,
                            )
                        }
                    }
                    Spacer(
                        modifier = Modifier
                            .height(70.dp)
                    )

                    Button(
                        onClick = {
                            if (user == "" || password == "" || secondpassword == "") {
                                Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
                            } else {
                                if (!user.endsWith("@gmail.com")) {
                                    Toast.makeText(context, "El correo debe terminar con @gmail.com", Toast.LENGTH_SHORT).show()
                                } else if (password.length < 6 || password.length > 10) {
                                    Toast.makeText(context, "La contraseña debe tener entre 6 y 10 caracteres", Toast.LENGTH_SHORT).show()
                                } else if (password == secondpassword) {
                                    // Realizar la autenticación con Firebase
                                    auth.createUserWithEmailAndPassword(user, password)
                                        .addOnCompleteListener { task ->
                                            if (task.isSuccessful) {
                                                // Autenticación exitosa
                                                Toast.makeText(context, "Cuenta creada", Toast.LENGTH_SHORT).show()
                                                navController.navigate("MainActivity")
                                            } else {
                                                // Autenticación fallida
                                                Toast.makeText(context, "Error en la autenticación: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                                            }
                                        }
                                } else {
                                    Toast.makeText(context, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                                }
                            }
                        },
                        modifier = Modifier
                            .width(250.dp)
                            .align(Alignment.CenterHorizontally),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                        )
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(
                                text = stringResource(R.string.create_account),
                                fontSize = 25.sp,
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
                    ClickableText(
                        text = AnnotatedString(stringResource(R.string.sign_in2)),
                        onClick = {
                            navController.navigate("MainActivity")
                        },
                        style = TextStyle(
                            fontSize = 13.sp,
                            color = Color.Black,
                            textDecoration = TextDecoration.Underline
                        )
                    )

                }
                }
            }
        }
    }






@Preview(showBackground = true)
@Composable
fun Greeting4Preview() {
    val navController = rememberNavController()
    Proyecto_Plataformas_móvilesTheme {
        Greeting4(navController = navController)
    }
}