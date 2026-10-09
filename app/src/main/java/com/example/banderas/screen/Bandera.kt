package  com.example.banderas.screen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout



@Composable
fun BanderaScreen(modifier: Modifier = Modifier){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) { }
}


@Preview(showBackground = true)
@Composable
fun BanderaPreview(){
    BanderaScreen(modifier = Modifier,)
}