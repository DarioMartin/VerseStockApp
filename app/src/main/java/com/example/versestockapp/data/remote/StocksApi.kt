package com.example.versestockapp.data.remote

import com.example.versestockapp.BuildConfig
import retrofit2.Response
import retrofit2.http.GET

interface StocksApi {
    @GET("/cash-homework/cash-stocks-api/${BuildConfig.ENDPOINT}")
    suspend fun getStocks(): Response<StocksResponse>
}