package org.example.project.core.util.ext

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

inline fun ViewModel.launch(crossinline action: suspend () -> Unit) {
    viewModelScope.launch { action() }
}
