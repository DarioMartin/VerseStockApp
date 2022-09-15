package com.example.versestockapp.domain.repository

import com.example.versestockapp.data.Response
import com.example.versestockapp.domain.model.Stock

interface IStocksRepository {
    suspend fun getStocks(): Response<List<Stock>>
}