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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import com.example.banderas.R
import kotlinx.coroutines.NonDisposableHandle.parent



val RombosShape = GenericShape { size, _ ->
    moveTo(size.width / 2f, 0f)
    lineTo(size.width, size.height / 2f)
    lineTo(size.width / 2f, size.height)
    lineTo(0f, size.height / 2f)
    close()
}

@Composable
fun BanderaScreen(modifier: Modifier){
    ConstraintLayout(modifier = modifier.fillMaxSize()){
        val (c1,c2,c3,circle,rombo) = createRefs();

        Box(modifier = Modifier.size(100.dp).background(colorResource(id = R.color.verde_brasiiil)).constrainAs(c1) {
            top.linkTo(parent.top)
            bottom.linkTo(c2.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints

        })
        Box(modifier = Modifier.size(100.dp).background(colorResource(id = R.color.verde_brasiiil)).constrainAs(c2) {
            top.linkTo(c1.bottom)
            bottom.linkTo(c3.top)
            start.linkTo( parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        })
        Box(modifier = Modifier.size(100.dp).background(colorResource(id = R.color.verde_brasiiil)).constrainAs(c3) {
            top.linkTo(c2.bottom)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        })
        Box(modifier = Modifier.size(100.dp).clip(RombosShape).background(colorResource(id = R.color.yellow_brasil)).constrainAs(rombo) {
            top.linkTo(c1.bottom)
            bottom.linkTo(c3.top)
            start.linkTo( parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        })
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(colorResource(id = R.color.azul_brasil))
                .constrainAs(circle) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )



    }
}
@Preview(showBackground = true)
@Composable
fun BanderaPreview(){
    BanderaScreen(modifier = Modifier,)
}