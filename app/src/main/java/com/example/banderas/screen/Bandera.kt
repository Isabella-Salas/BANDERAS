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

            val azulSeychelle = Color(0xFF002F6C)
            val amarilloSeychelle = Color(0xFFFED141)
            val rojoSeychelle = Color(0xFFD22730)
            val verdeSeychelle = Color(0xFF007A33)

            val origin = Offset(0f, size.height)

            val angles = listOf(90f, 72f, 54f, 36f, 18f, 0f)
            val points = angles.map { pointFromAngle(it, size) }

            val colors = listOf(
                azulSeychelle,
                amarilloSeychelle,
                rojoSeychelle,
                Color.White,
                verdeSeychelle
            )

            for (i in 0 until 5) {
                val path = Path().apply {
                    moveTo(origin.x, origin.y)
                    lineTo(points[i].x, points[i].y)
                    lineTo(points[i + 1].x, points[i + 1].y)
                    close()
                }
                drawPath(path, colors[i])
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun BanderaPreview(){
    BanderaScreen(modifier = Modifier,)
}