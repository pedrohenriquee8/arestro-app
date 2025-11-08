package br.edu.ifal.aluno.arestro.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.edu.ifal.aluno.arestro.screens.OnBoardingScreen
import kotlinx.serialization.Serializable

@Serializable
object OnBoardingRoute

@Composable
fun ArestroNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = OnBoardingRoute) {
        composable<OnBoardingRoute> {
            OnBoardingScreen()
        }
    }
}
