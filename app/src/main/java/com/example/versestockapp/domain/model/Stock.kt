package com.example.versestockapp.domain.model

data class Stock(
    val ticker: String,
    val name: String,
    val currency: String,
    val priceInCents: Int,
    val quantity: Int? = null
)
