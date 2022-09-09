package com.example.versestockapp.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface StocksApi {
    @GET("/cash-homework/cash-stocks-api/portfolio.json")
    suspend fun getSuccessStocks(): Response<StocksResponse>

    @GET("/cash-homework/cash-stocks-api/portfolio_malformed.json")
    suspend fun getErrorStocks(): Response<StocksResponse>

    @GET("/cash-homework/cash-stocks-api/portfolio_empty.json")
    suspend fun getEmptyStocks(): Response<StocksResponse>
}