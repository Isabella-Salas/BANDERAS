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
import androidx.compose.ui.graphics.drawscope.Fill


@Composable
fun BanderaScreen(modifier: Modifier = Modifier){
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1.5f) // Mantiene la proporción oficial 3:2 de la bandera
    ) {

        val blanco = Color.White
        val azul =  Color(0xFF012169)
        val rojo = Color(0xFFCF142B)
        val amarillo = Color(0xFFFFB81C)
        val verde = Color(0xFF007749)
        val mitadTamano = size.height / 2f

        drawRect(color = azul,
                topLeft = Offset(0f,0f),
                size = Size(size.width,mitadTamano)
            )
        drawRect(
                color = amarillo,
                topLeft = Offset(0f,mitadTamano),
                size = Size(size.width,mitadTamano)
        )

        val grosorDiagonalBlanca = size.height * 0.22f
        val grosorDiagonalVerde = size.height * 0.13f


        drawLine(blanco, Offset(0f, 0f), Offset(size.width, size.height), grosorDiagonalBlanca)
        drawLine(blanco, Offset(size.width, 0f), Offset(0f, size.height), grosorDiagonalBlanca)
        drawLine(verde, Offset(0f, 0f), Offset(size.width, size.height), grosorDiagonalVerde)
        drawLine(verde, Offset(size.width, 0f), Offset(0f, size.height), grosorDiagonalVerde)

        val triWidth = size.width * 0.43f
        val trianglePath = Path().apply {
            moveTo(0f, 0f)
            lineTo(triWidth, size.height / 2f)
            lineTo(0f, size.height)
            close()
        }
        drawPath(trianglePath, color = Color.Black)

    }


}


@Preview(showBackground = true)
@Composable
fun BanderaPreview(){
    BanderaScreen(modifier = Modifier,)
}