package com.example.cryptorapidapi.data.remote.repositoryImpl

import com.example.cryptorapidapi.data.dto.response.BSCNewsResponse
import com.example.cryptorapidapi.data.remote.util.ApiService
import com.example.cryptorapidapi.domain.repositories.BSCNewsRepository
import javax.inject.Inject

/**
 * @Author: John Youlong.
 * @Date: 6/27/25.
 * @Email: johnyoulong@gmail.com.
 */
class BSCNewsRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    BSCNewsRepository {

    override suspend fun getBSCNews(): BSCNewsResponse {
        return apiService.getBSCNews()
    }

}