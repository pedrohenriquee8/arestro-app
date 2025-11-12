package br.edu.ifal.aluno.arestro.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import br.edu.ifal.aluno.arestro.navigation.cartRoute
import br.edu.ifal.aluno.arestro.navigation.homeRoute
import br.edu.ifal.aluno.arestro.navigation.searchRoute

sealed class BottomNavBarItem(
    val label: String,
    val icon: ImageVector,
    val route: String,
) {
    object HomeNavBarItem : BottomNavBarItem(
        label = "Home",
        icon = Icons.Filled.Home,
        route = homeRoute,
    )

    object SearchNavBarItem : BottomNavBarItem(
        label = "Search",
        icon = Icons.Filled.Search,
        route = searchRoute,
    )

    object CartNavBarItem : BottomNavBarItem(
        label = "Cart",
        icon = Icons.Filled.ShoppingCart,
        route = cartRoute,
    )
}