package com.example.versestockapp.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.versestockapp.MainCoroutineRule
import com.example.versestockapp.data.repository.FakeStocksRepository
import com.example.versestockapp.domain.usecases.GetStocksUseCase
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class StockViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: StockViewModel

    @Test
    fun `test success state`() = runTest {
        val repository = FakeStocksRepository()
        viewModel = StockViewModel(GetStocksUseCase(repository))

        val state = viewModel.uiState.value
        Truth.assertThat(state).isInstanceOf(UIState.Content::class.java)
    }

    @Test
    fun `test error state`() = runTest {
        val repository = FakeStocksRepository(returnError = true)
        viewModel = StockViewModel(GetStocksUseCase(repository))

        val state = viewModel.uiState.value
        Truth.assertThat(state).isInstanceOf(UIState.Error::class.java)
    }

    @Test
    fun `test empty state`() = runTest {
        val repository = FakeStocksRepository(returnEmpty = true)
        viewModel = StockViewModel(GetStocksUseCase(repository))

        val state = viewModel.uiState.value
        Truth.assertThat(state).isInstanceOf(UIState.Empty::class.java)
    }
}