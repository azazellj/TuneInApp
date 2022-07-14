package com.azazellj.tuneinapp.data.mapping

import com.azazellj.tuneinapp.data.network.response.ElementResponse
import com.azazellj.tuneinapp.domain.model.Element
import com.azazellj.tuneinapp.domain.model.ElementType
import com.azazellj.tuneinapp.domain.network.model.ElementTypeModel


fun ElementResponse.toDomain(): Element {
    return when {
        type == ElementTypeModel.LINK -> Element.Link(
            element = element,
            type = type.toDomain(),
            text = text,
            url = url,
            key = key,
        )
        type == ElementTypeModel.AUDIO -> Element.Audio(
            element = element,
            type = type.toDomain(),
            text = text,
            url = url,
            key = key,
            bitrate = bitrate,
            reliability = reliability,
            guideId = guideId,
            subtext = subtext,
            genreId = genreId,
            formats = formats,
            playing = playing,
            playingImage = playingImage,
            item = item,
            image = image,
            nowPlayingId = nowPlayingId,
            presetId = presetId,
        )
        type == null && children?.isNotEmpty() == true -> Element.Group(
            element = element,
            type = ElementType.Group,
            text = text,
            url = url,
            key = key,
            children = children.orEmpty().map { it.toDomain() },
        )
        else -> throw IllegalArgumentException("Unknown type: $type")
    }
}


fun ElementTypeModel.toDomain(): ElementType {
    return when (this) {
        ElementTypeModel.LINK -> ElementType.Link
        ElementTypeModel.AUDIO -> ElementType.Audio
    }
}

