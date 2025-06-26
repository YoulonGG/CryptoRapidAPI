package com.example.cryptorapidapi.presentation.coin_desk

import androidx.annotation.Keep
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * @Author: John Youlong.
 * @Date: 6/26/25.
 * @Email: johnyoulong@gmail.com.
 */


@Composable
fun CoinDeskRoute() {
    val viewModel: CoinDeskViewModel = hiltViewModel()
    CoinDeskScreen(
        coinData = viewModel.coinDeskData.collectAsStateWithLifecycle().value,
        uiState = viewModel.uiState.collectAsStateWithLifecycle().value,
        onAction = viewModel::onAction
    )
}

@Keep
data class CoinDeskUiState(
    val isLoading: Boolean = true,
    val isPullToRefresh: Boolean = false
)


sealed interface CoinDeskAction {
    data object OnRefresh: CoinDeskAction
}