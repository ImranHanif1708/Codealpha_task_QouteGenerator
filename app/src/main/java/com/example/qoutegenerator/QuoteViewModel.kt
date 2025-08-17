package com.example.qoutegenerator

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qoutegenerator.data.QuoteRepository
import com.example.qoutegenerator.data.RandomQuote
import com.example.qoutegenerator.data.RandomQuoteItem
import com.example.qoutegenerator.model.network.RetrofitHelper
import kotlinx.coroutines.launch

sealed interface QuotesUiState {
    data class Success(val quote: RandomQuote) : QuotesUiState
    object Loading : QuotesUiState
    object Error : QuotesUiState
}

class QuoteViewModel : ViewModel() {
    private val apiService = RetrofitHelper.retrofitService
    private val repository = QuoteRepository(apiService)
    var currentQuote : QuotesUiState by mutableStateOf(QuotesUiState.Loading)
        private set

    init {
        loadNewQuote()
        Log.d("QuoteViewModel", "ViewModel initialized, loading new quote")
    }

    fun loadNewQuote() {

        viewModelScope.launch {
            try {
                val result = repository.getRandomQuote()
                if (result.isSuccessful && result.body() != null) {
                    currentQuote = QuotesUiState.Success(result.body()!!)
                } else {
                    Log.e("QuoteViewModel", "Response failed: ${result.code()} - ${result.errorBody()?.string()}")
                    currentQuote = QuotesUiState.Error
                }
            } catch (e: Exception) {
                Log.e("QuoteViewModel", "Error fetching quote: ${e.message}", e)
                currentQuote = QuotesUiState.Error
            }
        }

    }
}