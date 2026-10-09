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

            val black = Color(0xFF000000)
            val red = Color(0xFFD00000)

            // Triángulo negro
            val blackPoints = listOf(
                Offset(0f, 0f),
                Offset(size.width, size.height),
                Offset(0f, size.height)
            )

            val blackPath = Path().apply {
                moveTo(blackPoints[0].x, blackPoints[0].y)
                lineTo(blackPoints[1].x, blackPoints[1].y)
                lineTo(blackPoints[2].x, blackPoints[2].y)
                close()
            }
            drawPath(blackPath, black)

            // Triángulo rojo
            val redPoints = listOf(
                Offset(0f, 0f),
                Offset(size.width, 0f),
                Offset(size.width, size.height)
            )

            val redPath = Path().apply {
                moveTo(redPoints[0].x, redPoints[0].y)
                lineTo(redPoints[1].x, redPoints[1].y)
                lineTo(redPoints[2].x, redPoints[2].y)
                close()
            }
            drawPath(redPath, red)

            // Estrella
            val triWidth = size.width * 0.38f
            val centerX = triWidth * 0.45f
            val centerY = size.height / 2f

            val starPath = Path().apply {
                val outerRadius = triWidth * 0.18f
                val innerRadius = outerRadius * 0.45f
                star(centerX, centerY, outerRadius, innerRadius)
            }

            drawPath(starPath, color = Color.Yellow)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BanderaPreview(){
    BanderaScreen(modifier = Modifier,)
}