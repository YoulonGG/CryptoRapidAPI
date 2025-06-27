package com.example.cryptorapidapi.data.remote.util

import com.example.cryptorapidapi.data.dto.response.BSCNewsResponse
import com.example.cryptorapidapi.data.dto.response.CoinDeskResponse
import com.example.cryptorapidapi.data.remote.common.ApiConstants
import retrofit2.http.GET

/**
 * @Author: John Youlong.
 * @Date: 6/26/25.
 * @Email: johnyoulong@gmail.com.
 */

interface ApiService {

    @GET(ApiConstants.GET_COIN_DESK)
    suspend fun getCoinDesk(): CoinDeskResponse

    @GET(ApiConstants.GET_BSC_NEWS)
    suspend fun getBSCNews(): BSCNewsResponse

}