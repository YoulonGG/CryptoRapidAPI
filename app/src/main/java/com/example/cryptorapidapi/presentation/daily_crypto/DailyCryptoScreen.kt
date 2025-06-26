package com.example.cryptorapidapi.presentation.daily_crypto

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

/**
 * @Author: John Youlong.
 * @Date: 6/26/25.
 * @Email: johnyoulong@gmail.com.
 */

@Composable
fun DailyCryptoScreen() {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(),
        content = {
            Text(
                text = "Daily Crypto Screen",
                fontSize = 24.sp,
                color = androidx.compose.ui.graphics.Color.Black
            )
        }
    )

}