package br.edu.ifal.aluno.arestro.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.edu.ifal.aluno.arestro.main.screens.HomeScreen

const val homeRoute = "homeScreen"

fun NavGraphBuilder.homeScreen(navController: NavController) {
    composable(homeRoute) {
        HomeScreen()
    }
}

fun NavController.navigateToHomeScreen() {
    navigate(homeRoute)
}