package com.example.cryptorapidapi.domain.repositories

import com.example.cryptorapidapi.data.dto.response.CoinDeskResponse

/**
 * @Author: John Youlong.
 * @Date: 6/26/25.
 * @Email: johnyoulong@gmail.com.
 */
interface CoinDeskRepository {
    suspend fun getCoinDesk(): CoinDeskResponse
}