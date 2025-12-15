package org.example.project.core.ui.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Spacer(width: Dp = 0.dp, height: Dp = 0.dp) {
    Spacer(modifier = Modifier.size(width, height))
}

@Composable
fun ColumnScope.Spacer(weight: Float) {
    Spacer(modifier = Modifier.weight(weight))
}
