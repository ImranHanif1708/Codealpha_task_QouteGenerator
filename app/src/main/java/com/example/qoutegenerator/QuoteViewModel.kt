package com.example.qoutegenerator

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.qoutegenerator.data.QuoteRepository
import com.example.qoutegenerator.model.Quote
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {
    private val repository = QuoteRepository()
    var currentQuote = mutableStateOf(repository.getRandomQuote())
        private set

    fun loadNewQuote() {
        currentQuote.value = repository.getRandomQuote()
    }
}