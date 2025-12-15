package org.example.project.feature.home.presentation.screen.list

import androidx.lifecycle.ViewModel
import org.example.project.core.ui.component.ScreenState
import org.example.project.core.ui.controller.DefaultScreenController
import org.example.project.core.ui.controller.ScreenController
import org.example.project.core.util.ext.launch
import org.example.project.core.util.result.onFailure
import org.example.project.core.util.result.onSuccess
import org.example.project.feature.home.data.repository.HomeRepository
import org.example.project.feature.home.presentation.navigation.HomeNavigator

class HomeViewModel(
    private val homeNavigator: HomeNavigator,
    private val homeRepository: HomeRepository,
) : ViewModel(),
    ScreenController<HomeUiState, HomeAction, HomeEffect> by DefaultScreenController(
        HomeUiState()
    ) {

    init {
        launch {
            homeRepository
                .getPokemonList()
                .onSuccess {
                    setState(
                        uiState.value.copy(
                            screenState = ScreenState.Success,
                            pokemons = it,
                        )
                    )
                }
                .onFailure {
                    setState(uiState.value.copy(screenState = ScreenState.Failure))
                }
        }
    }

    override fun action(action: HomeAction) {
        when (action) {
            HomeAction.OnBackClick -> homeNavigator.navigateUp()
            is HomeAction.OnPokemonClick -> homeNavigator.goToDetails(action.pokemon)
        }
    }
}
