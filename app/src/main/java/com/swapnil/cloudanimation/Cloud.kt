package com.swapnil.cloudanimation

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun Cloud(modifier: Modifier = Modifier, id: Int) {
    Image(
        painter = painterResource(id = id),
        contentDescription = "Right Cloud",
        modifier = modifier,
        contentScale = ContentScale.FillBounds
    )
}