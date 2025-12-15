package org.example.project.core.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest

@Composable
fun <EFFECT> CollectEffect(effect: SharedFlow<EFFECT>, action: suspend (EFFECT) -> Unit) {
    LaunchedEffect(Unit) {
        effect.collectLatest(action)
    }
}