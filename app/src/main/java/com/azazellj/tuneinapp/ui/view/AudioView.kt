package com.azazellj.tuneinapp.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.azazellj.tuneinapp.domain.model.Element
import com.azazellj.tuneinapp.domain.model.ElementType


@Composable
fun AudioView(
    element: Element.Audio,
    modifier: Modifier = Modifier,
    onElementClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(bounded = true),
                onClick = onElementClick,
            ),
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    top = 16.dp,
                    bottom = 16.dp,
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = rememberAsyncImagePainter(element.image),
                contentDescription = "radio icon",
                modifier = Modifier
                    .requiredSize(80.dp)
                    .background(
                        color = Color.LightGray,
                    ),
            )
            Column(
                modifier = Modifier
                    .padding(
                        all = 16.dp,
                    )
            ) {
                Text(
                    text = element.text.orEmpty(),
                    modifier = Modifier,
                    style = MaterialTheme.typography.h6,
                )

                if (!element.playing.isNullOrBlank()) {
                    Text(
                        text = element.playing.orEmpty(),
                        modifier = Modifier
                            .padding(
                                vertical = 4.dp,
                            ),
                        style = MaterialTheme.typography.caption,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AudioViewPreview() {
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

    AudioView(
        element = audio,
        onElementClick = {},
    )
}