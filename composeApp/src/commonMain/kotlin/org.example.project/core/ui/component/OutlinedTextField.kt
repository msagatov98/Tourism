package org.example.project.core.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.core.ui.theme.Pink
import org.example.project.core.util.ext.empty
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import tourism.composeapp.generated.resources.Res
import tourism.composeapp.generated.resources.empty

@Composable
fun OutlinedTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    placeholder: String = String.empty,
    maxLines: Int = 1,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    androidx.compose.material3.OutlinedTextField(
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp),
        value = value,
        placeholder = { Text(text = placeholder) },
        maxLines = maxLines,
        onValueChange = onValueChanged,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        shape = RoundedCornerShape(8.dp),
        textStyle = TextStyle(
            fontWeight = FontWeight(400),
            fontSize = 15.sp,
            lineHeight = 20.sp,
            letterSpacing = (-0.24).sp,
        ),
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = Color.Pink,
            errorCursorColor = Color.Pink,
            focusedBorderColor = Color.Pink,
            unfocusedBorderColor = Color.Transparent,
            errorContainerColor = Color.White,
            focusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedPlaceholderColor = Color(0xFF3C3C434D),
            unfocusedPlaceholderColor = Color(0xFF3C3C434D),
            focusedTrailingIconColor = Color(0xFF3C3C434D),
            unfocusedTrailingIconColor = Color(0xFF3C3C434D),
        )
    )
}

@Composable
fun OutlinedTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    placeholder: StringResource = Res.string.empty,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    OutlinedTextField(
        value = value,
        onValueChanged = onValueChanged,
        placeholder = stringResource(placeholder),
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
    )
}


@Composable
fun PasswordTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    var passwordVisible by remember { mutableStateOf(false) }
    val passwordVisualTransformation by remember(passwordVisible) {
        mutableStateOf(
            if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
        )
    }

    OutlinedTextField(
        value = value,
        onValueChanged = onValueChanged,
        placeholder = "Password",
        visualTransformation = passwordVisualTransformation,
        keyboardActions = keyboardActions,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done,
        ),
        trailingIcon = {
            val image = if (passwordVisible)
                Icons.Default.Visibility
            else
                Icons.Default.VisibilityOff

            IconButton(
                onClick = { passwordVisible = !passwordVisible }
            ) {
                Icon(
                    imageVector = image,
                    contentDescription = if (passwordVisible) "Hide password" else "Show password"
                )
            }
        }
    )
}