package com.azazellj.tuneinapp.ui.screens.splash

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.azazellj.tuneinapp.R
import kotlinx.coroutines.delay


@Composable
fun SplashScreenView(
    onSplashFinished: () -> Unit,
) {
    val context: Context = LocalContext.current

    val lifecycleScope = LocalLifecycleOwner.current.lifecycleScope

    // launch next screen after some time
    // TODO: fix with correct implementation at the end of gif, not time-based
    LaunchedEffect(lifecycleScope) {
        lifecycleScope.launchWhenResumed {
            delay(3_000)
            onSplashFinished()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(R.raw.splash)
                .build(),
            contentDescription = "splash gif",
            modifier = Modifier
                .align(
                    alignment = Alignment.Center,
                ),
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SplashScreenViewPreview() {
    SplashScreenView(
        onSplashFinished = {},
    )
}