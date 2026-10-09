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
import androidx.compose.foundation.rememberPlatformOverscrollFactory
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import kotlin.math.cos
import kotlin.math.sin


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
                .width(240.dp)
                .height(290.dp)
        ) {
            val azulBorde = Color(0XFF003893)
            val mid = size.height / 2f
            val triangSuperior = Path().apply {
                moveTo(0f, 0f)
                lineTo(size.width * 0.92f, size.height * 0.40f)
                lineTo(0f, mid)
                close()
            }
            val trianguloInfeior = Path().apply {
                moveTo(0f, mid)
                lineTo(size.width * 0.92f, mid)
                lineTo(0f, size.height)
                close()
            }
            drawPath(triangSuperior, color = azulBorde)
            drawPath(trianguloInfeior, color = azulBorde)
            // Repetir con un triangulo interior mas pequeno en carmesi (margen ~16px)

            val rojoCarmesi = Color(0xFFDC143C)
            val scale = 0.85f
            val trianguloInterior1 = Path().apply {
                moveTo(0f, 0f)                          // mismo punto donde termina el azul
                lineTo(size.width * 0.92f * scale, size.height * 0.42f * scale)
                lineTo(0f, mid * scale)                 // esquina inferior izquierda
                close()
            }
            val trianguloInterior2 = Path().apply {
                moveTo(0f, mid)
                lineTo(size.width * 0.92f * scale, mid)
                lineTo(0f, size.height)
                close()
            }

            drawPath(trianguloInterior1, color = rojoCarmesi)
            drawPath(trianguloInterior2, color = rojoCarmesi)


            val cxMoon = size.width * 0.28f
            val cyMoon = size.height * 0.22f

            // círculo grande blanco
            drawCircle(
                color = Color.White,
                radius = size.height * 0.10f,
                center = Offset(cxMoon, cyMoon)
            )

            // círculo rojo que recorta la luna
            drawCircle(
                color = rojoCarmesi,
                radius = size.height * 0.08f,
                center = Offset(cxMoon + size.height * 0.04f, cyMoon)
            )

            // pequeño círculo blanco arriba
            drawCircle(
                color = Color.White,
                radius = size.height * 0.03f,
                center = Offset(cxMoon, cyMoon - size.height * 0.08f)
            )
            val cxSun = size.width * 0.30f
            val cySun = size.height * 0.72f

            // círculo central
            drawCircle(
                color = Color.White,
                radius = size.height * 0.05f,
                center = Offset(cxSun, cySun)
            )

            // rayos del sol
            val rayLength = size.height * 0.15f
            val rayCount = 12
            for (i in 0 until rayCount) {
                val angle = (i * (360f / rayCount)) * (Math.PI / 180f)
                val x2 = cxSun + rayLength * cos(angle).toFloat()
                val y2 = cySun + rayLength * sin(angle).toFloat()
                drawLine(
                    color = Color.White,
                    start = Offset(cxSun, cySun),
                    end = Offset(x2, y2),
                    strokeWidth = size.height * 0.01f
                )
            }
            // Repetir la misma logica para el triangulo inferior -> ya lo hice, lo hice abajo del ptro
            // Luna: drawCircle blanco + drawCircle carmesi desplazado (igual que Turquia)
            // Sol: GenericShape de 12 puntas con seno/coseno
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BanderaPreview(){
    BanderaScreen(modifier = Modifier,)
}