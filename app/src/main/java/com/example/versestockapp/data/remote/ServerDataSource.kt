package com.example.versestockapp.data.remote

import com.example.versestockapp.data.Response
import com.example.versestockapp.data.repository.IRemoteDataSource
import com.example.versestockapp.data.toDomainStock
import com.example.versestockapp.domain.model.Stock
import java.lang.Exception

class ServerDataSource(private val stocksApi: StocksApi) : IRemoteDataSource {

    override suspend fun getStocks(): Response<List<Stock>> {
        return try {
            val serverStocks = stocksApi.getStocks()
            val stocks = serverStocks.body()?.stocks?.map { it.toDomainStock() } ?: emptyList()
            Response.Success(data = stocks)
        } catch (e: Exception) {
            Response.Error("Could not load the stocks")
        }
    }
}