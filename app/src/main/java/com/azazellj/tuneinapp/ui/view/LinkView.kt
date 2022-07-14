package com.azazellj.tuneinapp.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.azazellj.tuneinapp.domain.model.Element
import com.azazellj.tuneinapp.domain.model.ElementType


@Composable
fun LinkView(
    element: Element.Link,
    modifier: Modifier = Modifier,
    onElementClick: (Element) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(bounded = true),
                onClick = {
                    onElementClick(element)
                },
            )
            .padding(
                start = 16.dp,
                top = 8.dp,
                end = 8.dp,
                bottom = 8.dp,
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = element.text.orEmpty(),
            style = MaterialTheme.typography.body1,
        )

        Spacer(modifier = Modifier.weight(1.0f))

        Icon(
            painter = rememberVectorPainter(image = Icons.Default.KeyboardArrowRight),
            contentDescription = "next icon",
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LinkViewPreview() {
    LinkView(
        element = Element.Link(
            element = "outline",
            type = ElementType.Link,
            text = "Local Radio",
            url = "http://opml.radiotime.com/Browse.ashx?c=local",
            key = "local",
        ),
        onElementClick = {},
    )
}