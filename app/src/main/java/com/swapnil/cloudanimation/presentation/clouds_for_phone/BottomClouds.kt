package com.swapnil.cloudanimation.presentation.clouds_for_phone

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.swapnil.cloudanimation.R
import com.swapnil.cloudanimation.presentation.common_components.Cloud

@Composable
fun BottomClouds(
    modifier: Modifier = Modifier,
    fogImage: Int = R.drawable.fog,
    cloudImage: Int = R.drawable.cloud
    ) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Transparent),
        contentAlignment = Alignment.BottomCenter
    ) {

        Cloud(modifier = Modifier.fillMaxWidth()
            .height(300.dp)
            .offset(x=-80.dp,y=-120.dp),
            id = fogImage
        )
        Cloud(modifier = Modifier.fillMaxWidth()
            .height(300.dp)
            .offset(x=-80.dp,y=-40.dp),
            id = fogImage
        )
        Cloud(modifier = Modifier.fillMaxWidth()
            .height(300.dp)
            .offset(x=120.dp,y=-40.dp),
            id = fogImage
        )
        Cloud(modifier = Modifier.fillMaxWidth()
            .height(300.dp)
            .offset(x=-80.dp,y=60.dp),
            id = fogImage
        )
        Cloud(modifier = Modifier.fillMaxWidth()
            .height(300.dp)
            .offset(x=120.dp,y=60.dp),
            id = fogImage
        )
        Cloud(modifier = Modifier.fillMaxWidth()
            .height(320.dp)
            .offset(x=60.dp,y=-200.dp),
            id = cloudImage
        )
        Cloud(modifier = Modifier.fillMaxWidth()
            .height(320.dp)
            .offset(x=-60.dp,y=-210.dp),
            id = cloudImage
        )
        Cloud(modifier = Modifier.fillMaxWidth()
            .height(300.dp)
            .offset(x=60.dp,y=-70.dp),
            id = cloudImage
        )
        Cloud(modifier = Modifier.fillMaxWidth()
            .height(300.dp)
            .offset(x=-60.dp,y=-70.dp),
            id = cloudImage
        )
        Cloud(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .offset(x = -75.dp, y = 25.dp),
            id = cloudImage
        )
        Cloud(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .offset(x = 75.dp, y = 60.dp),
            id = cloudImage
        )
        Cloud(modifier = Modifier.fillMaxWidth()
            .height(300.dp)
            .offset(x=60.dp,y=-300.dp),
            id = fogImage
        )
        Cloud(modifier = Modifier.fillMaxWidth()
            .height(300.dp)
            .offset(x=-60.dp,y=-300.dp),
            id = fogImage
        )
    }
}