package org.example.project.feature.home.presentation.screen.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import coil3.compose.AsyncImage
import org.example.project.core.ui.screen.Screen

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.homeDetailScreen(navController: NavController) {
    composable<Screen.HomeDetail> {
        val pokemon = it.toRoute<Screen.HomeDetail>()

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = { Text("Detail") },
                    navigationIcon = {
                        IconButton(
                            onClick = { navController.navigateUp() },
                            content = {
                                Icon(
                                    contentDescription = null,
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack
                                )
                            }
                        )
                    }
                )
            },
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(it),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                AsyncImage(
                    model = pokemon.imageUrl,
                    contentDescription = null
                )
                Text(pokemon.pokemonName)
            }
        }
    }
}