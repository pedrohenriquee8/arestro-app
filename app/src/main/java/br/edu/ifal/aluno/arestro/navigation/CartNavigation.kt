package br.edu.ifal.aluno.arestro.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.edu.ifal.aluno.arestro.screens.CartScreen

const val cartRoute = "cartScreen"

fun NavGraphBuilder.cartScreen() {
    composable(cartRoute) {
        CartScreen()
    }
}

fun NavController.navigateToCartScreen() {
    navigate(cartRoute)
}