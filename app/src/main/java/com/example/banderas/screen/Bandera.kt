package  com.example.banderas.screen

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
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import com.example.banderas.R


@Composable
fun BanderaScreen(modifier: Modifier = Modifier){
    ConstraintLayout(modifier = modifier.fillMaxSize()){
        val (c1,c2,c3) = createRefs();

        Box(modifier = Modifier.size(100.dp).background(colorResource(id = R.color.)).constrainAs(c1) {
            top.linkTo(parent.top)
            bottom.linkTo(c2.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints

        })
        Box(modifier = Modifier.size(100.dp).background(Color.White).constrainAs(c2) {
            top.linkTo(c1.bottom)
            bottom.linkTo(c3.top)
            start.linkTo( parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        })
        Box(modifier = Modifier.size(100.dp).background(Color.Red).constrainAs(c3) {
            top.linkTo(c2.bottom)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        })
        Image(
            painter = painterResource(id = R.drawable.spain),
            contentDescription = "Escudo España",
            modifier = Modifier
                .size(100.dp)
                .constrainAs(spain) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    horizontalBias = 0.2f // Ubicación del escudo hacia la izquierda
                }
        )
    }
}
@Preview(showBackground = true)
@Composable
fun BanderaPreview(){
    BanderaScreen(modifier = Modifier)
}