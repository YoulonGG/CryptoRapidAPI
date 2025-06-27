package com.example.cryptorapidapi.domain.repositories

import com.example.cryptorapidapi.data.dto.response.BSCNewsResponse

/**
 * @Author: John Youlong.
 * @Date: 6/27/25.
 * @Email: johnyoulong@gmail.com.
 */

interface BSCNewsRepository {
    suspend fun getBSCNews(): BSCNewsResponse
}