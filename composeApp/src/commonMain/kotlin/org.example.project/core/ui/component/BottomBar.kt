package org.example.project.core.ui.component

import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun BottomBar(pagerState: PagerState) {
    val coroutineScope = rememberCoroutineScope()
    val items = remember {
        listOf(
            BottomNavItem.Home,
            BottomNavItem.Search,
            BottomNavItem.Profile
        )
    }

    NavigationBar {
        items.forEachIndexed { index, item ->
            val selected = pagerState.currentPage == index
            NavigationBarItem(
                selected = selected,
                label = { Text(text = item.labelRes) },
                onClick = {
                    coroutineScope.launch {
                        pagerState.scrollToPage(index)
                    }
                },
                icon = {
                    Icon(
                        contentDescription = null,
                        imageVector = if (selected) {
                            item.selectedIcon
                        } else {
                            item.unselectedIcon
                        }
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    indicatorColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
                )
            )
        }
    }
}

private sealed class BottomNavItem(
    val labelRes: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
) {
    data object Home : BottomNavItem(
        labelRes = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
    )

    data object Search : BottomNavItem(
        labelRes = "Image picker",
        selectedIcon = Icons.Filled.Search,
        unselectedIcon = Icons.Outlined.Search,
    )

    data object Profile : BottomNavItem(
        labelRes = "Settings",
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person,
    )
}
