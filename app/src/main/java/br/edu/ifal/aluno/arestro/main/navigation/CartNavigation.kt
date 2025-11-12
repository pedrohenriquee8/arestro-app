package br.edu.ifal.aluno.arestro.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.edu.ifal.aluno.arestro.main.screens.CartScreen

const val cartRoute = "cartScreen"

fun NavGraphBuilder.cartScreen(navController: NavController) {
    composable(cartRoute) {
        CartScreen()
    }
}

fun NavController.navigateToCartScreen() {
    navigate(cartRoute)
}