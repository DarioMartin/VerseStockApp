package com.example.versestockapp.data.remote

import com.example.versestockapp.data.repository.IRemoteDataSource
import com.example.versestockapp.data.toDomainStock
import com.example.versestockapp.domain.model.Stock

class ServerDataSource(private val stocksApi: StocksApi) : IRemoteDataSource {
    override suspend fun getStocks(): List<Stock> {
        val serverStocks = stocksApi.getStocks()
        return serverStocks.body()?.stocks?.map { it.toDomainStock() } ?: emptyList()
    }
}