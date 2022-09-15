package com.example.versestockapp.presentation.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.versestockapp.presentation.theme.VerseStockAppTheme

@Composable
fun Message(title: String, body: String, action: (() -> Unit)? = null, actionName: String? = null) {
    Column(modifier = Modifier.padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = title,
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.onBackground
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = body,
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.onBackground,
            fontWeight = FontWeight.ExtraLight,
            textAlign = TextAlign.Center
        )

        if (action != null && !actionName.isNullOrEmpty()) {
            Spacer(modifier = Modifier.height(36.dp))
            OutlinedButton(onClick = { action() }) {
                Text(text = actionName, color = MaterialTheme.colors.onBackground)
            }
        }

    }
}

@Preview
@Composable
fun MessagePreview() {
    VerseStockAppTheme {
        Message(
            title = "Message title", body = "This is the message body to show.",
            action = {}, actionName = "Action"
        )
    }
}