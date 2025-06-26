package com.example.cryptorapidapi.core.navigation.graph

/**
 * @Author: John Youlong.
 * @Date: 6/26/25.
 * @Email: johnyoulong@gmail.com.
 */

sealed class Screen(val route: String) {
    data object CoinDesk: Screen(ROUTE.COIN_DESK)
    data object CryptoDaily: Screen(ROUTE.CRYPTO_DAILY)
    data object BSCNews: Screen(ROUTE.BSC_NEWS)
}


object ROUTE {
    const val COIN_DESK = "coin_desk_screen"
    const val CRYPTO_DAILY = "crypto_daily_screen"
    const val BSC_NEWS = "BSC_news_screen"
}