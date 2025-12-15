package org.example.project.feature.home.presentation.screen.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import coil3.compose.rememberAsyncImagePainter
import kotlinx.coroutines.flow.collectLatest
import org.example.project.core.ui.component.ScreenStateWidget
import org.example.project.core.ui.component.Shimmer
import org.example.project.core.ui.component.rippleClickable
import org.example.project.core.ui.screen.Screen
import org.example.project.feature.home.presentation.navigation.HomeNavigator
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

fun NavGraphBuilder.homeScreen(navigator: HomeNavigator) {
    composable<Screen.Home> {
        val viewModel: HomeViewModel = koinViewModel {
            parametersOf(navigator)
        }
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        HomeScreen(
            uiState = uiState,
            action = viewModel::action,
        )

        LaunchedEffect(Unit) {
            viewModel.effect.collectLatest {

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreen(
    uiState: HomeUiState,
    action: (HomeAction) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding(),
    ) {
        ScreenStateWidget(
            screenState = uiState.screenState,
            loadingContent = {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(20) {
                        Shimmer(
                            modifier = Modifier
                                .padding(horizontal = 16.dp, vertical = 4.dp)
                                .fillMaxWidth()
                                .height(60.dp)
                        )
                    }
                }
            },
            content = {
                LazyVerticalGrid(
                    modifier = Modifier.fillMaxSize(),
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 24.dp),
                ) {
                    items(
                        items = uiState.pokemons,
                        key = { it.name },
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .clip(RoundedCornerShape(16.dp))
                                .background(color = Color.LightGray)
                                .rippleClickable { action(HomeAction.OnPokemonClick(it)) },
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(model = it.imageUrl),
                                contentDescription = null,
                                modifier = Modifier.fillMaxWidth(0.8F),
                                contentScale = ContentScale.FillWidth,
                            )
                            Text(
                                text = it.name,
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.titleMedium,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp, horizontal = 16.dp),
                            )
                        }
                    }
                }
            }
        )
    }
//    Scaffold(
//        modifier = Modifier.fillMaxSize(),
//        topBar = {
//            CenterAlignedTopAppBar(
//                expandedHeight = 0.dp,
//                title = { Text("Home") },
//            )
//        }
//    ) {
//
//    }
}
