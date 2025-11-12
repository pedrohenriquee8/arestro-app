package br.edu.ifal.aluno.arestro.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.edu.ifal.aluno.arestro.components.base.AppLayout
import br.edu.ifal.aluno.arestro.screens.OnBoardingScreen
import br.edu.ifal.aluno.arestro.screens.OrderDetailsScreen
import br.edu.ifal.aluno.arestro.screens.ProfileScreen
import kotlinx.serialization.Serializable

@Serializable
object OnBoardingRoute

@Serializable
object AppRoute

@Serializable
object ProfileRoute

@Serializable
object OrderDetailsRoute

@Composable
fun ArestroNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = OrderDetailsRoute) {
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
                }
            )
        }

        composable<OrderDetailsRoute> {
            OrderDetailsScreen()
        }

        composable<ProfileRoute> {
            ProfileScreen()
        }
    }
}
