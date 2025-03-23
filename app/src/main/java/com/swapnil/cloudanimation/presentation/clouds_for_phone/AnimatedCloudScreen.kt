package com.swapnil.cloudanimation.presentation.clouds_for_phone

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.swapnil.cloudanimation.R
import com.swapnil.cloudanimation.presentation.clouds_for_tab.BottomCloudsTab
import com.swapnil.cloudanimation.presentation.clouds_for_tab.TopCloudsTab
import com.swapnil.cloudanimation.presentation.common_components.InfinityMotionMagnifyingGlass
import com.swapnil.cloudanimation.presentation.common_components.SearchingText
import com.swapnil.cloudanimation.presentation.ui.theme.Purple80
import kotlinx.coroutines.delay

@Composable
fun AnimatedCloudsScreen(
    cloudVisibility: Boolean,
    magnifyingGlassVisibility: Boolean,
    searchText: String,
    cloudAnimationDuration: Int = 1000,
    textAnimationDuration: Int = 1000,
    searchImage: Int = R.drawable.magnifying_glass
) {
    var cloudsVisibility by remember {
        mutableStateOf(false)
    }
    var magnifierVisibility by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(cloudVisibility) {
        cloudsVisibility = cloudVisibility
    }
    LaunchedEffect(magnifyingGlassVisibility) {
        magnifierVisibility = magnifyingGlassVisibility
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple80)
    ) {


        AnimatedVisibility(magnifierVisibility) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            )
        }
        AnimatedVisibility(
            visible = cloudsVisibility,
            enter = slideInVertically(
                initialOffsetY = { it }, // Starts from full height (bottom)
                animationSpec = tween(
                    durationMillis = cloudAnimationDuration, // Slightly increased duration for a smoother feel
                    easing = LinearOutSlowInEasing // Smoother easing for entering animation
                )
            ) + fadeIn(
                animationSpec = tween(
                    durationMillis = cloudAnimationDuration,
                    easing = LinearOutSlowInEasing
                )
            ),
            exit = slideOutVertically(
                targetOffsetY = { it }, // Moves to full height (bottom)
                animationSpec = tween(
                    durationMillis = cloudAnimationDuration,
                    easing = FastOutSlowInEasing // Keeps a natural exit motion
                )
            ) + fadeOut(
                animationSpec = tween(
                    durationMillis = cloudAnimationDuration,
                    easing = FastOutSlowInEasing
                )
            )
        ) {
            BottomClouds(modifier = Modifier.offset(x = -100.dp, y = -50.dp))
            BottomClouds(modifier = Modifier.offset(x = 100.dp, y = -50.dp))
            BottomClouds(modifier = Modifier.offset(x = -100.dp, y = 50.dp))
            BottomClouds(modifier = Modifier.offset(x = -100.dp, y = 50.dp))
            BottomClouds()
        }

        AnimatedVisibility(
            visible = cloudsVisibility,
            enter = slideInVertically(
                initialOffsetY = { -it }, // Starts from off-screen (top)
                animationSpec = tween(
                    durationMillis = cloudAnimationDuration,
                    easing = LinearOutSlowInEasing
                )
            ) + fadeIn(
                animationSpec = tween(
                    durationMillis = cloudAnimationDuration,
                    easing = LinearOutSlowInEasing
                )
            ),
            exit = slideOutVertically(
                targetOffsetY = { -it }, // Moves back to off-screen (top)
                animationSpec = tween(
                    durationMillis = cloudAnimationDuration,
                    easing = FastOutSlowInEasing
                )
            ) + fadeOut(
                animationSpec = tween(
                    durationMillis = cloudAnimationDuration,
                    easing = FastOutSlowInEasing
                )
            )
        ) {
            TopClouds(modifier = Modifier.offset(x = -100.dp, y = -50.dp))
            TopClouds(modifier = Modifier.offset(x = 100.dp, y = -50.dp))
            TopClouds()
        }
        AnimatedVisibility(
            visible = magnifierVisibility,
            enter = fadeIn(animationSpec = tween(textAnimationDuration)),  // Smooth fade-in over 1 second
            exit = fadeOut(animationSpec = tween(textAnimationDuration))   // Smooth fade-out over 1 second
        ) {
            InfinityMotionMagnifyingGlass(searchImage)
            SearchingText(searchText)
        }
    }
}