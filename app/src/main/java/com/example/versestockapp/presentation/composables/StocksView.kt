package com.example.versestockapp.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.versestockapp.R
import com.example.versestockapp.domain.model.Stock
import com.example.versestockapp.presentation.StockItem
import com.example.versestockapp.presentation.viewmodel.StockViewModel
import com.example.versestockapp.presentation.viewmodel.UIState


@Composable
fun StocksView(viewModel: StockViewModel = viewModel()) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {

        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colors.primaryVariant)
                    .padding(12.dp),
                contentAlignment = Alignment.Center

            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.onBackground
                )
            }

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {

                when (val uiState = viewModel.uiState.value) {
                    UIState.Error -> Message(
                        title = stringResource(R.string.error_title),
                        body = stringResource(R.string.error_body),
                        action = { viewModel.loadStocks() },
                        actionName = stringResource(id = R.string.retry)
                    )
                    UIState.Loading -> CircularProgressIndicator(color = MaterialTheme.colors.onBackground)
                    UIState.Empty -> emptyMessage(viewModel)
                    is UIState.Content -> StockListCompose(uiState.stocks)
                }
            }
        }

    }
}

@Composable
private fun emptyMessage(viewModel: StockViewModel) {
    Message(
        title = stringResource(R.string.empty_list_title),
        body = stringResource(R.string.empty_list_body),
        action = { viewModel.loadStocks() },
        actionName = stringResource(id = R.string.retry)
    )
}

@Composable
private fun StockListCompose(stocks: List<Stock>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp)
    ) {
        itemsIndexed(stocks) { index, stock ->
            StockItem(stock)
            if (index < stocks.lastIndex) Divider(
                color = MaterialTheme.colors.onBackground.copy(alpha = 0.2f),
                thickness = 0.5.dp
            )
        }
    }
}