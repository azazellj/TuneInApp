package com.azazellj.tuneinapp.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.azazellj.tuneinapp.domain.model.Element
import com.azazellj.tuneinapp.domain.model.ElementType


@Composable
fun GroupView(
    element: Element.Group,
    modifier: Modifier = Modifier,
    onElementClick: (Element) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
    ) {
        Text(
            text = element.text.orEmpty(),
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    top = 8.dp,
                ),
            style = MaterialTheme.typography.h4,
        )

        Divider(
            modifier = Modifier
                .padding(
                    top = 8.dp,
                    end = 40.dp,
                    bottom = 8.dp,
                ),
        )

        element.children.forEachIndexed { index, child ->
            when (child) {
                is Element.Audio -> {
                    AudioView(
                        element = child,
                        modifier = Modifier,
                        onElementClick = {
                            onElementClick(child)
                        },
                    )
                }
                is Element.Group -> TODO()
                is Element.Link -> {
                    LinkView(
                        element = child,
                        onElementClick = {
                            onElementClick(child)
                        }
                    )
                }
            }

            // hide divider for last one
            if (index != element.children.lastIndex) {
                Divider()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GroupViewPreview() {
    GroupView(
        element = Element.Group(
            element = "outline",
            type = ElementType.Group,
            text = "Local Stations (1)",
            url = null,
            key = "local",
            children = listOf(
                Element.Audio(
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
            )
        ),
        onElementClick = {},
    )
}