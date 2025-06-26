package com.example.cryptorapidapi.data.dto.response


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class CoinDeskResponse(
    @SerializedName("data")
    val `data`: List<CoinDeskData?>?
)

@Keep
data class CoinDeskData(
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("thumbnail")
    val thumbnail: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("url")
    val url: String?
)