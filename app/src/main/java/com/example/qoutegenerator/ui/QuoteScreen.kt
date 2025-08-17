package com.example.qoutegenerator.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.qoutegenerator.QuotesUiState
import com.example.qoutegenerator.data.RandomQuote

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun QuoteScreen(quotesUiState: QuotesUiState, loadNewQuote: () -> Unit) {

    val gradientBrush = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFe0f7fa), // light cyan
            Color(0xFFb2ebf2), // medium cyan
            Color(0xFF80deea)  // darker cyan
        )
    )

    when (quotesUiState) {
        is QuotesUiState.Loading -> {
            LoadingScreen(gradientBrush)
        }

        is QuotesUiState.Success -> {
            QuoteContent(quote = quotesUiState.quote, loadNewQuote = loadNewQuote, gradientBrush = gradientBrush)
        }

        is QuotesUiState.Error -> {
            ErrorScreen(
                errorMessage = "Failed to load quotes. Please try again.",
                onRetry = loadNewQuote,
                gradientBrush = gradientBrush
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuoteContent(quote: RandomQuote, loadNewQuote : () -> Unit, gradientBrush: Brush) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Random Quote Generator",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            )
        },
        containerColor = Color.Transparent // So background shows through
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(gradientBrush)
                .padding(paddingValues)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()

                    .background(brush = gradientBrush) // Transparent background to show gradient
            ) {
                Card(
                    elevation = CardDefaults.cardElevation(8.dp),
                    shape = MaterialTheme.shapes.medium,
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.95f)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 32.dp, top = 16.dp, start = 16.dp, end = 16.dp)
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .padding(24.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        items(quote) { it ->
                            Text(
                                text = "\"${it.q}\"",
                                style = MaterialTheme.typography.headlineSmall,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(bottom = 16.dp)
                            )
                            Text(
                                text = "- ${it.a}",
                                style = MaterialTheme.typography.bodyMedium,
                                textAlign = TextAlign.End,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }

                    }
                }

                Button(onClick =  loadNewQuote ) {
                    Text("New Quote")
                }
            }
        }
    }
}

@Composable
fun ErrorScreen(
    errorMessage: String,
    onRetry: () -> Unit,
    gradientBrush: Brush
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()

                .background(brush = gradientBrush)
        ) {
            Text(text = errorMessage, color = Color.Red)
            Button(onClick = onRetry) {
                Text("Retry")
            }
        }
    }
}

@Composable
fun LoadingScreen(gradientBrush: Brush) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(brush = gradientBrush)
        ) {
            CircularProgressIndicator()
            Text(
                text = "Loading...",
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center
            )
        }
    }
}