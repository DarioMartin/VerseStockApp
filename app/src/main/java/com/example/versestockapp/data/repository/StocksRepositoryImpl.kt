package com.example.versestockapp.data.repository

import com.example.versestockapp.domain.model.Stock
import com.example.versestockapp.domain.repository.IStocksRepository

class StocksRepositoryImpl(private val remoteDataSource: IRemoteDataSource) :
    IStocksRepository {
    override suspend fun getStocks(): List<Stock> {
        return remoteDataSource.getStocks()
    }

}