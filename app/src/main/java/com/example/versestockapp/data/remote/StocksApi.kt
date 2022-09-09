package com.example.versestockapp.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface StocksApi {
    @GET("/cash-homework/cash-stocks-api/portfolio.json")
    suspend fun getStocks(): Response<StocksResponse>
}