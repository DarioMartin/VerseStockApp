package com.example.versestockapp.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.versestockapp.domain.model.Stock
import com.example.versestockapp.domain.model.pricePrinter
import com.example.versestockapp.presentation.theme.VerseStockAppTheme

@Composable
fun StockItem(stock: Stock) {
    Row(modifier = Modifier.padding(vertical = 6.dp)) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = stock.ticker,
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onBackground,
            )
            Text(
                text = stock.name,
                style = MaterialTheme.typography.subtitle1,
                maxLines = 1,
                color = MaterialTheme.colors.onBackground,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Light
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column(horizontalAlignment = Alignment.End) {
            Text(
                text = pricePrinter(stock.priceInCents),
                fontWeight = FontWeight.Black,
                color = MaterialTheme.colors.onBackground,
            )
            Text(text = stock.currency, color = MaterialTheme.colors.onBackground)
        }
    }
}

@Preview
@Composable
fun StockCardPreview() {
    VerseStockAppTheme {
        StockItem(Stock("TS", "Test Stock", "USD", 12374))
    }
}