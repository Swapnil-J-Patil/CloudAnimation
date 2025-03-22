package com.swapnil.cloudanimation.presentation.common_components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import com.swapnil.cloudanimation.presentation.ui.theme.SupercellMagicFont

@Composable
fun SearchingText(
    text: String,
    fontSize: Int = 16,
    fontColor: Color = Color(0xFFEFDA6C),
    modifier: Modifier = Modifier
        .fillMaxSize()
        .padding(top = 60.dp),
    fontWeight: FontWeight = FontWeight.Bold,
    alignment: Alignment = Alignment.Center,
    fontFamily: FontFamily = SupercellMagicFont,
    shadowColor: Color = Color.Black,
    outlineColor: Color = Color.Gray,
    borderStrokeWidth: Float = 8f,
    textAlign: TextAlign = TextAlign.Center,
    blurRadius: Float = 10f
) {

    Box(
        modifier = modifier,
        contentAlignment = alignment
    ) {
        // Gray border (outline effect)
        Text(
            text = text,
            style = TextStyle(
                fontSize = fontSize.sp,
                fontWeight = fontWeight,
                fontFamily = fontFamily,
                color = outlineColor, // Gray outline color
                shadow = Shadow(
                    color = shadowColor,
                ),
                drawStyle = Stroke(width = borderStrokeWidth) // Border effect
            ),
            textAlign = textAlign,
        )

        // Golden gradient text
        Text(
            text = text,
            style = TextStyle(
                fontSize = fontSize.sp,
                fontWeight = fontWeight,
                fontFamily = fontFamily,
                color = fontColor // Gold
                ,
                shadow = Shadow(
                    color = shadowColor,
                    blurRadius = blurRadius
                )
            ),
            textAlign = textAlign,
        )
    }
}

