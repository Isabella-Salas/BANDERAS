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
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.geometry.Offset
import com.example.banderas.R
import kotlinx.coroutines.NonDisposableHandle.parent



@Composable
fun BanderaScreen(modifier: Modifier){
    Canvas(modifier = modifier.fillMaxWidth().aspectRatio(2f)) {
        drawRect(color = Color(0xFFE30A17))
        val cy = size.height / 2f
        val rOut = size.height * 0.30f
        drawCircle(color = Color.White, radius = rOut,
            center = Offset(size.width * 0.18f, cy))
        drawCircle(color = Color(0xFFE30A17), radius = size.height * 0.24f,
            center = Offset(size.width * 0.18f + size.height * 0.09f, cy))

    }

}
@Preview(showBackground = true)
@Composable
fun BanderaPreview(){
    BanderaScreen(modifier = Modifier,)
}