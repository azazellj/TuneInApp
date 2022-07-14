package com.azazellj.tuneinapp.data.datasourse

import com.azazellj.tuneinapp.data.mapping.toDomain
import com.azazellj.tuneinapp.data.network.DefaultApi
import com.azazellj.tuneinapp.domain.datasource.DefaultDataSource
import com.azazellj.tuneinapp.domain.model.Element
import javax.inject.Inject


internal class DefaultDataSourceImpl @Inject constructor(
    private val api: DefaultApi,
) : DefaultDataSource {

    override suspend fun getElements(
        url: String,
    ): List<Element> {
        return api.getElements(
            url = url,
        )
            .body
            .map { it.toDomain() }
    }

    override suspend fun fetchStreamingUrl(url: String): String {
        return api.fetchStreamingUrl(
            url = url,
        )
            .body()
            ?.string()
            .orEmpty()
    }
}