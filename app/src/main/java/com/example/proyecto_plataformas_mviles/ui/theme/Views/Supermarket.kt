package com.example.proyecto_plataformas_mviles.ui.theme.Views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyecto_plataformas_mviles.R
import com.example.proyecto_plataformas_mviles.ui.theme.Proyecto_Plataformas_móvilesTheme
import com.example.proyecto_plataformas_mviles.ui.theme.colorb

class Supermarket : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proyecto_Plataformas_móvilesTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize() ,color = colorb ) {
                    Greeting2()
                }
            }
        }
    }
}


@Composable
fun Greeting2() {
        Text(
            text = stringResource(R.string.supermarket),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )

}

@Preview(showBackground = true)
@Composable
fun Greeting2Preview() {
    Proyecto_Plataformas_móvilesTheme {
        Greeting2()
    }
}