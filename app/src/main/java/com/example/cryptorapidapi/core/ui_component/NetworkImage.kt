package com.example.cryptorapidapi.core.ui_component

import android.content.Context
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.error
import coil3.request.fallback
import coil3.request.placeholder
import com.example.cryptorapidapi.R


/**
 * @Author: John Youlong.
 * @Date: 6/26/25.
 * @Email: johnyoulong@gmail.com.
 */


@Composable
fun NetworkImage(
    imageSize: Dp = 200.dp,
    model: ImageRequest
) {
    AsyncImage(
        model = model,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .height(imageSize)
            .fillMaxWidth()
    )
}


fun loadImage(
    context: Context,
    imageUrl: String?,
    placeHolderAndErrorImage: Int = R.drawable.not_found_error,
    size: Int = 500,
): ImageRequest {
    return ImageRequest.Builder(context)
        .data(imageUrl?.takeIf { it.isNotBlank() }) // Ensure not null/empty
//        .decoderFactory(ImageDecoderDecoder.Factory())
        .size(size)
//        .dispatcher(Dispatchers.IO)
        .diskCachePolicy(CachePolicy.ENABLED)
        .memoryCacheKey(imageUrl)
        .diskCacheKey(imageUrl)
        .placeholder(placeHolderAndErrorImage) // Show while loading
        .error(placeHolderAndErrorImage) // Show on error
        .fallback(placeHolderAndErrorImage) // Show if URL is null
        .build()
}