package com.example.versestockapp.data.remote

import com.example.versestockapp.data.repository.IRemoteDataSource
import com.example.versestockapp.domain.model.Stock

class ServerDataSource : IRemoteDataSource {
    override suspend fun getStocks(): List<Stock> {
        return listOf(
            Stock("TS", "Test Stock", "EUR", 123),
            Stock("TS2", "Test Stock 2", "EUR", 123)
        )
    }
}