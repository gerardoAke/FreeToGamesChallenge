package com.example.freetogames.di

import com.example.freetogames.data.GameRepositoryService
import com.example.freetogames.domain.IGameRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModules {
    @Binds
    @Singleton
    abstract fun provideWeatherRepository(implementations: GameRepositoryService): IGameRepository
}