package com.example.versestockapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotApplyResult
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.versestockapp.domain.model.Stock
import com.example.versestockapp.presentation.theme.VerseStockAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VerseStockAppTheme {

                val viewModel: StockViewModel by viewModels()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    Column(modifier = Modifier.fillMaxSize()) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Button(onClick = { viewModel.loadStocks() }) {
                                Text(text = "Success")
                            }
                            Button(onClick = { viewModel.loadError() }) {
                                Text(text = "Error")
                            }
                            Button(onClick = { viewModel.loadEmpty() }) {
                                Text(text = "Empty")
                            }
                        }
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            if (viewModel.loading.value) CircularProgressIndicator()
                            else if (viewModel.error.value != null) Text(text = "Error")
                            else {
                                val stocks = viewModel.stocks

                                if (stocks.isEmpty()) Text(text = "Empty")
                                else LazyColumn(modifier = Modifier.fillMaxSize()) {
                                    items(stocks) { stock ->
                                        StockCard(stock)
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun StockCard(stock: Stock) {
    Row(modifier = Modifier.padding(6.dp)) {
        Column() {
            Text(text = stock.ticker, style = MaterialTheme.typography.h6)
            Text(text = stock.name)
        }
        Column(modifier = Modifier.weight(1f)) {
            Text(text = stock.priceInCents.toString())
            Text(text = stock.currency)
        }
    }
}

@Preview
@Composable
fun StockCardPreview() {
    VerseStockAppTheme {
        StockCard(Stock("TS", "Test Stock", "USD", 12374))
    }
}