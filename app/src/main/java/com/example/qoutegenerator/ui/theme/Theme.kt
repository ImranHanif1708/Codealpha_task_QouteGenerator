package com.example.qoutegenerator.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable



private val LightColors = lightColorScheme(
    primary = androidx.compose.ui.graphics.Color(0xFF1B5E20),
    secondary = androidx.compose.ui.graphics.Color(0xFF388E3C),
    background = androidx.compose.ui.graphics.Color(0xFFF1F8E9),
    surface = androidx.compose.ui.graphics.Color.White
)

@Composable
fun QouteGeneratorTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = LightColors, typography = androidx.compose.material3.Typography(), content = content)
}