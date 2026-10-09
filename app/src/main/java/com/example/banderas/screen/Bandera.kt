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
            val cy = size.height / 2f
            val rOut = size.height * 0.30f
            drawCircle(color = Color.White, radius = rOut,
                center = Offset(size.width * 0.38f, cy))
            drawCircle(color = Color(0xFFE30A17), radius = size.height * 0.24f,
                center = Offset(size.width * 0.38f + size.height * 0.09f, cy))

        }
    }
}


@Preview(showBackground = true)
@Composable
fun BanderaPreview(){
    BanderaScreen(modifier = Modifier,)
}