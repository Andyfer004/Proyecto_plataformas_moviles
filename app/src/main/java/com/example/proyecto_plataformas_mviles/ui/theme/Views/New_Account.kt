package com.example.proyecto_plataformas_mviles.ui.theme.Views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyecto_plataformas_mviles.R
import com.example.proyecto_plataformas_mviles.ui.theme.Proyecto_Plataformas_móvilesTheme
import com.example.proyecto_plataformas_mviles.ui.theme.colorb

class New_Account : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proyecto_Plataformas_móvilesTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize() ,color = colorb ) {
                    Greeting3()
                }
            }
        }
    }
}


@Composable
fun Greeting4() {
    val context = LocalContext.current
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var secondpassword by remember { mutableStateOf("") }
    val error = stringResource(R.string.error_user_password)




}

@Preview(showBackground = true)
@Composable
fun Greeting4Preview() {
    Proyecto_Plataformas_móvilesTheme {
        Greeting3()
    }
}