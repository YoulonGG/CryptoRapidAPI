package com.example.cryptorapidapi.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.cryptorapidapi.core.navigation.bottom_navigation.BottomNavigationScreen
import com.example.cryptorapidapi.ui.theme.CryptoRapidAPITheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptoRapidAPITheme {
                BottomNavigationScreen()
            }
        }
    }
}



