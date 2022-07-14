package com.azazellj.tuneinapp.ui.screens.splash

import androidx.compose.runtime.Composable


@Composable
fun SplashScreen(
    onSplashFinished: () -> Unit,
) {
    SplashScreenView(
        onSplashFinished = onSplashFinished,
    )
}