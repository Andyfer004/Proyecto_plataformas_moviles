package com.example.proyecto_plataformas_mviles.ui.theme.views

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
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

class Supermarket : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proyecto_Plataformas_móvilesTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize() ,color = colorb ) {
                }
            }
        }
    }
}


@Composable
fun Greeting2( navController: NavController, modifier: Modifier = Modifier) {

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
                        .height(45.dp),
                    shape = RoundedCornerShape(15.dp),
                    color = colora,
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = stringResource(R.string.supermarkets_view),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Black,
                        )
                    }
                }

                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "Button Image",
                    modifier = Modifier
                        .width(280.dp)
                        .height(200.dp)
                        .clickable {
                            // Handle the button click
                            navController.navigate("SearchProduct")
                        }
                        .padding(8.dp) // Optional padding
                )

                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun Greeting2Preview() {
    val navController = rememberNavController()
    Proyecto_Plataformas_móvilesTheme {
    }
}