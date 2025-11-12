package br.edu.ifal.aluno.arestro.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.edu.ifal.aluno.arestro.components.base.AppLayout
import br.edu.ifal.aluno.arestro.screens.DashboardScreen
import br.edu.ifal.aluno.arestro.screens.CartScreen
import br.edu.ifal.aluno.arestro.screens.OnBoardingScreen
import br.edu.ifal.aluno.arestro.screens.ProfileScreen
import br.edu.ifal.aluno.arestro.screens.SearchScreen
import br.edu.ifal.aluno.arestro.screens.LoginScreen
import br.edu.ifal.aluno.arestro.screens.SignUpScreen
import kotlinx.serialization.Serializable

@Serializable
object OnBoardingRoute

@Serializable
object AppRoute

@Serializable
object HomeRoute

@Serializable
object SearchRoute

@Serializable
object CartRoute

@Serializable
object ProfileRoute

@Serializable
object LoginRoute

@Serializable
object SignUpRoute


@Composable
fun ArestroNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = LoginRoute) {

        composable<LoginRoute>{
            LoginScreen(
                onLoginClick = {
                    navController.navigate(AppRoute) {
                        popUpTo(LoginRoute) { inclusive = true }
                    }
                },
                onSignUpClick = {
                    navController.navigate(SignUpRoute)
                }
            )
        }


        composable<SignUpRoute> {
            SignUpScreen(
                onSignUpClick = {
                    navController.navigate(AppRoute) {
                        popUpTo(LoginRoute) { inclusive = true }
                    }
                },
                onLoginClick = {
                    navController.navigate(LoginRoute)
                }
            )
        }

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

        composable<ProfileRoute> {
            ProfileScreen()
        }
    }
}
