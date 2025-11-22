package br.edu.ifal.aluno.arestro.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.ifal.aluno.arestro.screens.SearchScreen

const val searchRoute = "searchScreen"

fun NavGraphBuilder.searchScreen() {
    composable(searchRoute) {
        SearchScreen(
            navController = rememberNavController()
        )
    }
}

fun NavController.navigateToSearchScreen() {
    navigate(searchRoute)
}