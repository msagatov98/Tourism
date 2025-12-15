package org.example.project.core.ui.component

import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import tourism.composeapp.generated.resources.Res
import tourism.composeapp.generated.resources.TildaSans_Medium

@Composable
fun MenuItem(
    modifier: Modifier = Modifier,
    selected: Boolean,
    textRes: StringResource,
    onClick: () -> Unit,
) {
    NavigationDrawerItem(
        onClick = onClick,
        modifier = modifier,
        selected = selected,
        shape = RectangleShape,
        label = {
            Text(
                fontSize = 16.sp,
                text = stringResource(textRes),
                fontFamily = FontFamily(
                    Font(
                        resource = Res.font.TildaSans_Medium,
                        weight = FontWeight.Medium,
                    ),
                )
            )
        },
        colors = NavigationDrawerItemDefaults.colors(
            selectedTextColor = Color(0xFF042051),
            unselectedTextColor = Color(0xFF042051),
        ),
    )
}