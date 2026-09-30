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
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import kotlinx.coroutines.NonDisposableHandle
import kotlinx.coroutines.NonDisposableHandle.parent


@Composable
fun BanderaScreen(modifier: Modifier){
    ConstraintLayout(modifier = modifier.fillMaxSize()){
        val (c1,c2,c3) = createRefs()
        Box(modifier = Modifier.background(Color.Black).constrainAs(c1) {
            top.linkTo(parent.top)
            bottom.linkTo(c2.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        })
        Box(modifier = Modifier.background(Color.Red).constrainAs(c2) {
            top.linkTo(c1.bottom)
            bottom.linkTo(c3.top)
            start.linkTo( parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.percent(0.5f)
        })
        Box(modifier = Modifier.size(100.dp).background(Color.Yellow).constrainAs(c3) {
            top.linkTo(c2.bottom)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        })

    }
}
@Preview(showBackground = true)
@Composable
fun BanderaPreview(){
    BanderaScreen(modifier = Modifier,)
}