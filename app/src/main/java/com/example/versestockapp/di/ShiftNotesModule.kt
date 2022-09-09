package com.example.versestockapp.di

import com.example.versestockapp.data.repository.StocksRepositoryImpl
import com.example.versestockapp.domain.repository.IStocksRepository
import com.example.versestockapp.domain.usecases.GetStocksUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StocksModule {

    @Provides
    @Singleton
    fun provideStocksRepository(): IStocksRepository =
        StocksRepositoryImpl()

    @Provides
    @Singleton
    fun provideGetStocksUseCase(repository: IStocksRepository): GetStocksUseCase {
        return GetStocksUseCase(repository)
    }

}