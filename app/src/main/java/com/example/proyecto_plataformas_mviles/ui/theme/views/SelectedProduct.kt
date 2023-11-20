package com.example.proyecto_plataformas_mviles.ui.theme.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
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
fun Greeting7(navController: NavController, modifier: Modifier = Modifier) {
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
        ){
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

        }
        Spacer(modifier = Modifier.height(20.dp))
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

@Composable
@Preview(showBackground = true)
fun DefaultPreview7() {
    Proyecto_Plataformas_móvilesTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = colorb) {
            Greeting7(navController = rememberNavController())
        }
    }
}