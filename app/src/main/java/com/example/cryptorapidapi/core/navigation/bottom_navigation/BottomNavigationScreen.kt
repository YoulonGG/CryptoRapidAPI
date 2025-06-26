package com.example.cryptorapidapi.core.navigation.bottom_navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.example.cryptorapidapi.core.navigation.graph.ROUTE
import com.example.cryptorapidapi.presentation.bsc_news.BSCNewsRoute
import com.example.cryptorapidapi.presentation.coin_desk.CoinDeskRoute
import com.example.cryptorapidapi.presentation.daily_crypto.DailyCryptoRoute

/**
 * @Author: John Youlong.
 * @Date: 6/26/25.
 * @Email: johnyoulong@gmail.com.
 */

@Composable
fun BottomNavigationScreen() {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->

        val graph =
            navController.createGraph(startDestination = ROUTE.COIN_DESK) {
                composable(route = ROUTE.COIN_DESK) {
                    CoinDeskRoute()
                }
                composable(route = ROUTE.CRYPTO_DAILY) {
                    DailyCryptoRoute()
                }
                composable(route = ROUTE.BSC_NEWS) {
                    BSCNewsRoute()
                }

            }
        NavHost(
            navController = navController,
            graph = graph,
            modifier = Modifier.padding(innerPadding)
        )

    }
}