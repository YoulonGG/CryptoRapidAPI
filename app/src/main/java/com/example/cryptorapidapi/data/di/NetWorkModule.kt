package com.example.cryptorapidapi.data.di

import com.example.cryptorapidapi.data.remote.intercepters.HeaderInterceptor
import com.example.cryptorapidapi.data.remote.util.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * @Author: John Youlong.
 * @Date: 6/26/25.
 * @Email: johnyoulong@gmail.com.
 */


@Module
@InstallIn(SingletonComponent::class)
object NetWorkModule {


    /*@Provides
    fun provideBaseUrl(): String = "https://cryptocurrency-news2.p.rapidapi.com/"*/

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

//    @Provides
//    @Singleton
//    fun provideHeaderInterceptor(): HeaderInterceptor {
//        return HeaderInterceptor()
//    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://cryptocurrency-news2.p.rapidapi.com/")
            .client(
                OkHttpClient.Builder().apply {
                    writeTimeout(60, TimeUnit.SECONDS)
                    readTimeout(60, TimeUnit.SECONDS)
                    connectTimeout(60, TimeUnit.SECONDS)
                    addInterceptor(HeaderInterceptor())
                    addInterceptor(HttpLoggingInterceptor())
                }.build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}


