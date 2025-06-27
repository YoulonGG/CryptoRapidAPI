package com.example.cryptorapidapi.presentation.bsc_news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptorapidapi.data.dto.response.BSCNewsData
import com.example.cryptorapidapi.domain.repositories.BSCNewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @Author: John Youlong.
 * @Date: 6/26/25.
 * @Email: johnyoulong@gmail.com.
 */


@HiltViewModel
class BSCNewsViewModel @Inject constructor(
    private val bscNewsRepository: BSCNewsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(BscNewsUiState())
    val uiState: StateFlow<BscNewsUiState> = _uiState.asStateFlow()


    private val _getBscNews = MutableStateFlow<List<BSCNewsData?>>(emptyList())
    val getBscNews: StateFlow<List<BSCNewsData?>> = _getBscNews.onStart {
        getBscNews(false)
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )


    fun onAction(event: BscNewsAction) {
        when (event) {
            BscNewsAction.OnRefresh -> {
                getBscNews(true)
            }
        }
    }


    private fun getBscNews(isRefreshing: Boolean) {
        _uiState.update {
            it.copy(isLoading = true, isPullToRefresh = isRefreshing)
        }
        viewModelScope.launch {
            val response = bscNewsRepository.getBSCNews()
            _getBscNews.update { response.data ?: emptyList() }
            _uiState.update {
                it.copy(isLoading = false, isPullToRefresh = false)
            }
        }
    }

}