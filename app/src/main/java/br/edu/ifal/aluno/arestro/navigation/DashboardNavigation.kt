package br.edu.ifal.aluno.arestro.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.edu.ifal.aluno.arestro.screens.DashboardScreen

const val dashboardRoute = "DashboardScreen"

fun NavGraphBuilder.homeScreen() {
    composable(dashboardRoute) {
        DashboardScreen()
    }
}

fun NavController.navigateToDashboardScreen() {
    navigate(DashboardRoute)
}