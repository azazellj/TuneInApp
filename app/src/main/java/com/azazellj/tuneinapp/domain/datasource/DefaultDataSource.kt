package com.azazellj.tuneinapp.domain.datasource

import com.azazellj.tuneinapp.domain.model.Element


interface DefaultDataSource {

    suspend fun getElements(
        url: String,
    ): List<Element>

    suspend fun fetchStreamingUrl(
        url: String,
    ): String
}