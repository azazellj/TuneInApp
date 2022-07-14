package com.azazellj.tuneinapp.ui.screens.main


sealed class MainScreenUIState {
    object Initial : MainScreenUIState()
    object Loading : MainScreenUIState()
    object Idle : MainScreenUIState()
}
