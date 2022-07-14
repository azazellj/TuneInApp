package com.azazellj.tuneinapp.data.di

import com.azazellj.tuneinapp.data.datasourse.DefaultDataSourceImpl
import com.azazellj.tuneinapp.data.interactors.DefaultInteractorImpl
import com.azazellj.tuneinapp.data.network.DefaultApi
import com.azazellj.tuneinapp.domain.datasource.DefaultDataSource
import com.azazellj.tuneinapp.domain.interactors.DefaultInteractor
import com.azazellj.tuneinapp.domain.interactors.DispatcherProviders
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
class DefaultModule {

    @Provides
    fun provideDefaultDataSource(
        api: DefaultApi,
    ): DefaultDataSource {
        return DefaultDataSourceImpl(
            api = api,
        )
    }

    @Provides
    fun provideDefaultInteractor(
        defaultDataSource: DefaultDataSource,
        dispatcherProviders: DispatcherProviders,
    ): DefaultInteractor {
        return DefaultInteractorImpl(
            defaultDataSource = defaultDataSource,
            dispatcherProviders = dispatcherProviders,
        )
    }
}