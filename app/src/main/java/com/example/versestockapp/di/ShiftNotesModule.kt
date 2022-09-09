package com.example.versestockapp.di

import com.example.versestockapp.data.remote.ServerDataSource
import com.example.versestockapp.data.remote.StocksApi
import com.example.versestockapp.data.repository.IRemoteDataSource
import com.example.versestockapp.data.repository.StocksRepositoryImpl
import com.example.versestockapp.domain.repository.IStocksRepository
import com.example.versestockapp.domain.usecases.GetStocksUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StocksModule {

    @Provides
    @Singleton
    fun provideStocksRepository(remoteDataSource: IRemoteDataSource): IStocksRepository {
        return StocksRepositoryImpl(remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideGetStocksUseCase(repository: IStocksRepository): GetStocksUseCase {
        return GetStocksUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(): IRemoteDataSource {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://storage.googleapis.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return ServerDataSource(retrofit.create(StocksApi::class.java))
    }

}