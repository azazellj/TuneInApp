package com.azazellj.tuneinapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.azazellj.tuneinapp.ui.navigation.TuneInApp
import com.azazellj.tuneinapp.ui.theme.TuneInAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TuneInAppTheme {
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier,
                ) {
                    TuneInApp(
                        navController = navController,
                    )
                }
            }
        }
    }
}
