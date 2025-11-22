package br.edu.ifal.aluno.arestro.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.edu.ifal.aluno.arestro.components.base.SearchCard

@Composable
fun SearchScreen(
    navController: NavController,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        SearchCard(
            onSearchClick = { query ->
                println("Buscando por: $query")
            },
            onAdvancedSearchClick = {
                println("Pesquisa avançada clicada")
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        RestaurantListScreen(navController)
    }
}