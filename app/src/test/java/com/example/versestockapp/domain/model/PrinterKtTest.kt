package com.example.versestockapp.domain.model

import com.google.common.truth.Truth.assertThat
import org.junit.Test


internal class PrinterKtTest {

    @Test
    fun `Test zero`() {
        assertThat(pricePrinter(0)).isEqualTo("0,00")
    }

    @Test
    fun `Test only decimals`() {
        assertThat(pricePrinter(10)).isEqualTo("0,10")
    }

    @Test
    fun `Test hundreds without decimals`() {
        assertThat(pricePrinter(89000)).isEqualTo("890,00")
    }

    @Test
    fun `Test hundreds with decimals`() {
        assertThat(pricePrinter(89050)).isEqualTo("890,50")
    }

    @Test
    fun `Test thousands  without decimals`() {
        assertThat(pricePrinter(8905000)).isEqualTo("89.050,00")
    }

    @Test
    fun `Test thousands  with decimals`() {
        assertThat(pricePrinter(8905060)).isEqualTo("89.050,60")
    }

    @Test
    fun `Test millions  without decimals`() {
        assertThat(pricePrinter(890506000)).isEqualTo("8.905.060,00")
    }

    @Test
    fun `Test millions  with decimals`() {
        assertThat(pricePrinter(890506099)).isEqualTo("8.905.060,99")
    }


}