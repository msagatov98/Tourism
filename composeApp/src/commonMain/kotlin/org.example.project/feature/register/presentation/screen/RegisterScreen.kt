package org.example.project.feature.register.presentation.screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import kotlinx.coroutines.flow.collectLatest
import org.example.project.core.ui.component.Button
import org.example.project.core.ui.component.OutlinedTextField
import org.example.project.core.ui.component.rippleClickable
import org.example.project.core.ui.screen.Screen
import org.example.project.feature.register.presentation.navigation.RegisterNavigator
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf
import tourism.composeapp.generated.resources.Res
import tourism.composeapp.generated.resources.registrationPlaceholderAgeGroup
import tourism.composeapp.generated.resources.registrationPlaceholderCountry
import tourism.composeapp.generated.resources.registrationPlaceholderEmail
import tourism.composeapp.generated.resources.registrationPlaceholderLanguage
import tourism.composeapp.generated.resources.registrationPlaceholderPhone
import tourism.composeapp.generated.resources.registrationPlaceholderTravellingType
import tourism.composeapp.generated.resources.registrationRegister

fun NavGraphBuilder.registerScreen(navigator: RegisterNavigator) {
    composable<Screen.Register> {
        val viewModel: RegisterViewModel = koinViewModel {
            parametersOf(navigator)
        }
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        RegisterScreen(uiState, viewModel::action)

        LaunchedEffect(Unit) {
            viewModel.effect.collectLatest {

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RegisterScreen(
    uiState: RegisterUiState,
    action: (RegisterAction) -> Unit,
) {
    val keyboard = LocalSoftwareKeyboardController.current
    val scrollState = rememberScrollState()
    val imageBitmap: ImageBitmap? by remember {
        mutableStateOf(null)
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Registration") }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            AnimatedContent(
                targetState = imageBitmap,
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally)
                    .clip(CircleShape)
                    .rippleClickable { },
            ) { bitmap ->
                if (bitmap != null) {
                    Image(
                        bitmap = bitmap,
                        contentDescription = null,
                    )
                } else {
                    Image(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = null,
                    )
                }
            }
            OutlinedTextField(
                value = uiState.email,
                onValueChanged = { action(RegisterAction.OnInputEmail(it)) },
                placeholder = Res.string.registrationPlaceholderEmail,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Email,
                ),
            )
            OutlinedTextField(
                value = uiState.phone,
                onValueChanged = { },
                placeholder = Res.string.registrationPlaceholderPhone,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Phone,
                ),
            )
            OutlinedTextField(
                value = uiState.language,
                onValueChanged = { },
                placeholder = Res.string.registrationPlaceholderLanguage,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                ),
            )
            OutlinedTextField(
                value = uiState.country,
                onValueChanged = { },
                placeholder = Res.string.registrationPlaceholderCountry,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                ),
            )
            OutlinedTextField(
                value = "",
                onValueChanged = { },
                placeholder = Res.string.registrationPlaceholderAgeGroup,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Number,
                ),
            )
            OutlinedTextField(
                value = "",
                onValueChanged = { },
                placeholder = Res.string.registrationPlaceholderTravellingType,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboard?.hide()
                        action(RegisterAction.OnRegisterClicked)
                    }
                )
            )
            Button(
                text = Res.string.registrationRegister,
                isLoading = uiState.loading,
                onClick = {
                    keyboard?.hide()
                    action(RegisterAction.OnRegisterClicked)
                }
            )
        }
    }
}

@Preview
@Composable
private fun RegisterScreenPreview() {
    RegisterScreen(
        uiState = RegisterUiState(),
        action = {},
    )
}