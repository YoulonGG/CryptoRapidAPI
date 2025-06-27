package com.example.cryptorapidapi.presentation.coin_desk

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.example.cryptorapidapi.data.dto.response.CoinDeskData
import com.example.cryptorapidapi.presentation.coin_desk.ui_components.CoinDeskCard

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

    val context = LocalContext.current

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F0F0)),
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
                            .verticalScroll(rememberScrollState())
                            .fillMaxSize()
                            .padding(20.dp),
                    ) {
                        coinData?.forEach {
                            CoinDeskCard(
                                items = it,
                                onItemClick = {
                                    val urlIntent = Intent(
                                        Intent.ACTION_VIEW,
                                        (it?.url ?: "").toUri()
                                    )
                                    context.startActivity(urlIntent)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}