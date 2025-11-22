package br.edu.ifal.aluno.arestro.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.edu.ifal.aluno.arestro.api.RetrofitClient
import br.edu.ifal.aluno.arestro.components.base.RestaurantCard
import br.edu.ifal.aluno.arestro.model.restaurant.Restaurant
import br.edu.ifal.aluno.arestro.navigation.DetailsRoute

@Composable
fun RestaurantListScreen(
    navController: NavController,
) {
    var restaurants by remember { mutableStateOf(emptyList<Restaurant>()) }
    LaunchedEffect(Unit) {
        restaurants = RetrofitClient.restaurantApi.getRestaurants()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp, horizontal = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Popular Restaurants",
                    style = MaterialTheme.typography.titleLarge
                )

                Text(
                    text = "${restaurants.size} results",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }
        }
        items(restaurants) { restaurant ->
            RestaurantCard(
                restaurant = restaurant,
                onClick = {
                    navController.navigate(DetailsRoute(restaurant.id))
                }
            )
        }
    }
}