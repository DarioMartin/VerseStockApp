package com.example.versestockapp.data.repository

import com.example.versestockapp.domain.model.Stock

interface IRemoteDataSource {
   suspend fun getStocks(): List<Stock>
}