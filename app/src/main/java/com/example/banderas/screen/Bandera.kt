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
        ){
            val w = size.width
            val h = size.height
            val cy = h / 2f

            val horizontalWidth = w * 1f
            val horizontalHeight = h * 0.2f

            drawRect(
                color = Color(0xFF0038A8),
                topLeft = Offset(
                    x = (w - horizontalWidth) / 0.5f, // centrado
                    y = (h - horizontalHeight) / 0.80f
                ),
                size = Size(horizontalWidth, horizontalHeight)
            )

            drawRect(
                color = Color(0xFF0038A8),
                topLeft = Offset(
                    x = (w - horizontalWidth) / 0.5f, // centrado
                    y = (h - horizontalHeight) / 15f
                ),
                size = Size(horizontalWidth, horizontalHeight)
            )
            // 3. Estrella de David (Magen David) en el centro
            val centroX = size.width / 2f
            val centroY = size.height / 2f
            val radioEstrella = size.height * 0.22f // Tamaño del radio de la estrella

            // Triángulo superior (apuntando hacia arriba)
            val pathTriangulo1 = Path().apply {
                for (i in 0 until 3) {
                    // Ángulos para formar el triángulo apuntando hacia arriba
                    val angulo = (-Math.PI / 2) + (i * 2 * Math.PI / 3)
                    val x = centroX + (radioEstrella * cos(angulo)).toFloat()
                    val y = centroY + (radioEstrella * sin(angulo)).toFloat()
                    if (i == 0) moveTo(x, y) else lineTo(x, y)
                }
                close()
            }

            // Triángulo inferior (apuntando hacia abajo)
            val pathTriangulo2 = Path().apply {
                for (i in 0 until 3) {
                    // Ángulos girados para formar el triángulo invertido
                    val angulo = (Math.PI / 2) + (i * 2 * Math.PI / 3)
                    val x = centroX + (radioEstrella * cos(angulo)).toFloat()
                    val y = centroY + (radioEstrella * sin(angulo)).toFloat()
                    if (i == 0) moveTo(x, y) else lineTo(x, y)
                }
                close()
            }

            // Dibujar los contornos o relleno de la estrella de David
            // Usamos Stroke para que se vea con líneas definidas como la bandera oficial
            drawPath(
                path = pathTriangulo1,
                color = Color(0xFF0038A8),
                style = Stroke(width = 8f) // Grosor de las líneas de la estrella
            )
            drawPath(
                path = pathTriangulo2,
                color = Color(0xFF0038A8),
                style = Stroke(width = 8f)
            )

        }
    }
}


@Preview(showBackground = true)
@Composable
fun BanderaPreview(){
    BanderaScreen(modifier = Modifier,)
}