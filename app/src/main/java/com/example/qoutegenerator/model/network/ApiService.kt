package com.example.qoutegenerator.model.network

import com.example.qoutegenerator.data.RandomQuote
import com.example.qoutegenerator.data.RandomQuoteItem
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import kotlin.getValue

private const val BASE_URL = "https://zenquotes.io/api/"

interface ApiService {
    @GET("random")
    suspend fun getQuotes() : Response<RandomQuote>
}

private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

object RetrofitHelper {
    val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
