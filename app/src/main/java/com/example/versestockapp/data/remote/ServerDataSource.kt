package com.example.versestockapp.data.remote

import com.example.versestockapp.data.Response
import com.example.versestockapp.data.repository.IRemoteDataSource
import com.example.versestockapp.data.toDomainStock
import com.example.versestockapp.domain.model.Stock
import java.lang.Exception

class ServerDataSource(private val stocksApi: StocksApi) : IRemoteDataSource {
    override suspend fun getSuccessStocks(): Response<List<Stock>> {
        return try {
            val serverStocks = stocksApi.getSuccessStocks()
            val stocks = serverStocks.body()?.stocks?.map { it.toDomainStock() } ?: emptyList()
            return Response.Success(data = stocks)
        } catch (e: Exception) {
            return Response.Error("Could not load the stocks")
        }
    }

    override suspend fun getErrorStocks(): Response<List<Stock>> {
        return try {
            val serverStocks = stocksApi.getErrorStocks()
            val stocks = serverStocks.body()?.stocks?.map { it.toDomainStock() } ?: emptyList()
            return Response.Success(data = stocks)
        } catch (e: Exception) {
            return Response.Error("Could not load the stocks")
        }
    }

    override suspend fun getEmptyStocks(): Response<List<Stock>> {
        return try {
            val serverStocks = stocksApi.getEmptyStocks()
            val stocks = serverStocks.body()?.stocks?.map { it.toDomainStock() } ?: emptyList()
            return Response.Success(data = stocks)
        } catch (e: Exception) {
            return Response.Error("Could not load the stocks")
        }
    }
}