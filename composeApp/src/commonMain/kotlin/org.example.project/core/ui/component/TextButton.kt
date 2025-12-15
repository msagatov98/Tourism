package org.example.project.core.ui.component

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.example.project.core.ui.theme.Pink
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun TextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    androidx.compose.material3.TextButton(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.textButtonColors(
            contentColor = Color.Pink,
        ),
    ) {
        Text(
            text = text,
            fontSize = 17.sp,
            fontWeight = FontWeight(590),
        )
    }
}
@Composable
fun TextButton(
    onClick: () -> Unit,
    text: StringResource,
    modifier: Modifier = Modifier,
) {
    TextButton(
        onClick = onClick,
        text = stringResource(text),
        modifier = modifier,
    )
}