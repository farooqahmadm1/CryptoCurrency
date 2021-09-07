package co.farooq.cryptocurrency.presentation.components

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.farooq.cryptocurrency.presentation.Screen
import co.farooq.cryptocurrency.presentation.ui.coin_detail.CoinDetailScreen
import co.farooq.cryptocurrency.presentation.ui.coin_list.CoinListScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.CoinListScreen.route
    ) {
        composable(route = Screen.CoinListScreen.route) {
            CoinListScreen(navController = navController)
        }
        composable(route = Screen.CoinDetailScreen.route + "/{coinId}") {
            CoinDetailScreen()
        }
    }
}