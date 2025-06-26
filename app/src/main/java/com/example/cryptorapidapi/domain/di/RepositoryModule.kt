package com.example.cryptorapidapi.domain.di

import com.example.cryptorapidapi.data.remote.repositoryImpl.CoinDeskRepositoryImpl
import com.example.cryptorapidapi.domain.repositories.CoinDeskRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @Author: John Youlong.
 * @Date: 6/26/25.
 * @Email: johnyoulong@gmail.com.
 */


@Module
@InstallIn(SingletonComponent::class)
interface
RepositoryModule {

    @Binds
    @Singleton
    fun bindAuthRepository(
        coinDesk: CoinDeskRepositoryImpl
    ): CoinDeskRepository

}