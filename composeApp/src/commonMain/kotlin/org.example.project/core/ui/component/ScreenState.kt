package org.example.project.core.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

sealed interface ScreenState {
    data object Empty : ScreenState
    data object Failure : ScreenState
    data object Loading : ScreenState
    data object Success : ScreenState
}


@Composable
fun ScreenStateWidget(
    screenState: ScreenState,
    loadingContent: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    when (screenState) {
        ScreenState.Empty -> EmptyContent()
        ScreenState.Failure -> FailureContent()
        ScreenState.Loading -> loadingContent()
        is ScreenState.Success -> content()
    }
}

@Composable
private fun EmptyContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text("empty")
    }
}

@Composable
private fun FailureContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text("Error")
    }
}
