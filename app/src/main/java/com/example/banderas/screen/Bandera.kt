package  com.example.banderas.screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun BanderaScreen(modifier: Modifier = Modifier){

    val Rojo = Color(0xFFE53935)
    val Verde = Color(0xFF43A047)
    val Blanco = Color(0xFFFFFFFF)
    val pixeleles = 23.dp

    Column(modifier = modifier){
        Row{
            Box(Modifier.size(pixeleles).background(Blanco))
            Box(Modifier.size(pixeleles).background(Blanco))
            Box(Modifier.size(pixeleles).background(Blanco))
            Box(Modifier.size(pixeleles).background(Blanco))
            Box(Modifier.size(pixeleles).background(Verde))
            Box(Modifier.size(pixeleles).background(Blanco))
            Box(Modifier.size(pixeleles).background(Blanco))
            Box(Modifier.size(pixeleles).background(Blanco))
            Box(Modifier.size(pixeleles).background(Blanco))

        }
        Row{
            Box(Modifier.size(pixeleles).background(Blanco))
            Box(Modifier.size(pixeleles).background(Blanco))
            Box(Modifier.size(pixeleles).background(Verde))
            Box(Modifier.size(pixeleles).background(Verde))
            Box(Modifier.size(pixeleles).background(Verde))
            Box(Modifier.size(pixeleles).background(Verde))
            Box(Modifier.size(pixeleles).background(Verde))
            Box(Modifier.size(pixeleles).background(Blanco))
            Box(Modifier.size(pixeleles).background(Blanco))

        }
        Row{
            Box(Modifier.size(pixeleles).background(Verde))
            Box(Modifier.size(pixeleles).background(Verde))
            Box(Modifier.size(pixeleles).background(Verde))
            Box(Modifier.size(pixeleles).background(Verde))
            Box(Modifier.size(pixeleles).background(Verde))
            Box(Modifier.size(pixeleles).background(Verde))
            Box(Modifier.size(pixeleles).background(Verde))
            Box(Modifier.size(pixeleles).background(Verde))
            Box(Modifier.size(pixeleles).background(Verde))
        }
        Row{
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Verde))
            Box(Modifier.size(pixeleles).background(Verde))
            Box(Modifier.size(pixeleles).background(Verde))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
        }
        Row{
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
        }
        Row{
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Blanco))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
        }
        Row{
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Blanco))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
        }
        Row{
            Box(Modifier.size(pixeleles).background(Blanco))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Blanco))
        }
        Row{
            Box(Modifier.size(pixeleles).background(Blanco))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Blanco))
        }
        Row{
            Box(Modifier.size(pixeleles).background(Blanco))
            Box(Modifier.size(pixeleles).background(Blanco))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Blanco))
            Box(Modifier.size(pixeleles).background(Blanco))
        }
        Row{
            Box(Modifier.size(pixeleles).background(Blanco))
            Box(Modifier.size(pixeleles).background(Blanco))
            Box(Modifier.size(pixeleles).background(Blanco))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Rojo))
            Box(Modifier.size(pixeleles).background(Blanco))
            Box(Modifier.size(pixeleles).background(Blanco))
            Box(Modifier.size(pixeleles).background(Blanco))
        }


    }

}


@Preview(showBackground = true)
@Composable
fun BanderaPreview(){
    BanderaScreen(modifier = Modifier,)
}