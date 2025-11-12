package br.edu.ifal.aluno.arestro.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.edu.ifal.aluno.arestro.screens.HomeScreen

const val homeRoute = "homeScreen"

fun NavGraphBuilder.homeScreen() {
    composable(homeRoute) {
        HomeScreen()
    }
}

fun NavController.navigateToHomeScreen() {
    navigate(homeRoute)
}