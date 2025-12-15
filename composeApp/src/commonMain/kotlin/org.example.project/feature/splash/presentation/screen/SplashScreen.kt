package org.example.project.feature.splash.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.coroutines.delay
import org.example.project.core.ui.screen.Screen
import org.example.project.feature.splash.presentation.navigation.SplashNavigator
import org.jetbrains.compose.resources.painterResource
import tourism.composeapp.generated.resources.Res
import tourism.composeapp.generated.resources.splash_background
import tourism.composeapp.generated.resources.splash_foreground

fun NavGraphBuilder.splashScreen(navigator: SplashNavigator) {
    composable<Screen.Splash> {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(Res.drawable.splash_background),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
            )
            Image(
                painter = painterResource(Res.drawable.splash_foreground),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth(0.65F)
                    .align(Alignment.TopCenter)
                    .padding(top = 96.dp),
            )
        }

        LaunchedEffect(Unit) {
            delay(2000L)
            navigator.toStart()
        }
    }
}
