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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.edu.ifal.aluno.arestro.components.base.RestaurantCard
import br.edu.ifal.aluno.arestro.data.model.Restaurant

@Composable
fun RestaurantListScreen(navController: NavController) {

    val restaurants = listOf(
        Restaurant(1, "Sabor Nordestino", "Rua das Flores, 123", "Comida regional deliciosa", "https://picsum.photos/300/200", "Aberto", "1.2 km"),
        Restaurant(2, "Itália Grill", "Av. Central, 45", "Massas e pizzas artesanais", "https://picsum.photos/301/200", "Fechado", "3.5 km"),
        Restaurant(3, "Praia Bar", "Orla Marítima, 789", "Petiscos e drinks à beira-mar", "https://picsum.photos/302/200", "Aberto", "2.8 km")
    )

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
                onClick = { navController.navigate("details/${restaurant.id}") }
            )
        }
    }
}
