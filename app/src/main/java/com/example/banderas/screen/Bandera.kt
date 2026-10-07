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

        val amarillo = Color(0xFFFFCC00)
        val naranja =  Color(0xFFFF6600)
        val height = size.height
        val width = size.width

        // Triángulo naranja
        drawRect(color = amarillo)


        val blackPath = Path().apply {
            moveTo(0f,size.height)
            lineTo(size.width,0f)
            lineTo(size.width, size.height)
            close()
        }
        drawPath(blackPath, naranja)

        val strokeDragon = height * 0.08f
        val colorDragon = Color.White

        val p1 = Offset(width * 0.30f, height * 0.65f)
        val p2 = Offset(width * 0.35f, height * 0.45f)
        val p3 = Offset(width * 0.45f, height * 0.55f)
        val p4 = Offset(width * 0.55f, height * 0.40f)
        val p5 = Offset(width * 0.65f, height * 0.50f)
        val p6 = Offset(width * 0.75f, height * 0.40f)

        drawLine(colorDragon, p1, p2, strokeWidth = strokeDragon)
        drawLine(colorDragon, p2, p3, strokeWidth = strokeDragon)
        drawLine(colorDragon, p3, p4, strokeWidth = strokeDragon)
        drawLine(colorDragon, p4, p5, strokeWidth = strokeDragon)
        drawLine(colorDragon, p5, p6, strokeWidth = strokeDragon)

        drawLine(
            colorDragon,
            p6,
            Offset(width * 0.78f, height * 0.38f),
            strokeWidth = strokeDragon * 0.4f
        )

        // 4. Las 4 "estrellas" (las simularemos con círculos amarillos en los vértices) -> me apoye de la IA
        val colorEstrella = Color(0xFFFFCC00)
        val radioEstrella = height * 0.03f

        // Colocamos las estrellas dentro o cerca de los "codos" del dragón > me apoye de la IA con las figuras
        drawCircle(colorEstrella, radius = radioEstrella, center = Offset(width * 0.35f, height * 0.48f))
        drawCircle(colorEstrella, radius = radioEstrella, center = Offset(width * 0.45f, height * 0.52f))
        drawCircle(colorEstrella, radius = radioEstrella, center = Offset(width * 0.55f, height * 0.43f))
        drawCircle(colorEstrella, radius = radioEstrella, center = Offset(width * 0.65f, height * 0.47f))

    }


}


@Preview(showBackground = true)
@Composable
fun BanderaPreview(){
    BanderaScreen(modifier = Modifier,)
}