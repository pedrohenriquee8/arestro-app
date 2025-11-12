package br.edu.ifal.aluno.arestro.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.edu.ifal.aluno.arestro.components.base.Layout
import br.edu.ifal.aluno.arestro.screens.CartScreen
import br.edu.ifal.aluno.arestro.screens.HomeScreen
import br.edu.ifal.aluno.arestro.screens.OnBoardingScreen
import br.edu.ifal.aluno.arestro.screens.SearchScreen
import kotlinx.serialization.Serializable

@Serializable
object OnBoardingRoute

@Serializable
object HomeRoute

@Serializable
object SearchRoute

@Serializable
object CartRoute

@Composable
fun ArestroNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = HomeRoute) {
        composable<OnBoardingRoute> {
            Layout(navController = navController)
        }

        composable<HomeRoute> {
            Layout(showAppBar = true, showBottomBar = true, navController = navController)
        }

        composable<SearchRoute> {
            Layout(showAppBar = true, showBottomBar = true, navController = navController)
        }

        composable<CartRoute> {
            Layout(showAppBar = true, showBottomBar = true, navController = navController)
        }
    }
}
