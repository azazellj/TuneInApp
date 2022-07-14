package com.azazellj.tuneinapp.domain.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ResponseHeadModel(
    @Json(name = "title")
    val title: String,
    @Json(name = "status")
    val status: String,
)