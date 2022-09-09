package com.example.versestockapp.domain.repository

import com.example.versestockapp.domain.model.Stock

interface IStocksRepository {
    suspend fun getStocks(): List<Stock>
}