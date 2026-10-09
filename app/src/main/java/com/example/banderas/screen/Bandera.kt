package  com.example.banderas.screen


import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.ui.geometry.Offset
import androidx.constraintlayout.compose.ConstraintLayout


@Composable
fun BanderaScreen(modifier: Modifier = Modifier){
    ConstraintLayout(
        modifier = modifier.fillMaxSize()
    ) {
        val (canvasRef) = createRefs()

        val guideStart = createGuidelineFromStart(0.1f)
        val guideEnd = createGuidelineFromEnd(0.1f)
        val guideTop = createGuidelineFromTop(0.1f)
        val guideBottom = createGuidelineFromBottom(0.1f)

        Canvas(
            modifier = Modifier
                .constrainAs(canvasRef) {
                    start.linkTo(guideStart)
                    end.linkTo(guideEnd)
                    top.linkTo(guideTop)
                    bottom.linkTo(guideBottom)
                }
                .fillMaxWidth()
                .aspectRatio(1.5f)
        ) {

            val blanco = Color.White
            val azul = Color(0xFF012169)
            val rojo = Color(0xFFCF142B)

            // Fondo azul
            drawRect(color = azul)

            val grosorDiagonalBlanca = size.height * 0.22f
            val grosorDiagonalRoja = size.height * 0.09f
            val grosorDiagonalRojaGde = size.height * 0.12f
            val centroX = size.width / 2f
            val centroY = size.height / 2f

            // Diagonales blancas
            drawLine(blanco, Offset(0f, 0f), Offset(size.width, size.height), grosorDiagonalBlanca)
            drawLine(blanco, Offset(size.width, 0f), Offset(0f, size.height), grosorDiagonalBlanca)

            // Diagonales rojas
            drawLine(rojo, Offset(0f, 0f), Offset(size.width, size.height), grosorDiagonalRoja)
            drawLine(rojo, Offset(size.width, 0f), Offset(0f, size.height), grosorDiagonalRoja)

            // Cruces vertical y horizontal blancas
            drawLine(
                color = blanco,
                start = Offset(centroX, 0f),
                end = Offset(centroX, size.height),
                strokeWidth = grosorDiagonalBlanca
            )
            drawLine(
                color = blanco,
                start = Offset(0f, centroY),
                end = Offset(size.width, centroY),
                strokeWidth = grosorDiagonalBlanca
            )

            // Cruces vertical y horizontal rojas
            drawLine(
                color = rojo,
                start = Offset(centroX, 0f),
                end = Offset(centroX, size.height),
                strokeWidth = grosorDiagonalRojaGde
            )
            drawLine(
                color = rojo,
                start = Offset(0f, centroY),
                end = Offset(size.width, centroY),
                strokeWidth = grosorDiagonalRojaGde
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BanderaPreview(){
    BanderaScreen(modifier = Modifier,)
}