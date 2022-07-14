package com.azazellj.tuneinapp.data.interactors

import com.azazellj.tuneinapp.domain.interactors.DispatcherProviders
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


class DispatcherProvidersImpl : DispatcherProviders {
    override val io: CoroutineDispatcher
        get() = Dispatchers.IO
}