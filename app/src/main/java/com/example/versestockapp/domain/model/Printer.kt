package com.example.versestockapp.domain.model

import java.lang.Exception
import java.text.DecimalFormat


fun pricePrinter(cents: Int): String {
    val dec = DecimalFormat("#,###.##")

    return try {
        dec.format(cents / 100.0)
    } catch (e: Exception) {
        ""
    }
}