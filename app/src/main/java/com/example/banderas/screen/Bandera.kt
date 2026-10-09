package  com.example.banderas.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import kotlin.math.cos
import kotlin.math.sin
import androidx.compose.ui.graphics.Path


fun Path.star(
    centerX: Float,
    centerY: Float,
    outerRadius: Float,
    innerRadius: Float
) {
    val points = 5
    val angle = (2.0 * Math.PI / points).toFloat()
    val halfAngle = angle / 2f

    moveTo(centerX, centerY - outerRadius)

    for (i in 1 until points * 2) {
        val r = if (i % 2 == 0) outerRadius else innerRadius
        val a = i * halfAngle - Math.PI.toFloat() / 2f

        val x = centerX + (r * kotlin.math.cos(a))
        val y = centerY + (r * kotlin.math.sin(a))

        lineTo(x, y)
    }

    close()
}


@Composable
fun BanderaScreen(modifier: Modifier = Modifier){
    ConstraintLayout(modifier = Modifier) {
        val (canvas) = createRefs()
        val guideStart = createGuidelineFromStart(0.1f)
        val guideEnd = createGuidelineFromEnd(0.1f)
        val guideTop = createGuidelineFromTop(0.2f)
        val guideBottom = createGuidelineFromBottom(0.2f)

        Canvas(
            modifier = Modifier
                .constrainAs(canvas) {
                    start.linkTo(guideStart)
                    end.linkTo(guideEnd)
                    top.linkTo(guideTop)
                    bottom.linkTo(guideBottom)
                }
                .fillMaxSize()
                .aspectRatio(1.5f)
                .background(Color.White)
        ) {
            val width = size.width
            val height = size.height
            val azulCuba = Color(0xFF002E6E) // Color azul clásico de la bandera


            val altoFranja = height * 0.15f // Altura proporcional de las franjas

            // Franja superior
            drawRect(
                color = azulCuba,
                topLeft = Offset(0f, height * 0.001f),
                size = Size(width, altoFranja)
            )
            //franja intermedia
            drawRect(
                color = azulCuba,
                topLeft = Offset(0f, height * 0.30f),
                size = Size(width, altoFranja)
            )
            //penultima franja
            drawRect(
                color = azulCuba,
                topLeft = Offset(0f, height * 0.58f),
                size = Size(width, altoFranja)
            )
            // Franja inferior
            drawRect(
                color = azulCuba,
                topLeft = Offset(0f, height * 0.85f),
                size = Size(width, altoFranja)
            )
            val triWidth = size.width * 0.38f
            val trianglePath = Path().apply {
                moveTo(0f, 0f)
                lineTo(triWidth, size.height / 2f)
                lineTo(0f, size.height)
                close()
            }
            drawPath(trianglePath, color = Color(0xFFCB1428))

            val centerX = triWidth * 0.45f
            val centerY = size.height / 2f

            val starPath = Path().apply {
                val outerRadius = triWidth * 0.18f
                val innerRadius = outerRadius * 0.45f
                star(centerX, centerY, outerRadius, innerRadius)
            }
            drawPath(starPath, color = Color.White)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BanderaPreview(){
    BanderaScreen(modifier = Modifier,)
}