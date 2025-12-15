package org.example.project.feature.start.presentation.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.example.project.core.ui.component.Button
import org.example.project.core.ui.component.Spacer
import org.example.project.core.ui.screen.Screen
import org.example.project.core.ui.theme.Orange
import org.example.project.core.ui.theme.Pink
import org.example.project.feature.start.presentation.navigation.StartNavigator
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import tourism.composeapp.generated.resources.Res
import tourism.composeapp.generated.resources.image_air_balloon
import tourism.composeapp.generated.resources.splash_foreground
import tourism.composeapp.generated.resources.start_screen_create_account
import tourism.composeapp.generated.resources.start_screen_login

fun NavGraphBuilder.startScreen(
    navigator: StartNavigator,
) {
    composable<Screen.Start> {
        StartScreen { action ->
            when (action) {
                StartAction.OnLoginClick -> navigator.toLogin()
                StartAction.OnCreateAccountClick -> navigator.toRegister()
            }
        }
    }
}

@Composable
private fun StartScreen(
    action: (StartAction) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Orange)
            .systemBarsPadding()
            .padding(bottom = 12.dp, top = 24.dp),
        verticalArrangement = Arrangement.Bottom,
    ) {
        Image(
            painter = painterResource(Res.drawable.image_air_balloon),
            contentScale = ContentScale.FillWidth,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(0.65F)
                .align(Alignment.CenterHorizontally),
        )
        Image(
            painter = painterResource(Res.drawable.splash_foreground),
            contentScale = ContentScale.FillWidth,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(0.65F)
                .align(Alignment.CenterHorizontally),
        )
        Spacer(height = 36.dp)
        Column(
            modifier = Modifier
                .fillMaxWidth(0.65F)
                .align(Alignment.CenterHorizontally)
        ) {
            Label(
                text = "Смотрте короткие видео",
                modifier = Modifier.padding(start = 40.dp).rotate(4f)
            )
            Spacer(height = 8.dp)
            Label(text = "Исследуйте город")
            Spacer(height = 8.dp)
            Label(
                text = "Добавляйте объекты на карту",
                modifier = Modifier.padding(start = 16.dp)
            )
            Spacer(height = 8.dp)
            Label(text = "Стань аудио гидом")
        }
        Spacer(weight = 1F)
        Button(
            text = Res.string.start_screen_create_account,
            onClick = { action(StartAction.OnCreateAccountClick) },
            containerColor = Color.Pink,
            contentColor = Color.White,
        )
        Spacer(height = 12.dp)
        Button(
            text = Res.string.start_screen_login,
            onClick = { action(StartAction.OnLoginClick) },
            containerColor = Color.White,
            contentColor = Color.Pink,
            border = BorderStroke(1.dp, Color.Pink),
        )
    }
}

@Composable
private fun Label(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        maxLines = 1,
        fontSize = 15.sp,
        lineHeight = 20.sp,
        color = Color.Black,
        fontWeight = FontWeight(400),
        overflow = TextOverflow.Ellipsis,
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color.Pink)
            .border(1.dp, Color.Black, RoundedCornerShape(20.dp))
            .padding(vertical = 8.dp, horizontal = 16.dp)
    )
}

@Preview
@Composable
private fun StartScreenPreview() {
    StartScreen(action = { })
}
