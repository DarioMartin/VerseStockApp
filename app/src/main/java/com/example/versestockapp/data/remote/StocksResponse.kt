package com.example.versestockapp.data.remote

data class StocksResponse(val stocks: List<RemoteStock>)

data class RemoteStock(
    val ticker: String,
    val name: String,
    val currency: String,
    val current_price_cents: Int,
    val quantity: Int? = null,
    val current_price_timestamp: Long
)