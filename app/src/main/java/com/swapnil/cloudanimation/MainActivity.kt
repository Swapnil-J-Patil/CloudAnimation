package com.swapnil.cloudanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.swapnil.cloudanimation.presentation.clouds_for_phone.AnimatedCloudsScreen
import com.swapnil.cloudanimation.presentation.clouds_for_phone.BottomClouds
import com.swapnil.cloudanimation.presentation.common_components.InfinityMotionMagnifyingGlass
import com.swapnil.cloudanimation.presentation.common_components.SearchingText
import com.swapnil.cloudanimation.presentation.clouds_for_phone.TopClouds
import com.swapnil.cloudanimation.presentation.clouds_for_tab.AnimatedCloudsScreenTab
import com.swapnil.cloudanimation.presentation.ui.theme.CloudAnimationTheme
import com.swapnil.cloudanimation.presentation.ui.theme.Purple80
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CloudAnimationTheme {
                var cloudsVisibility by remember {
                    mutableStateOf(false)
                }
                var magnifierVisibility by remember {
                    mutableStateOf(false)
                }
                val configuration = LocalConfiguration.current
                val isTab = configuration.screenWidthDp.dp > 600.dp

                LaunchedEffect(Unit) {
                    delay(500)
                    cloudsVisibility = true
                    delay(1000)
                    magnifierVisibility = true
                    delay(3000)
                    magnifierVisibility = false
                    cloudsVisibility = false
                }
                if(isTab)
                {
                    AnimatedCloudsScreenTab(
                        searchText = "Searching for Opponents...",
                        cloudVisibility = cloudsVisibility,
                        magnifyingGlassVisibility = magnifierVisibility
                    )
                }
                else{
                    AnimatedCloudsScreen(
                        searchText = "Searching for Opponents...",
                        cloudVisibility = cloudsVisibility,
                        magnifyingGlassVisibility = magnifierVisibility
                    )
                }
            }
        }
    }
}











