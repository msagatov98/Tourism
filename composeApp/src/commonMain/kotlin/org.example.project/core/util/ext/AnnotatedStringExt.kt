package org.example.project.core.util.ext

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString.Builder
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import org.example.project.core.ui.theme.Pink

fun Builder.appendText(
    text: String,
    color: Color = Color(0xFF3C3C43).copy(alpha = 0.6F),
    fontSize: TextUnit = 13.sp,
    fontWeight: FontWeight = FontWeight(400),
    letterSpacing: TextUnit = (-0.29).sp,
) {
    withStyle(
        style = SpanStyle(
            color = color,
            fontSize = fontSize,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing,
        ),
    ) {
        append(text)
    }
}

fun Builder.appendClickableText(
    text: String,
    tag: String,
    color: Color = Color(0xFF3C3C43).copy(alpha = 0.6F),
    fontSize: TextUnit = 13.sp,
    fontWeight: FontWeight = FontWeight(400),
    letterSpacing: TextUnit = (-0.29).sp,
    onTextClickClick: () -> Unit,
) {
    withLink(
        LinkAnnotation.Clickable(
            tag = tag,
            linkInteractionListener = { onTextClickClick() }
        )
    ) {
        appendText(
            text = text,
            color = color,
            fontSize = fontSize,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing,
        )
    }
}
