package com.example.versestockapp.domain.repository

import com.example.versestockapp.data.Response
import com.example.versestockapp.domain.model.Stock

interface IStocksRepository {
    suspend fun getSuccessStocks(): Response<List<Stock>>
    suspend fun getErrorStocks(): Response<List<Stock>>
    suspend fun getEmptyStocks(): Response<List<Stock>>
}