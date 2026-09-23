package com.example.banderas
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import com.example.banderas.ui.theme.BANDERASTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
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
fun StarCanvas(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {

        val path = Path()
        val w = size.width
        val h = size.height

        // margen interno
        val mx = w * 0.12f
        val my = h * 0.12f

        path.moveTo(w * 0.5f, my)
        path.lineTo(w * 0.62f, h * 0.35f)
        path.lineTo(w - mx, h * 0.35f)
        path.lineTo(w * 0.70f, h * 0.58f)
        path.lineTo(w * 0.80f, h - my)
        path.lineTo(w * 0.5f, h * 0.75f)
        path.lineTo(w * 0.20f, h - my)
        path.lineTo(w * 0.30f, h * 0.58f)
        path.lineTo(mx, h * 0.35f)
        path.lineTo(w * 0.38f, h * 0.35f)
        path.close()

        drawPath(path, Color.White)
    }
}


@Composable
fun StarsUSA(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        repeat(11) { rowIndex ->

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                val starsInRow =
                    if (rowIndex % 2 == 0) 5
                    else 4

                repeat(starsInRow) {
                    StarCanvas(
                        modifier = Modifier
                            .size(28.dp)
                            .padding(1.dp)
                    )
                }
            }
        }
    }
}


@Composable
fun BanderaUSA(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize()) {
            repeat(13) { index ->
                Box(
                    Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .background(if (index % 2 == 0) Color(0xFFB22234) else Color.White)
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.39f)
                .background(Color(0xFF3C3B6E))
        ){

            StarsUSA(Modifier.fillMaxSize())

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
