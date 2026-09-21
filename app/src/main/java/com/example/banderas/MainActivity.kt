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
import androidx.compose.foundation.shape.GenericShape
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
                    BanderaBrasil(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

val RombosShape = GenericShape { size, _ ->
    moveTo(size.width / 2f, 0f)
    lineTo(size.width, size.height / 2f)
    lineTo(size.width / 2f, size.height)
    lineTo(0f, size.height / 2f)
    close()
}

@Composable
fun BanderaBrasil(modifier: Modifier = Modifier) {
        Box(
            modifier = modifier.fillMaxSize().background(Color(0xFF009B3A)),
            contentAlignment = Alignment.Center
        )
        {
        }
        Box(
            modifier = Modifier
                .fillMaxSize(0.75f)
                .clip(RombosShape)
                .background(Color(0xFFFEDF00))
        )

        Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(Color.Blue)
                )
}
@Preview(showBackground = true)
@Composable
fun BanderaBrasilPreview() {
    Surface {
        BanderaBrasil(modifier = Modifier.fillMaxSize())
    }
}
