package br.edu.ifal.aluno.arestro.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import br.edu.ifal.aluno.arestro.components.base.AppLayout
import br.edu.ifal.aluno.arestro.screens.CartScreen
import br.edu.ifal.aluno.arestro.screens.DashboardScreen
import br.edu.ifal.aluno.arestro.screens.OnBoardingScreen
import br.edu.ifal.aluno.arestro.screens.ProfileScreen
import br.edu.ifal.aluno.arestro.screens.RestaurantDetailScreen
import br.edu.ifal.aluno.arestro.screens.SearchScreen
import kotlinx.serialization.Serializable

@Serializable
object OnBoardingRoute

@Serializable
object AppRoute

@Serializable
object SearchRoute

@Serializable
object CartRoute

@Serializable
object ProfileRoute

@Serializable
object DashboardRoute

@Serializable
data class DetailsRoute(val restaurantId: Int)

@Composable
fun ArestroNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = OnBoardingRoute) {
        composable<OnBoardingRoute> {
            OnBoardingScreen(
                onNavigateToHomePage = {
                    navController.navigate(AppRoute)
                }
            )
        }

        composable<AppRoute> {
            AppLayout(
                onNavigateToProfileScreen = {
                    navController.navigate(ProfileRoute)
                },
                navController = navController
            )
        }

        composable<DashboardRoute> {
            DashboardScreen()
        }

        composable<SearchRoute> {
            SearchScreen(navController)
        }

        composable<CartRoute> {
            CartScreen()
        }

        composable<ProfileRoute> {
            ProfileScreen()
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
