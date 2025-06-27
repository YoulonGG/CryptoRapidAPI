package com.example.cryptorapidapi.data.dto.response


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class BSCNewsResponse(
    @SerializedName("data")
    val `data`: List<BSCNewsData?>?
)


@Keep
data class BSCNewsData(
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