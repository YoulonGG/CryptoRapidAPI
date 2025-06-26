package com.example.cryptorapidapi.core.ui_component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade

/**
 * @Author: John Youlong.
 * @Date: 6/26/25.
 * @Email: johnyoulong@gmail.com.
 */


@Composable
fun NetworkImage(
    imageUrl: String,
    imageSize: Dp = 100.dp
) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        contentDescription = null,
        error = {
//            Icon(
//                imageVector = ImageVector.vectorResource(AppIcons.icNoImageFound),
//                contentDescription = null,
//            )
        },
        loading = {
            CircularProgressIndicator()
        },
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .height(imageSize)
            .fillMaxWidth()
    )
}