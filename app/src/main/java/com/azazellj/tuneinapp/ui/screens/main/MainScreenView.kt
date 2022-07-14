package com.azazellj.tuneinapp.ui.screens.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.azazellj.tuneinapp.domain.model.Element
import com.azazellj.tuneinapp.ui.view.GroupView
import com.azazellj.tuneinapp.ui.view.LinkView


@Composable
fun MainScreenView(
    items: List<Element>,
    onElementClick: (Element) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        items(items) { item ->
            when (item) {
                is Element.Link -> {
                    LinkView(
                        element = item,
                        onElementClick = {
                            onElementClick(item)
                        },
                    )
                }
                is Element.Group -> {
                    GroupView(
                        element = item,
                        onElementClick = onElementClick,
                    )
                }
                is Element.Audio -> TODO("should not be here")
            }

            Divider()
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun MainScreenViewPreview() {
    MainScreenView(
        items = listOf(),
        onElementClick = {},
    )
}