package com.azazellj.tuneinapp.domain.interactors

import kotlinx.coroutines.CoroutineDispatcher


interface DispatcherProviders {
    val io: CoroutineDispatcher
}