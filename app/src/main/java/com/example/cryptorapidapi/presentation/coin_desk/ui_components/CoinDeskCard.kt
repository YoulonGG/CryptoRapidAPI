package com.example.cryptorapidapi.presentation.coin_desk.ui_components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptorapidapi.core.ui_component.NetworkImage
import com.example.cryptorapidapi.core.ui_component.loadImage
import com.example.cryptorapidapi.data.dto.response.CoinDeskData

/**
 * @Author: John Youlong.
 * @Date: 6/26/25.
 * @Email: johnyoulong@gmail.com.
 */


@Composable
fun CoinDeskCard(items: CoinDeskData?, onItemClick: () -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(bottom = 10.dp),
        onClick = {
            onItemClick.invoke()
        },
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            NetworkImage(
                model = loadImage(
                    imageUrl = items?.thumbnail ?: "",
                    context = LocalContext.current
                )
            )
            Text(
                text = items?.title ?: "",
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.W600,
                letterSpacing = 0.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(top = 10.dp, bottom = 4.dp)
            )
            Text(
                text = "Publish Date : ${items?.createdAt}",
                color = Color.Gray,
                fontSize = 14.sp,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.W500,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = items?.description ?: "",
                color = Color.Gray,
                fontSize = 12.sp,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.W400,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding()
            )
        }
    }
}


