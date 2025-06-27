package com.example.cryptorapidapi.data.remote.repositoryImpl

import com.example.cryptorapidapi.data.dto.response.CoinDeskResponse
import com.example.cryptorapidapi.data.remote.util.ApiService
import com.example.cryptorapidapi.domain.repositories.CoinDeskRepository
import javax.inject.Inject

/**
 * @Author: John Youlong.
 * @Date: 6/26/25.
 * @Email: johnyoulong@gmail.com.
 */

class CoinDeskRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    CoinDeskRepository {

    override suspend fun getCoinDesk(): CoinDeskResponse {
        return apiService.getCoinDesk()
    }

}