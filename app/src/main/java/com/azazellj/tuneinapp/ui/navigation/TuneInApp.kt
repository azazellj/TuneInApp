package com.azazellj.tuneinapp.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.azazellj.tuneinapp.BuildConfig
import com.azazellj.tuneinapp.ui.screens.main.MainScreen
import com.azazellj.tuneinapp.ui.screens.splash.SplashScreen


@Composable
fun TuneInApp(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "splash",
        modifier = Modifier
            .fillMaxSize(),
    ) {

        // app splash screen
        composable("splash") {
            SplashScreen(
                onSplashFinished = {
                    navController.navigate("main?url=${BuildConfig.SERVER_URL}")
                }
            )
        }

        composable("main?url={url}") {
            val url = it.arguments?.getString("url")!!
            MainScreen(
                currentUrl = url,
                onElementClick = { element ->
                    navController.navigate("main?url=${element.url}")
                },
            )
        }
    }
}