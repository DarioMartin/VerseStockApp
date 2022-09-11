package com.example.versestockapp.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.versestockapp.data.Response
import com.example.versestockapp.domain.model.Stock
import com.example.versestockapp.domain.usecases.GetStocksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StockViewModel @Inject constructor(private val getStocksUseCase: GetStocksUseCase) :
    ViewModel() {

    var uiState: MutableState<UIState> = mutableStateOf(UIState.Empty)

    init {
        loadStocks()
    }

    fun loadStocks() {
        uiState.value = UIState.Loading

        viewModelScope.launch {
            when (val response = getStocksUseCase()) {
                is Response.Error -> uiState.value = UIState.Error
                is Response.Success -> {
                    val stocks = response.data
                    uiState.value =
                        if (stocks.isNullOrEmpty()) UIState.Empty else UIState.Content(stocks = stocks)
                }
            }
        }
    }
}

sealed class UIState {
    object Loading : UIState()
    object Error : UIState()
    object Empty : UIState()
    data class Content(val stocks: List<Stock>) : UIState()
}