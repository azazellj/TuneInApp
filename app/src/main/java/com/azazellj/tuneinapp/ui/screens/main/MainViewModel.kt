package com.azazellj.tuneinapp.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.azazellj.tuneinapp.domain.interactors.DefaultInteractor
import com.azazellj.tuneinapp.domain.model.Element
import com.azazellj.tuneinapp.ext.logForDebug
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val defaultInteractor: DefaultInteractor,
) : ViewModel() {

    private val _statesFlow = MutableStateFlow<MainScreenUIState>(MainScreenUIState.Initial)
    val statesFlow: Flow<MainScreenUIState> = _statesFlow

    private val _elementsFlow = MutableStateFlow<List<Element>>(emptyList())
    val elementsFlow: Flow<List<Element>> = _elementsFlow


    fun getElements(url: String) {
        viewModelScope.launch {
            try {
                _statesFlow.value = MainScreenUIState.Loading

                // simulate long request
                delay(800)

                _elementsFlow.value = defaultInteractor.getElements(url = url)
                _statesFlow.value = MainScreenUIState.Idle
            } catch (t: Throwable) {
                logForDebug(t = t)
                // TODO: add error state and its UI
                _statesFlow.value = MainScreenUIState.Idle
            }
        }
    }

    // TODO: move to state flow
    suspend fun fetchStreamingUrl(url: String): String? {
        return defaultInteractor.fetchStreamingUrl(url = url).split("\n").firstOrNull()
    }
}