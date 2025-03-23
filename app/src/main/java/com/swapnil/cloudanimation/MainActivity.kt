package com.swapnil.cloudanimation

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.swapnil.cloudanimation.presentation.clouds_for_phone.AnimatedCloudsScreen
import com.swapnil.cloudanimation.presentation.clouds_for_phone.AnimatedCloudsScreenLandscape
import com.swapnil.cloudanimation.presentation.clouds_for_phone.BottomClouds
import com.swapnil.cloudanimation.presentation.common_components.InfinityMotionMagnifyingGlass
import com.swapnil.cloudanimation.presentation.common_components.SearchingText
import com.swapnil.cloudanimation.presentation.clouds_for_phone.TopClouds
import com.swapnil.cloudanimation.presentation.clouds_for_tab.AnimatedCloudsScreenTab
import com.swapnil.cloudanimation.presentation.clouds_for_tab.AnimatedCloudsScreenTabLandscape
import com.swapnil.cloudanimation.presentation.screen.Screen1
import com.swapnil.cloudanimation.presentation.screen.Screen2
import com.swapnil.cloudanimation.presentation.ui.theme.CloudAnimationTheme
import com.swapnil.cloudanimation.presentation.ui.theme.Purple80
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CloudAnimationTheme {
                var cloudsVisibility by remember { mutableStateOf(false) }
                var magnifierVisibility by remember { mutableStateOf(false) }

                val configuration = LocalConfiguration.current
                val isPortrait = configuration.orientation == Configuration.ORIENTATION_PORTRAIT
                val coroutineScope = rememberCoroutineScope()
                var screen by remember { mutableStateOf("screen1") }
                var flag by remember { mutableStateOf(false) }

                // ✅ Improved Tablet Detection
                val isTab = configuration.screenWidthDp >= 600 && configuration.screenHeightDp >= 600

                /*LaunchedEffect(Unit) {
                    delay(500)
                    cloudsVisibility = true
                    delay(1000)
                    magnifierVisibility = true
                    delay(3000)
                    magnifierVisibility = false
                    cloudsVisibility = false
                }*/

                /*LaunchedEffect(Unit) {
                    cloudsVisibility = true
                    delay(2000)
                    cloudsVisibility = false
                    screen="screen1"
                }*/
                LaunchedEffect(flag) {
                    if(flag)
                    {
                        cloudsVisibility = true
                        delay(2000)
                        cloudsVisibility = false
                        flag = false
                    }
                }

                Box()
                {
                    when (screen) {
                        "screen1" -> Screen1 {
                            coroutineScope.launch {
                                flag=true
                                delay(1200)
                                screen = it
                            }
                        }
                        "screen2" -> Screen2 {
                            coroutineScope.launch {
                                flag=true
                                delay(2000)
                                screen = it
                            }
                        }
                    }
                    when {
                        isTab && isPortrait -> {
                            Log.d("currentStatus", "Tab Portrait ")
                            AnimatedCloudsScreenTab(
                                searchText = "Searching for Opponents...",
                                cloudVisibility = cloudsVisibility,
                                magnifyingGlassVisibility = magnifierVisibility
                            )
                        }
                        isTab && !isPortrait -> {
                            Log.d("currentStatus", "Tab Landscape ")
                            AnimatedCloudsScreenTabLandscape(
                                searchText = "Searching for Opponents...",
                                cloudVisibility = cloudsVisibility,
                                magnifyingGlassVisibility = magnifierVisibility
                            )
                        }
                        !isTab && isPortrait -> {
                            Log.d("currentStatus", "Phone Portrait ")
                            AnimatedCloudsScreen(
                                searchText = "Searching for Opponents...",
                                cloudVisibility = cloudsVisibility,
                                magnifyingGlassVisibility = magnifierVisibility
                            )
                        }
                        else -> {
                            Log.d("currentStatus", "Phone Landscape ")
                            AnimatedCloudsScreenLandscape(
                                searchText = "Searching for Opponents...",
                                cloudVisibility = cloudsVisibility,
                                magnifyingGlassVisibility = magnifierVisibility
                            )
                        }
                    }
                }
            }
        }
    }
}











