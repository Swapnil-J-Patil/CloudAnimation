package com.swapnil.cloudanimation.presentation.clouds_for_tab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.swapnil.cloudanimation.R
import com.swapnil.cloudanimation.presentation.common_components.Cloud

@Composable
fun TopCloudsTab(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Transparent),
        contentAlignment = Alignment.TopCenter
    ) {
        Cloud(modifier = Modifier.fillMaxWidth(0.5f)
            .height(300.dp)
            .offset(x=60.dp,y=150.dp),
            id = R.drawable.fog
        )
        Cloud(modifier = Modifier.fillMaxWidth(0.5f)
            .height(300.dp)
            .offset(x=-100.dp,y=150.dp),
            id = R.drawable.fog
        )
        Cloud(modifier = Modifier.fillMaxWidth(0.5f)
            .height(300.dp)
            .offset(x=60.dp,y=50.dp),
            id = R.drawable.fog
        )
        Cloud(modifier = Modifier.fillMaxWidth(0.5f)
            .height(300.dp)
            .offset(x=-100.dp,y=50.dp),
            id = R.drawable.fog
        )
        Cloud(modifier = Modifier.fillMaxWidth(0.5f)
            .height(300.dp)
            .offset(x=80.dp,y=-150.dp),
            id = R.drawable.fog
        )
        Cloud(modifier = Modifier.fillMaxWidth(0.5f)
            .height(300.dp)
            .offset(x=-100.dp,y=-150.dp),
            id = R.drawable.fog
        )
        Cloud(modifier = Modifier.fillMaxWidth(0.5f)
            .height(300.dp)
            .offset(x=80.dp,y=-50.dp),
            id = R.drawable.fog
        )
        Cloud(modifier = Modifier.fillMaxWidth(0.5f)
            .height(300.dp)
            .offset(x=-100.dp,y=-50.dp),
            id = R.drawable.fog
        )
        Cloud(modifier = Modifier.fillMaxWidth(0.5f)
            .height(320.dp)
            .rotate(180f)
            .offset(x=-60.dp,y=-160.dp),
            id = R.drawable.cloud
        )
        Cloud(modifier = Modifier.fillMaxWidth(0.5f)
            .height(320.dp)
            .rotate(180f)
            .offset(x=60.dp,y=-180.dp),
            id = R.drawable.cloud
        )

        Cloud(modifier = Modifier.fillMaxWidth(0.5f)
            .height(300.dp)
            .rotate(180f)
            .offset(x=-60.dp,y=-40.dp),
            id = R.drawable.cloud
        )
        Cloud(modifier = Modifier.fillMaxWidth(0.5f)
            .height(300.dp)
            .rotate(180f)
            .offset(x=60.dp,y=-70.dp),
            id = R.drawable.cloud
        )
        Cloud(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(200.dp)
                .rotate(180f)
                .offset(x = -75.dp, y = 40.dp),
            id = R.drawable.cloud
        )
        Cloud(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(250.dp)
                .rotate(180f)
                .offset(x = 75.dp, y = 40.dp),
            id = R.drawable.cloud
        )

        Cloud(modifier = Modifier.fillMaxWidth(0.5f)
            .height(300.dp)
            .offset(x=80.dp,y=240.dp),
            id = R.drawable.fog
        )
        Cloud(modifier = Modifier.fillMaxWidth(0.5f)
            .height(300.dp)
            .offset(x=-80.dp,y=280.dp),
            id = R.drawable.fog
        )
    }
}