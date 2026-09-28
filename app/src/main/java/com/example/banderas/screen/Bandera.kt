package  com.example.banderas.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.banderas.BanderaMexico
import com.example.banderas.ui.theme.BANDERASTheme



@Composable
fun BanderasScreen(modifier: Modifier){
    ConstraintLayout(modifier = modifier){
        val (c1,c2,c3) = createRefs();

        Box(modifier = Modifier.background(Color.Red).constraintAs(c1)){
            start.linkTo(parent.start)
            end.linkTo(parent.end)

            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)

        }
    }
}
@Preview(showBackground = true)
@Composable
fun BanderaScreenPreview() {
    BANDERASTheme() {
        BanderaScreenPreview(modifier = Modifier.fillMaxSize())
    }
}