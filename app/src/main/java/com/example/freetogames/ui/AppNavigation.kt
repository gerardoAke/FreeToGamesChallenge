package com.example.freetogames.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.freetogames.ui.NavRoutes.LIST_SCREEN
import com.example.freetogames.viewModels.DetailGameViewModel

object NavRoutes {
    const val LIST_SCREEN = "list_screen"
    const val DETAIL_SCREEN = "detail_screen/{id}"
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoutes.LIST_SCREEN) {
        composable(NavRoutes.LIST_SCREEN) {
            SearchGamesView(navController)
        }

        composable(NavRoutes.DETAIL_SCREEN,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val gameId = backStackEntry.arguments?.getInt("id") ?: 0
            DetailGameView(gameId, onGameRemoved = {
                navController.navigate(LIST_SCREEN)
            })
        }
    }
}