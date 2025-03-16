package com.swapnil.cloudanimation

import android.app.ActivityManager
import android.content.Context
import android.content.pm.ConfigurationInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.getSystemService
import com.swapnil.cloudanimation.ui.theme.CloudAnimationTheme
import com.swapnil.cloudanimation.ui.theme.Pink80
import com.swapnil.cloudanimation.ui.theme.Purple80
import com.swapnil.cloudanimation.ui.theme.PurpleGrey40
import kotlinx.coroutines.delay
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CloudAnimationTheme {

                AnimatedCloudsScreen()
            }
        }
    }
}

@Composable
fun AnimatedCloudsScreen() {
    var visibility by remember {
        mutableStateOf(false)
    }
    var flag by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(Unit) {
        delay(500)
        flag=true
        delay(100)
        visibility = true
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple80)
    ) {

        AnimatedVisibility(
            visible = visibility,
            enter = slideInVertically(
                initialOffsetY = { it }, // Starts from full height (bottom)
                animationSpec = tween(
                    durationMillis = 1000, // Slightly increased duration for a smoother feel
                    easing = LinearOutSlowInEasing // Smoother easing for entering animation
                )
            ) + fadeIn(
                animationSpec = tween(
                    durationMillis = 1000,
                    easing = LinearOutSlowInEasing
                )
            ),
            exit = slideOutVertically(
                targetOffsetY = { it }, // Moves to full height (bottom)
                animationSpec = tween(
                    durationMillis = 1000,
                    easing = FastOutSlowInEasing // Keeps a natural exit motion
                )
            ) + fadeOut(
                animationSpec = tween(
                    durationMillis = 1000,
                    easing = FastOutSlowInEasing
                )
            )
        ) {
            BottomClouds()
        }

        AnimatedVisibility(
            visible = visibility,
            enter = slideInVertically(
                initialOffsetY = { -it }, // Starts from off-screen (top)
                animationSpec = tween(
                    durationMillis = 1000,
                    easing = LinearOutSlowInEasing
                )
            ) + fadeIn(
                animationSpec = tween(
                    durationMillis = 1000,
                    easing = LinearOutSlowInEasing
                )
            ),
            exit = slideOutVertically(
                targetOffsetY = { -it }, // Moves back to off-screen (top)
                animationSpec = tween(
                    durationMillis = 1000,
                    easing = FastOutSlowInEasing
                )
            ) + fadeOut(
                animationSpec = tween(
                    durationMillis = 1000,
                    easing = FastOutSlowInEasing
                )
            )
        ) {
            TopClouds()
        }
    }
}









