package br.edu.ifal.aluno.arestro.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.edu.ifal.aluno.arestro.components.base.PrimaryButton
import br.edu.ifal.aluno.arestro.data.model.Restaurant
import coil.compose.rememberAsyncImagePainter

@Composable
fun RestaurantDetailScreen(navController: NavController, restaurantId: Int) {
    val restaurant = when (restaurantId) {
        1 -> Restaurant(1, "Sabor Nordestino", "Rua das Flores, 123", "Comida regional deliciosa", "https://picsum.photos/300/200", "Aberto", "1.2 km")
        2 -> Restaurant(2, "Itália Grill", "Av. Central, 45", "Massas e pizzas artesanais", "https://picsum.photos/301/200", "Fechado", "3.5 km")
        else -> Restaurant(3, "Praia Bar", "Orla Marítima, 789", "Petiscos e drinks à beira-mar", "https://picsum.photos/302/200", "Aberto", "2.8 km")
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Image(
            painter = rememberAsyncImagePainter(restaurant.imageUrl),
            contentDescription = restaurant.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(text = restaurant.name, style = MaterialTheme.typography.titleLarge)
        Text(text = restaurant.address, style = MaterialTheme.typography.bodyMedium)
        Text(text = restaurant.description, style = MaterialTheme.typography.bodyMedium)
        Text(text = "Status: ${restaurant.status}")
        Text(text = "Distância: ${restaurant.distance}")

        Spacer(modifier = Modifier.height(16.dp))

        PrimaryButton(text = "Voltar") {
            navController.popBackStack()
        }
    }
}
