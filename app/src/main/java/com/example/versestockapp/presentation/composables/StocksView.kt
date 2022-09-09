package com.example.versestockapp.presentation

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
import com.example.versestockapp.presentation.viewmodel.StockViewModel


@Composable
fun StocksView(viewModel: StockViewModel = viewModel()) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {

        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colors.primaryVariant)
                    .padding(top = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.onBackground
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    TextButton(onClick = { viewModel.loadStocks() }) {
                        Text(
                            text = stringResource(R.string.success),
                            color = MaterialTheme.colors.onBackground
                        )
                    }
                    TextButton(onClick = { viewModel.loadError() }) {
                        Text(
                            text = stringResource(R.string.error),
                            color = MaterialTheme.colors.onBackground
                        )
                    }
                    TextButton(onClick = { viewModel.loadEmpty() }) {
                        Text(
                            text = stringResource(R.string.empty),
                            color = MaterialTheme.colors.onBackground
                        )
                    }
                }
            }

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                if (viewModel.loading.value) CircularProgressIndicator(color = MaterialTheme.colors.onBackground)
                else if (viewModel.error.value != null) Message(
                    title = stringResource(R.string.error_title),
                    body = stringResource(R.string.error_body)
                )
                else StockListCompose(viewModel.stocks)
            }
        }

    }
}

@Composable
private fun StockListCompose(stocks: MutableList<Stock>) {
    if (stocks.isEmpty())
        Message(
            title = stringResource(R.string.empty_list_title),
            body = stringResource(R.string.empty_list_body)
        )
    else
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