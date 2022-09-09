package com.example.versestockapp.data

import com.example.versestockapp.data.remote.RemoteStock
import com.example.versestockapp.domain.model.Stock

fun RemoteStock.toDomainStock(): Stock {
    return Stock(
        ticker = this.ticker,
        name = this.name,
        currency = this.currency,
        priceInCents = this.current_price_cents,
        quantity = this.quantity
    )
}