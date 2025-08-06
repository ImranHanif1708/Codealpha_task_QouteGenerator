package com.example.qoutegenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.qoutegenerator.data.QuoteRepository
import com.example.qoutegenerator.data.network.QuoteApiService
import com.example.qoutegenerator.ui.QuoteScreen
import com.example.qoutegenerator.ui.theme.QouteGeneratorTheme
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QouteGeneratorTheme {

                    val viewModel: QuoteViewModel = viewModel()
                    QuoteScreen(viewModel)

            }
        }
    }
}
