package com.example.versestockapp.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.versestockapp.data.Response
import com.example.versestockapp.domain.model.Stock
import com.example.versestockapp.domain.usecases.StocksUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StockViewModel @Inject constructor(private val useCases: StocksUseCases) : ViewModel() {

    var stocks: MutableList<Stock> = mutableStateListOf()
    var loading = mutableStateOf(false)
    var error: MutableState<Unit?> = mutableStateOf(null)

    init {
        loadStocks()
    }

    fun loadStocks() = loadItems { useCases.getSuccessStocksUseCase() }

    fun loadError() = loadItems { useCases.getErrorStocksUseCase() }

    fun loadEmpty() = loadItems { useCases.getEmptyStocksUseCase() }

    private fun loadItems(call: suspend () -> Response<List<Stock>>) {
        loading.value = true
        error.value = null

        viewModelScope.launch {
            stocks.clear()
            val response = call()
            loading.value = false

            when (response) {
                is Response.Error -> {
                    error.value = Unit
                }
                is Response.Success -> {
                    stocks.addAll(response.data?.toMutableList() ?: emptyList())
                }
            }
        }
    }

}