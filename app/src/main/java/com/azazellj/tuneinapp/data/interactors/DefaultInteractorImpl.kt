package com.azazellj.tuneinapp.data.interactors

import com.azazellj.tuneinapp.domain.datasource.DefaultDataSource
import com.azazellj.tuneinapp.domain.interactors.DefaultInteractor
import com.azazellj.tuneinapp.domain.interactors.DispatcherProviders
import com.azazellj.tuneinapp.domain.model.Element
import kotlinx.coroutines.withContext
import javax.inject.Inject


internal class DefaultInteractorImpl @Inject constructor(
    private val defaultDataSource: DefaultDataSource,
    private val dispatcherProviders: DispatcherProviders,
) : DefaultInteractor {

    override suspend fun getElements(url: String): List<Element> {
        return withContext(dispatcherProviders.io) {
            defaultDataSource.getElements(
                url = url,
            )
        }
    }

    override suspend fun fetchStreamingUrl(url: String): String {
        return withContext(dispatcherProviders.io) {
            defaultDataSource.fetchStreamingUrl(
                url = url,
            )
        }
    }
}