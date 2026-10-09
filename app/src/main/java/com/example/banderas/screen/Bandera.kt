package  com.example.banderas.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout



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
        ){
            val w = size.width
            val h = size.height

            val verticalWidth = w * 0.2f
            val verticalHeight = h * 0.62f

            drawRect(
                color = Color.White,
                topLeft = Offset(
                    x = (w - verticalWidth) / 2f,   // centrado
                    y = (h - verticalHeight) / 2f
                ),
                size = Size(verticalWidth, verticalHeight)
            )

            val horizontalWidth = w * 0.62f
            val horizontalHeight = h * 0.2f

            drawRect(
                color = Color.White,
                topLeft = Offset(
                    x = (w - horizontalWidth) / 2f, // centrado
                    y = (h - horizontalHeight) / 2f
                ),
                size = Size(horizontalWidth, horizontalHeight)
            )

        }
    }
}


@Preview(showBackground = true)
@Composable
fun BanderaPreview(){
    BanderaScreen(modifier = Modifier,)
}