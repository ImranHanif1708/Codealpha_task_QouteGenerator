package com.example.qoutegenerator.data

import com.example.qoutegenerator.model.network.ApiService
import com.example.qoutegenerator.model.network.RetrofitHelper
import retrofit2.Response

class QuoteRepository(val quotesService: ApiService) {
    suspend fun getRandomQuote() = quotesService.getQuotes()
}