package  com.example.banderas.screen

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.Path
import com.example.banderas.R
import kotlinx.coroutines.NonDisposableHandle.parent
import kotlin.math.cos
import kotlin.math.sin

fun pointFromAngle(angle: Float, size: Size): Offset {
    val rad = Math.toRadians(angle.toDouble())
    val dx = kotlin.math.cos(rad).toFloat()
    val dy = kotlin.math.sin(rad).toFloat()

    val origin = Offset(0f, size.height)

    // Intersección con borde superior
    val tTop = size.height / dy
    val xTop = origin.x + dx * tTop
    val yTop = origin.y - dy * tTop

    if (xTop in 0f..size.width) {
        return Offset(xTop, yTop)
    }

    // Intersección con borde derecho
    val tRight = size.width / dx
    val xRight = origin.x + dx * tRight
    val yRight = origin.y - dy * tRight

    return Offset(xRight, yRight)
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