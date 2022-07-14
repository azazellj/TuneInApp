package com.azazellj.tuneinapp.data.network.response

import com.azazellj.tuneinapp.domain.network.model.ElementTypeModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ElementResponse(
    // common fields
    @Json(name = "element")
    val element: String?,
    @Json(name = "type")
    val type: ElementTypeModel?,
    @Json(name = "text")
    val text: String?,
    @Json(name = "URL")
    val url: String?,
    // link fields
    @Json(name = "key")
    val key: String?,
    // station fields
    @Json(name = "children")
    val children: List<ElementResponse>?,
    // audio fields
    @Json(name = "bitrate")
    val bitrate: String?,
    @Json(name = "reliability")
    val reliability: String?,
    @Json(name = "guide_id")
    val guideId: String?,
    @Json(name = "subtext")
    val subtext: String?,
    @Json(name = "genre_id")
    val genreId: String?,
    @Json(name = "formats")
    val formats: String?,
    @Json(name = "playing")
    val playing: String?,
    @Json(name = "playing_image")
    val playingImage: String?,
    @Json(name = "item")
    val item: String?,
    @Json(name = "image")
    val image: String?,
    @Json(name = "now_playing_id")
    val nowPlayingId: String?,
    @Json(name = "preset_id")
    val presetId: String?,
)
