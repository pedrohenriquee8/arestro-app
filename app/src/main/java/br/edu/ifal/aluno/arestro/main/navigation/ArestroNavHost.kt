package br.edu.ifal.aluno.arestro.main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.edu.ifal.aluno.arestro.main.screens.CartScreen
import br.edu.ifal.aluno.arestro.main.screens.DashboardScreen
import br.edu.ifal.aluno.arestro.main.screens.SearchScreen
import br.edu.ifal.aluno.arestro.main.screens.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
object HomeRoute

@Serializable
object SearchRoute

@Serializable
object CartRoute

@Serializable
object DashboardRoute

@Composable
fun ArestroNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = HomeRoute) {
        composable<HomeRoute> {
            HomeScreen(
                onNavigateFromExploreToDetail = {
                    navController.navigate(DashboardRoute)
                }
            )
        }

        composable<DashboardRoute> {
            DashboardScreen()
        }

        composable<SearchRoute> {
            SearchScreen()
        }

        composable<CartRoute> {
            CartScreen()
        }
    }
}