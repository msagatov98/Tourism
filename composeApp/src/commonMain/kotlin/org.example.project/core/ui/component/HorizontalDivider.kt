package org.example.project.core.ui.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun RowScope.HorizontalDivider(
    weight: Float = 1F,
    thickness: Dp = 0.5.dp,
    color: Color = Color(0xFF3C3C43).copy(alpha = 0.6F),
) {
    HorizontalDivider(
        modifier = Modifier.weight(weight),
        thickness = thickness,
        color = color,
    )
}

@Composable
fun HorizontalDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = 0.5.dp,
    color: Color = Color(0xFF3C3C43).copy(alpha = 0.6F),
) {
    androidx.compose.material3.HorizontalDivider(
        modifier = modifier,
        thickness = thickness,
        color = color,
    )
}