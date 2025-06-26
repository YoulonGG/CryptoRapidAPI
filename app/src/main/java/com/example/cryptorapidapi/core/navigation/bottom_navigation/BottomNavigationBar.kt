package com.example.cryptorapidapi.core.navigation.bottom_navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import com.example.cryptorapidapi.R
import com.example.cryptorapidapi.core.navigation.graph.ROUTE

/**
 * @Author: John Youlong.
 * @Date: 6/26/25.
 * @Email: johnyoulong@gmail.com.
 */

data class NavigationItem(
    val title: String, val icon: Int, val route: String
)

@Composable
fun BottomNavigationBar(navController: NavController) {
    val selectedNavigationIndex = rememberSaveable {
        mutableIntStateOf(0)
    }

    val navigationItems = listOf(
        NavigationItem(
            title = "Coin Desk", icon = R.drawable.baseline_android_24, route = ROUTE.COIN_DESK
        ),
        NavigationItem(
            title = "Crypto Daily",
            icon = R.drawable.baseline_android_24,
            route = ROUTE.CRYPTO_DAILY
        ),
        NavigationItem(
            title = "BSC News", icon = R.drawable.baseline_android_24, route = ROUTE.BSC_NEWS
        ),
    )

    NavigationBar(
        containerColor = Color.White
    ) {
        navigationItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedNavigationIndex.intValue == index, onClick = {
                    selectedNavigationIndex.intValue = index
                    navController.navigate(item.route)
                }, icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(item.icon),
                        contentDescription = item.title,
                        tint = if (index == selectedNavigationIndex.intValue) MaterialTheme.colorScheme.primary
                        else Color.Gray
                    )

                }, label = {
                    Text(
                        item.title,
                        color = if (index == selectedNavigationIndex.intValue) Color.Black
                        else Color.Gray
                    )
                }, colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.surface,
                )

            )
        }
    }
}