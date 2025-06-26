package com.example.cryptorapidapi.presentation.coin_desk

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptorapidapi.data.dto.response.CoinDeskData
import com.example.cryptorapidapi.domain.repositories.CoinDeskRepository
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
class CoinDeskViewModel @Inject constructor(
    private val coinDeskRepository: CoinDeskRepository
) : ViewModel() {


    private val _uiState = MutableStateFlow(CoinDeskUiState())
    val uiState: StateFlow<CoinDeskUiState> = _uiState.asStateFlow()

    private val _coinDeskData = MutableStateFlow<List<CoinDeskData?>?>(emptyList())
    val coinDeskData = _coinDeskData.onStart {
        getCoinDesk()
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = null
    )


    fun onAction(event: CoinDeskAction) {
        when (event) {
            CoinDeskAction.OnRefresh -> {
                getCoinDesk(true)
            }
        }
    }


    private fun getCoinDesk(isPullToRefresh: Boolean = false) {
        _uiState.update {
            it.copy(isLoading = true, isPullToRefresh = isPullToRefresh)
        }
        viewModelScope.launch {
            try {
                val response = coinDeskRepository.getCoinDesk()
                _coinDeskData.update { response.data }
                _uiState.update {
                    it.copy(isLoading = false, isPullToRefresh = false)
                }
            } catch (
                e: Exception
            ) {
                _uiState.update {
                    it.copy(isLoading = false, isPullToRefresh = false)
                }
                e.printStackTrace()
            }
        }
    }
}