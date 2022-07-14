package com.azazellj.tuneinapp.domain.interactors

import com.azazellj.tuneinapp.domain.model.Element


interface DefaultInteractor {

    suspend fun getElements(
        url: String,
    ): List<Element>

    suspend fun fetchStreamingUrl(
        url: String,
    ): String
}