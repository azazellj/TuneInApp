package com.azazellj.tuneinapp.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.azazellj.tuneinapp.domain.model.Element
import com.azazellj.tuneinapp.ui.view.PlayerView
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel(),
    currentUrl: String,
    onElementClick: (Element) -> Unit,
) {
    val lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current
    val state = viewModel.statesFlow
        .collectAsState(initial = MainScreenUIState.Initial).value
    val elements = viewModel.elementsFlow
        .collectAsState(initial = emptyList()).value

    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    val coroutineScope = rememberCoroutineScope()

    var isLoading by remember { mutableStateOf(false) }
    var currentPlayingAudio by remember { mutableStateOf<Element.Audio?>(null) }

    // TODO:
    var player: ExoPlayer? = null

    LaunchedEffect(state) {
        when (state) {
            MainScreenUIState.Initial -> {
                viewModel.getElements(
                    url = currentUrl,
                )
            }
            MainScreenUIState.Loading -> {
                isLoading = true
            }
            MainScreenUIState.Idle -> {
                isLoading = false
            }
        }
    }

    // If `lifecycleOwner` changes, dispose and reset the effect
    DisposableEffect(lifecycleOwner) {
        // Create an observer that triggers player close on screen exit
        // for sending analytics events
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_STOP) {
                player?.release()
                player = null
            }
        }

        // Add the observer to the lifecycle
        lifecycleOwner.lifecycle.addObserver(observer)

        // When the effect leaves the Composition, remove the observer
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    fun openPlayerView(element: Element.Audio) {
        val url = element.url ?: return
        player?.stop()
        player?.release()
        player = null

        // TODO: add lifecycle handling, for example - close on app pause
        currentPlayingAudio = element
        coroutineScope.launch {
            bottomSheetScaffoldState.bottomSheetState.expand()
            // currently m3u is not supported by exo player
            // get here first streaming url from m3u list and play it
            val streamingUrl = viewModel.fetchStreamingUrl(url)

            player = ExoPlayer.Builder(context).build()
            player?.setMediaItem(MediaItem.Builder().setUri(streamingUrl).build())
            player?.prepare()
            player?.play()
        }
    }

    fun closePlayerView() {
        coroutineScope.launch {
            bottomSheetScaffoldState.bottomSheetState.collapse()
            currentPlayingAudio = null
        }
        player?.release()
        player = null
    }

    fun handleOnAudioClick(element: Element.Audio) {
        openPlayerView(element)
    }

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            PlayerView(
                element = currentPlayingAudio,
                modifier = Modifier,
                onCloseClick = {
                    closePlayerView()
                },
            )
        },
        sheetPeekHeight = 0.dp,
    ) {
        MainScreenView(
            items = elements,
            onElementClick = { element ->
                when (element) {
                    is Element.Link -> {
                        closePlayerView()
                        // open next screen with link
                        onElementClick(element)
                    }
                    is Element.Group -> TODO()
                    is Element.Audio -> {
                        handleOnAudioClick(element)
                    }
                }
            }
        )
    }

    if (isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color.Black.copy(alpha = 0.18f),
                ),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .requiredSize(50.dp),
                color = Color.Black,
                strokeWidth = 5.dp,
            )
        }
    }
}