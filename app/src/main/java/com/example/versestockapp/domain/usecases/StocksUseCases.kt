package com.example.versestockapp.domain.usecases

data class StocksUseCases(
    val getSuccessStocksUseCase: GetSuccessStocksUseCase,
    val getErrorStocksUseCase: GetErrorStocksUseCase,
    val getEmptyStocksUseCase: GetEmptyStocksUseCase
)