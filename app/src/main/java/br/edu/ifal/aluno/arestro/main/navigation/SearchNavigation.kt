package br.edu.ifal.aluno.arestro.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.edu.ifal.aluno.arestro.main.screens.SearchScreen

const val searchRoute = "searchScreen"

fun NavGraphBuilder.searchScreen(navController: NavController) {
    composable(searchRoute) {
        SearchScreen()
    }
}

fun NavController.navigateToSearchScreen() {
    navigate(searchRoute)
}