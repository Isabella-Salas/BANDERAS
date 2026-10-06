package  com.example.banderas.screen

import android.R
import android.R.attr.end
import android.R.attr.start
import android.R.attr.top
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Path




@Composable
fun BanderaScreen(modifier: Modifier = Modifier){
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1.5f) // Mantiene la proporción oficial 3:2 de la bandera
    ) {

        val blanco = Color.White
        val azul =  Color(0xFF012169)
        val height = size.height
        val width = size.width

        drawRect(color = azul)

        val grosorDiagonalBlanca = size.height * 0.22f
        val grosorDiagonalRoja = size.height * 0.10f
        val grosorDiagonalRojaGde = size.height * 0.18f
        val centroX = size.width / 2f
        val centroY = size.height / 2f

        drawLine(blanco, Offset(0f, 0f), Offset(size.width, size.height), grosorDiagonalBlanca)
        drawLine(blanco, Offset(size.width, 0f), Offset(0f, size.height), grosorDiagonalBlanca)
        drawLine(Color.Red, Offset(0f, 0f), Offset(size.width, size.height), grosorDiagonalRoja)
        drawLine(Color.Red, Offset(size.width, 0f), Offset(0f, size.height), grosorDiagonalRoja)
        drawLine(
            color = Color.White,
            start = Offset(centroX, 0f),
            end = Offset(centroX, size.height),
            strokeWidth = grosorDiagonalBlanca
        )
        drawLine(
            color = blanco,
            start = Offset(0f, centroY),
            end = Offset(size.width, centroY
            ),
            strokeWidth = grosorDiagonalBlanca
        )
    }
}


@Preview(showBackground = true)
@Composable
fun BanderaPreview(){
    BanderaScreen(modifier = Modifier,)
}