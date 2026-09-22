package com.example.banderas
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import com.example.banderas.ui.theme.BANDERASTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BANDERASTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BanderaUSA(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BanderaUSA(modifier: Modifier = Modifier) {
        Box(
            modifier = modifier.fillMaxSize().background(Color.White),
            contentAlignment = Alignment.Center
        )
        {
            Column(Modifier.fillMaxSize()){
                    repeat(13) { index ->
                        Box( Modifier
                             .fillMaxWidth(1f)
                            .fillMaxHeight()

                        )
                    }
            }

        }



}
@Preview(showBackground = true)
@Composable
fun BanderaUSAPreview() {
    Surface {
        BanderaUSA(modifier = Modifier.fillMaxSize())
    }
}
