package com.example.versestockapp.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.versestockapp.domain.model.Stock
import com.example.versestockapp.domain.usecases.GetStocksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StockViewModel @Inject constructor(val useCase: GetStocksUseCase) : ViewModel() {

    var stocks: MutableList<Stock> = mutableStateListOf()

    init {
        loadStocks()
    }

    private fun loadStocks() {
        viewModelScope.launch {
            stocks = useCase().toMutableList()
        }
    }
}