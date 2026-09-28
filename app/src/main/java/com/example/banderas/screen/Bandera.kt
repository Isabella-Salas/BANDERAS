package com.example.banderas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.banderas.ui.theme.BANDERASTheme
import com.example.banderas.R


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BANDERASTheme() {
                Surface (modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    BoxConstraint()
                }
            }
        }
    }
}

@Preview
@Composable
fun BoxConstraint() {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (Izqcolumn, Cencolumn, Dercolumn, ImgBox) = createRefs()
        val topGuide = createGuidelineFromTop(0.2f)

        Box(modifier = Modifier.size(100.dp).background(Color.Green).constrainAs(Izqcolumn) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(Cencolumn.start)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        })
        Box(modifier = Modifier.size(100.dp).background(Color.White).constrainAs(Cencolumn) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(Izqcolumn.end)
            end.linkTo(Dercolumn.start)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        })
        Box(modifier = Modifier.size(100.dp).background(Color.Red).constrainAs(Dercolumn) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(Cencolumn.end)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        })
        Box(modifier = Modifier.size(80.dp).clip(CircleShape).background(Color.Black).constrainAs(ImgBox) {
            top.linkTo(Cencolumn.top)
            bottom.linkTo(Cencolumn.bottom)
            start.linkTo(Cencolumn.start)
            end.linkTo(Cencolumn.end)
        })
    }
}