package com.example.freetogames.ui
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
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

    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN) {

        composable(
            route = LIST_SCREEN
        ) {
            SearchGamesView(navController)
        }

        composable(
            route = NavRoutes.DETAIL_SCREEN,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val gameId = backStackEntry.arguments?.getInt("id") ?: 0
            val viewModel: DetailGameViewModel = hiltViewModel()
            DetailGameView(navController, gameId, viewModel)
        }
    }
}