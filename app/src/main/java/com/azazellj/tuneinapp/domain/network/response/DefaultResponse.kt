package com.azazellj.tuneinapp.domain.network.response

import com.azazellj.tuneinapp.domain.network.model.ResponseHeadModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class DefaultResponse<T>(
    @Json(name = "body")
    val body: T,
    @Json(name = "head")
    val head: ResponseHeadModel,
)