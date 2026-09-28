package com.example.banderas


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas.ui.theme.BANDERASTheme
implementation ("androidx.constraintlayout:constraintlayout-compose:1.1.0")


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BANDERASTheme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BanderaScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BanderaMexicoPreview() {
    BANDERASTheme() {
        BanderaMexico(modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun BanderaMexico(modifier: Modifier) {
    TODO("Not yet implemented")
}