package com.example.versestockapp.domain.usecases

import com.example.versestockapp.data.Response
import com.example.versestockapp.domain.model.Stock
import com.example.versestockapp.domain.repository.IStocksRepository

class GetErrorStocksUseCase(private val repository: IStocksRepository) {

    suspend operator fun invoke(): Response<List<Stock>> {
        return repository.getErrorStocks()
    }

}