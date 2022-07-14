package com.azazellj.tuneinapp.domain.network.model

import com.squareup.moshi.Json


enum class ElementTypeModel {
    @Json(name = "link")
    LINK,

    @Json(name = "audio")
    AUDIO,
}