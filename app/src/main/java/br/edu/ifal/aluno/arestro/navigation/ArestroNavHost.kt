package br.edu.ifal.aluno.arestro.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import br.edu.ifal.aluno.arestro.components.base.AppLayout
import br.edu.ifal.aluno.arestro.screens.OnBoardingScreen
import br.edu.ifal.aluno.arestro.screens.RestaurantDetailScreen
import kotlinx.serialization.Serializable

@Serializable
object OnBoardingRoute

@Serializable
object HomeRoute

@Serializable
data class DetailsRoute(val restaurantId: Int)

@Composable
fun ArestroNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = OnBoardingRoute) {

        composable<OnBoardingRoute> {
            OnBoardingScreen(
                onNavigateToHomePage = {
                    navController.navigate(HomeRoute)
                }
            )
        }

        composable<HomeRoute> {
            AppLayout(navController = navController)
        }

        composable<DetailsRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<DetailsRoute>()

            RestaurantDetailScreen(
                navController = navController,
                restaurantId = route.restaurantId
            )
        }
    }
}
