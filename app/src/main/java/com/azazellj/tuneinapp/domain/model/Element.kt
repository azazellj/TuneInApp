package com.azazellj.tuneinapp.domain.model


sealed class Element(
    open val element: String?,
    open val type: ElementType?,
    open val text: String?,
    open val url: String?,
    open val key: String?,
) {
    data class Link(
        override val element: String?,
        override val type: ElementType?,
        override val text: String?,
        override val url: String?,
        override val key: String?,
    ) : Element(
        element = element,
        type = type,
        text = text,
        url = url,
        key = key,
    )

    data class Audio(
        override val element: String?,
        override val type: ElementType?,
        override val text: String?,
        override val url: String?,
        override val key: String?,
        val bitrate: String?,
        val reliability: String?,
        val guideId: String?,
        val subtext: String?,
        val genreId: String?,
        val formats: String?,
        val playing: String?,
        val playingImage: String?,
        val item: String?,
        val image: String?,
        val nowPlayingId: String?,
        val presetId: String?,
    ) : Element(
        element = element,
        type = type,
        text = text,
        url = url,
        key = key,
    )

    data class Group(
        override val element: String?,
        override val type: ElementType?,
        override val text: String?,
        override val url: String?,
        override val key: String?,
        val children: List<Element>,
    ) : Element(
        element = element,
        type = type,
        text = text,
        url = url,
        key = key,
    )
}
