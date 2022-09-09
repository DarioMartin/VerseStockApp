package com.example.versestockapp.data.repository

import com.example.versestockapp.data.Response
import com.example.versestockapp.domain.model.Stock
import com.example.versestockapp.domain.repository.IStocksRepository

class StocksRepositoryImpl(private val remoteDataSource: IRemoteDataSource) :
    IStocksRepository {
    override suspend fun getSuccessStocks(): Response<List<Stock>> {
        return remoteDataSource.getSuccessStocks()
    }

    override suspend fun getErrorStocks(): Response<List<Stock>> {
        return remoteDataSource.getErrorStocks()
    }

    override suspend fun getEmptyStocks(): Response<List<Stock>> {
        return remoteDataSource.getEmptyStocks()
    }

}