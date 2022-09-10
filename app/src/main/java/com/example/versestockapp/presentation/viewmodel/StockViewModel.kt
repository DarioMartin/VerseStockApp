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

    var uiState: MutableState<UIState> = mutableStateOf(UIState.Empty)

    init {
        loadStocks()
    }

    fun loadStocks() = loadItems { useCases.getSuccessStocksUseCase() }

    fun loadError() = loadItems { useCases.getErrorStocksUseCase() }

    fun loadEmpty() = loadItems { useCases.getEmptyStocksUseCase() }

    private fun loadItems(call: suspend () -> Response<List<Stock>>) {
        uiState.value = UIState.Loading

        viewModelScope.launch {
            when (val response = call()) {
                is Response.Error -> {
                    uiState.value = UIState.Error
                }
                is Response.Success -> {
                    uiState.value =
                        response.data?.toMutableList()?.let { UIState.Content(it) } ?: UIState.Empty
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