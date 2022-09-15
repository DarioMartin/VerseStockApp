package com.example.versestockapp.data.repository

import com.example.versestockapp.data.Response
import com.example.versestockapp.domain.model.Stock
import com.example.versestockapp.domain.repository.IStocksRepository

class FakeStocksRepository(
    private val returnError: Boolean = false,
    private val returnEmpty: Boolean = false
) : IStocksRepository {

    private val stocks = listOf(
        Stock("TS1", "Test Stock 1", "USD", 12374),
        Stock("TS2", "Test Stock 2", "EUR", 93837),
        Stock("TS3", "Test Stock 3", "USD", 938)
    )

    override suspend fun getStocks(): Response<List<Stock>> {
        return if (returnError) Response.Error("Network error")
        else if (returnEmpty) Response.Success(data = emptyList())
        else Response.Success(data = stocks)
    }

}