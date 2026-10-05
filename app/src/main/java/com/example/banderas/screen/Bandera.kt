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



@Composable
fun BanderaScreen(modifier: Modifier){
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .background(Color(0xFFD52B1E))
    ) {
        Box(
            Modifier
                .align(Alignment.Center)
                .fillMaxWidth(0.2f)
                .fillMaxHeight(0.62f)
                .background(Color.White)
        )
        Box(
            Modifier
                .align(Alignment.Center)
                .fillMaxHeight(0.2f)
                .fillMaxWidth(0.62f)
                .background(Color.White)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun BanderaPreview(){
    BanderaScreen(modifier = Modifier,)
}