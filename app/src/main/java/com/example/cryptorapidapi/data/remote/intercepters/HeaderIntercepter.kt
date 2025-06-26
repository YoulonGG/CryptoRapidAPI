package com.example.cryptorapidapi.data.remote.intercepters

import okhttp3.Interceptor
import okhttp3.Response

/**
 * @Author: John Youlong.
 * @Date: 6/26/25.
 * @Email: johnyoulong@gmail.com.
 */


class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()
            .header("x-rapidapi-host", "cryptocurrency-news2.p.rapidapi.com")
            .header("x-rapidapi-key", "a3515dd69dmshacfb4f2ace81fefp18b441jsna425f8c6dc38")
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}