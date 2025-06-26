package com.example.cryptorapidapi.presentation.coin_desk.ui_components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.cryptorapidapi.core.ui_component.NetworkImage
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
            .wrapContentHeight(),
        onClick = {
            onItemClick.invoke()
        },
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            NetworkImage(
                imageUrl = items?.url ?: ""
            )
            Text(
                text = items?.title ?: "",
                color = Color.Black,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(top = 10.dp, bottom = 8.dp)
            )
            Text(
                text = items?.description ?: "",
                color = Color.Black,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(top = 10.dp, bottom = 8.dp)
            )
        }
    }
}


