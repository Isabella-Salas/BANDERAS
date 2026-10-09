package  com.example.banderas.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
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
                .background(Color(0xFFD52B1E))
        ) {
            val w = size.width
            val h = size.height
            val cy = h / 2f

            val rOut = h * 0.30f
            drawCircle(
                color = Color.White,
                radius = rOut,
                center = Offset(w * 0.38f, cy)
            )

            drawCircle(
                color = Color(0xFFD52B1E),
                radius = h * 0.24f,
                center = Offset(w * 0.38f + h * 0.09f, cy)
            )

            val starRadius = h * 0.10f
            val starCenter = Offset(w * 0.55f, cy)

            val star = Path().apply {
                star(
                    centerX = starCenter.x,
                    centerY = starCenter.y,
                    outerRadius = starRadius,
                    innerRadius = starRadius * 0.45f
                )
            }

            drawPath(
                path = star,
                color = Color.White
            )

        }
    }
}


@Preview(showBackground = true)
@Composable
fun BanderaPreview(){
    BanderaScreen(modifier = Modifier,)
}