package com.azazellj.tuneinapp.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.azazellj.tuneinapp.domain.model.Element
import com.azazellj.tuneinapp.domain.model.ElementType


@Composable
fun PlayerView(
    element: Element.Audio?,
    modifier: Modifier = Modifier,
    onCloseClick: () -> Unit,
) {
    // TODO: add player buttons / player view?

    Surface(
        modifier = Modifier,
        shape = RoundedCornerShape(
            topStart = 16.dp,
            topEnd = 16.dp,
        ),
        elevation = 4.dp,
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth(),
        ) {
            Icon(
                painter = rememberVectorPainter(image = Icons.Default.Close),
                contentDescription = "close icon",
                modifier = Modifier
                    .align(
                        alignment = Alignment.End,
                    )
                    .padding(
                        top = 16.dp,
                        end = 16.dp,
                    )
                    .requiredSize(32.dp)
                    .clickable {
                        onCloseClick()
                    },
            )

            Image(
                painter = rememberAsyncImagePainter(element?.image),
                contentDescription = "radio icon",
                modifier = Modifier
                    .requiredSize(160.dp)
                    .background(
                        color = Color.LightGray,
                    )
                    .align(
                        alignment = Alignment.CenterHorizontally,
                    ),
            )

            // TODO: add translations here
            Text(
                text = element?.text.orEmpty().ifEmpty { "Loading..." },
                modifier = Modifier
                    .padding(
                        top = 16.dp,
                    )
                    .align(
                        alignment = Alignment.CenterHorizontally,
                    ),
                style = MaterialTheme.typography.h5,
            )

            if (!element?.playing.isNullOrBlank()) {
                Text(
                    text = element?.playing.orEmpty(),
                    modifier = Modifier
                        .padding(
                            vertical = 8.dp,
                        )
                        .align(
                            alignment = Alignment.CenterHorizontally,
                        ),
                    style = MaterialTheme.typography.subtitle1,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlayerViewPreview() {
    val audio = Element.Audio(
        element = "outline",
        type = ElementType.Audio,
        text = "SomaFM: ThistleRadio (US)",
        url = "http://opml.radiotime.com/Tune.ashx?id=s247228",
        key = null,
        bitrate = "128",
        reliability = "100",
        guideId = "s247228",
        subtext = "Skerryvore - Soraidh Slan & The Rise [Live]",
        formats = "mp3",
        genreId = "g138",
        playing = "Skerryvore - Soraidh Slan & The Rise [Live]",
        playingImage = "http://cdn-albums.tunein.com/gn/KDTT4CNKCHq.jpg",
        item = "station",
        image = "http://cdn-profiles.tunein.com/s247228/images/logoq.jpg",
        nowPlayingId = "s247228",
        presetId = "preset_id",
    )

    PlayerView(
        element = audio,
        onCloseClick = {},
    )
}