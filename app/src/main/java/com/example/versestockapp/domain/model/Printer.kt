package com.example.versestockapp.domain.model

import java.util.*


fun pricePrinter(cents: Int): String {
    return try {
        val sb = StringBuilder()
        val formatter = Formatter(sb, Locale.getDefault())
        formatter.format("%(,.2f", cents / 100.00)
        "$sb"
    } catch (e: Exception) {
        ""
    }
}