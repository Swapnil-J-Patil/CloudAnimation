package com.swapnil.cloudanimation.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.swapnil.cloudanimation.presentation.ui.theme.Pink40
import com.swapnil.cloudanimation.presentation.ui.theme.Purple80

@Composable
fun Screen1(
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit
) {
    Box(modifier = modifier.fillMaxSize()
        .background(Purple80),
        contentAlignment = Alignment.Center)
    {
        Text(
            text = "This is Screen 1",
            style = MaterialTheme.typography.displayMedium,
            color = Color.White,
        )
        Button(onClick = {
            onClick("screen2")
        },
            modifier = Modifier.padding(top=150.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Pink40)
        ) {
            Text(
                text = "Go to screen 2",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
            )
        }
    }
}