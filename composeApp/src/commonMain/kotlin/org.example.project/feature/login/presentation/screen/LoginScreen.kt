package org.example.project.feature.login.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.example.project.core.ui.component.Button
import org.example.project.core.ui.component.HorizontalDivider
import org.example.project.core.ui.component.OutlinedTextField
import org.example.project.core.ui.component.PasswordTextField
import org.example.project.core.ui.component.Spacer
import org.example.project.core.ui.component.TextButton
import org.example.project.core.ui.component.rippleClickable
import org.example.project.core.ui.screen.Screen
import org.example.project.core.ui.theme.Pink
import org.example.project.core.util.ext.Blank
import org.example.project.core.util.ext.appendClickableText
import org.example.project.core.util.ext.appendText
import org.example.project.feature.login.presentation.navigation.LoginNavigator
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf
import tourism.composeapp.generated.resources.Res
import tourism.composeapp.generated.resources.login

fun NavGraphBuilder.loginScreen(navigator: LoginNavigator) {
    composable<Screen.Login> {
        val viewModel: LoginViewModel = koinViewModel {
            parametersOf(navigator)
        }
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        LoginScreen(uiState, viewModel::action)
    }
}

@Composable
private fun LoginScreen(
    uiState: LoginUIState,
    action: (LoginAction) -> Unit,
) {
    val keyboard = LocalSoftwareKeyboardController.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()
            .background(Color(0xFFEFEFF4)),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 8.dp),
        ) {
            Text(
                text = "Log in",
                modifier = Modifier.align(Alignment.Center),
                style = TextStyle(
                    fontSize = 17.sp,
                    lineHeight = 36.sp,
                    color = Color(0xFF002033),
                    fontWeight = FontWeight(590),
                )
            )
            IconButton(
                modifier = Modifier.align(Alignment.CenterEnd),
                onClick = { action(LoginAction.OnCloseClick) },
            ) {
                Icon(Icons.Rounded.Close, null)
            }
        }
        Spacer(height = 12.dp)
        OutlinedTextField(
            value = uiState.email,
            placeholder = "Email",
            onValueChanged = { action(LoginAction.OnEmailValueChanged(it)) },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Email,
            ),
        )
        Spacer(height = 12.dp)
        PasswordTextField(
            value = uiState.password,
            onValueChanged = { action(LoginAction.OnPasswordValueChanged(it)) },
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboard?.hide()
                    action(LoginAction.OnLoginClick)
                },
            )
        )
        Spacer(height = 12.dp)
        Button(
            text = Res.string.login,
            isLoading = uiState.isLoading,
            containerColor = Color.Pink,
            contentColor = Color.White,
            onClick = {
                keyboard?.hide()
                action(LoginAction.OnLoginClick)
            }
        )
        Spacer(height = 12.dp)
        TextButton(
            onClick = { action(LoginAction.OnForgetPasswordClick) },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Forgot password",
        )
        Spacer(height = 24.dp)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            HorizontalDivider()
            Text(
                text = "or",
                color = Color(0xFF3C3C43).copy(alpha = 0.6F),
                fontSize = 15.sp,
                fontWeight = FontWeight(400),
            )
            HorizontalDivider()
        }
        Spacer(height = 24.dp)
        SocialButton(
            text = "Contunue with Facebook",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            onClick = { },
        )
        Spacer(height = 8.dp)
        SocialButton(
            text = "Contunue with Google",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            onClick = { },
        )
        Spacer(height = 8.dp)
        SocialButton(
            text = "Contunue with Apple",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            onClick = { },
        )
        Spacer(height = 24.dp)
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            textAlign = TextAlign.Center,
            text = buildAnnotatedString {
                appendText(text = "By continuing, you agree to the")
                append(String.Blank)
                appendClickableText(
                    text = "Terms of Service",
                    tag = "terms_of_service",
                    color = Color.Pink,
                    onTextClickClick = { }
                )
                append(String.Blank)
                appendText(text = "and, acknowledge our")
                append(String.Blank)
                appendClickableText(
                    text = "Privacy Policy",
                    tag = "privacy_policy",
                    color = Color.Pink,
                    onTextClickClick = { }

                )
            },
        )
        Spacer(weight = 1F)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
                .background(Color.White),
        ) {
            HorizontalDivider(modifier = Modifier.fillMaxWidth())
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = buildAnnotatedString {
                    appendText(
                        text = "Don’t have an account?",
                        fontSize = 15.sp,
                    )
                    append(String.Blank)
                    appendClickableText(
                        text = "Create Account",
                        tag = "create_account",
                        color = Color.Pink,
                        fontSize = 15.sp,
                        fontWeight = FontWeight(590),
                        onTextClickClick = { action(LoginAction.OnCreateAccountClick) },
                    )
                },
            )
        }
    }
}

@Composable
private fun SocialButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .height(50.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .rippleClickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            text = text,
            style = TextStyle(
                color = Color.Pink,
                fontSize = 17.sp,
                fontWeight = FontWeight(590),
            ),
        )
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen(
        uiState = LoginUIState(),
        action = {},
    )
}