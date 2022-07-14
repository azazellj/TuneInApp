package com.azazellj.tuneinapp.data.di

import com.azazellj.tuneinapp.data.interactors.DispatcherProvidersImpl
import com.azazellj.tuneinapp.domain.interactors.DispatcherProviders
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class CommonModule {

    @Singleton
    @Provides
    fun provideDispatcherProviders(): DispatcherProviders = DispatcherProvidersImpl()
}