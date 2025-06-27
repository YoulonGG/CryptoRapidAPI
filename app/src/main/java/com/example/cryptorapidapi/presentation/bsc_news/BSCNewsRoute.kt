package com.example.cryptorapidapi.presentation.bsc_news

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

/**
 * @Author: John Youlong.
 * @Date: 6/26/25.
 * @Email: johnyoulong@gmail.com.
 */

@Composable
fun BSCNewsRoute() {
    val viewModel: BSCNewsViewModel = hiltViewModel()
    BSCNewsScreen(
        uiState = viewModel.uiState.collectAsStateWithLifecycle().value,
        onAction = viewModel::onAction,
        bscNewsList = viewModel.getBscNews.collectAsStateWithLifecycle().value
    )
}


data class BscNewsUiState(
    val isLoading: Boolean = true,
    val isPullToRefresh: Boolean = false
)


sealed interface BscNewsAction {
    data object OnRefresh : BscNewsAction
}