package com.swapnil.cloudanimation.presentation.common_components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import android.graphics.PathMeasure
import androidx.compose.foundation.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp

@Composable
fun InfinityMotionMagnifyingGlass(
    image: Int,
    motionWidth: Float = 150f,
    motionHeight: Float = 120f,
    centerOfMotionX: Float = 0f,
    centerOfMotionY: Float = 0f,
    canvasWidth: Dp =300.dp,
    canvasHeight: Dp =150.dp,
    imageWidth: Dp =70.dp,
    imageHeight: Dp = 70.dp,
    animationDuration: Int = 4000,
    modifier: Modifier = Modifier.fillMaxSize(),
    alignment: Alignment =Alignment.Center

) {
    val animProgress = remember { Animatable(0f) }
    val pathMeasure = remember { PathMeasure() }
    val androidPath = remember { android.graphics.Path() }

    // Start animation
    LaunchedEffect(Unit) {
        animProgress.animateTo(
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = animationDuration, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            )
        )
    }

    // Create the infinity symbol path using a parametric equation
    val width = motionWidth

    androidPath.reset()
    for (t in 0..360 step 5) {
        val angle = Math.toRadians(t.toDouble())
        val x = (width / 2 * Math.cos(angle) / (1 + Math.sin(angle) * Math.sin(angle))).toFloat()
        val y = (motionHeight / 2 * Math.cos(angle) * Math.sin(angle) / (1 + Math.sin(angle) * Math.sin(angle))).toFloat()
        if (t == 0) androidPath.moveTo(centerOfMotionX + x, centerOfMotionY + y)
        else androidPath.lineTo(centerOfMotionX + x, centerOfMotionY + y)
    }
    androidPath.close()
    pathMeasure.setPath(androidPath, true)

    // Get position along the path
    val position = FloatArray(2)
    pathMeasure.getPosTan(pathMeasure.length * animProgress.value, position, null)

    Box(
        modifier = modifier,
        contentAlignment = alignment
    ) {
        Canvas(modifier = Modifier.size(canvasWidth, canvasHeight)) {
            val composePath = Path().apply {
                reset()
                androidPath.computeBounds(android.graphics.RectF(), true)
                moveTo(0f, 0f)

                val pathMeasure = PathMeasure(androidPath, false)
                val pathLength = pathMeasure.length
                val segment = android.graphics.Path()

                // Convert android.graphics.Path to androidx.compose.ui.graphics.Path
                pathMeasure.getSegment(0f, pathLength, segment, true)
                segment.toComposePath()?.let { addPath(it) }
            }

            drawPath(
                path = composePath,
                color = Color.Gray,
                style = Stroke(2.dp.toPx())
            )
        }

        Image(
            painter = painterResource(id = image),
            contentDescription = "Magnifying Glass",
            modifier = Modifier
                .size(imageWidth,imageHeight)
                .offset(x = position[0].dp, y = position[1].dp)
        )
    }
}


fun android.graphics.Path.toComposePath(): Path? {
    val composePath = Path()
    val pathMeasure = PathMeasure(this, false)
    val length = pathMeasure.length
    val tempPath = android.graphics.Path()

    pathMeasure.getSegment(0f, length, tempPath, true)
    val bounds = android.graphics.RectF()
    tempPath.computeBounds(bounds, true)

    return composePath.apply {
        moveTo(bounds.left, bounds.top)
        addPath(tempPath)
    }
}



