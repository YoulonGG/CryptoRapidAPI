package com.example.cryptorapidapi.presentation.coin_desk

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.cryptorapidapi.data.dto.response.CoinDeskData

/**
 * @Author: John Youlong.
 * @Date: 6/26/25.
 * @Email: johnyoulong@gmail.com.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoinDeskScreen(
    uiState: CoinDeskUiState,
    coinData: List<CoinDeskData?>?,
    onAction: (CoinDeskAction) -> Unit
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        if (uiState.isLoading) {
            Text(
                text = "Loading...",
                modifier = Modifier.padding(20.dp),
                color = Color.Gray
            )
        } else {
            if (coinData?.isEmpty() == true) {
                Text("No data available")
            } else {
                PullToRefreshBox(
                    isRefreshing = uiState.isPullToRefresh,
                    onRefresh = {
                        onAction.invoke(CoinDeskAction.OnRefresh)
                    },
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp),
                    ) {
                        coinData?.forEach {
                            Text(
                                text = it?.title ?: "Unknown Title",
                                modifier = Modifier.padding(bottom = 20.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}