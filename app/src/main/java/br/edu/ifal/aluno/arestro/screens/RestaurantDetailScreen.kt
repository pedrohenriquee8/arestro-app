package br.edu.ifal.aluno.arestro.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.edu.ifal.aluno.arestro.R
import br.edu.ifal.aluno.arestro.components.base.AppBar
import br.edu.ifal.aluno.arestro.components.base.BestOffersSection
import br.edu.ifal.aluno.arestro.components.base.FloatingWideButton
import br.edu.ifal.aluno.arestro.data.model.Restaurant
import br.edu.ifal.aluno.arestro.data.model.foodList
import br.edu.ifal.aluno.arestro.navigation.SearchRoute
import coil.compose.rememberAsyncImagePainter


@Composable
fun RestaurantDetailScreen(navController: NavController, restaurantId: Int) {

    val restaurant = when (restaurantId) {
        1 -> Restaurant(1, "Sabor Nordestino", "Rua das Flores, 123", "Comida regional deliciosa", "https://picsum.photos/300/200", "Aberto", "1.2 km")
        2 -> Restaurant(2, "Itália Grill", "Av. Central, 45", "Massas e pizzas artesanais", "https://picsum.photos/301/200", "Fechado", "3.5 km")
        else -> Restaurant(3, "Praia Bar", "Orla Marítima, 789", "Petiscos e drinks à beira-mar", "https://picsum.photos/302/200", "Aberto", "2.8 km")
    }

    Scaffold(
        topBar = { AppBar() }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxWidth()
                .pointerInput(Unit) {
                    detectHorizontalDragGestures { _, dragAmount ->
                        if (dragAmount > 50) {
                            navController.popBackStack(SearchRoute, false)
                        }
                    }
                }
                .verticalScroll(rememberScrollState())
        ) {

            Image(
                painter = rememberAsyncImagePainter(restaurant.imageUrl),
                contentDescription = restaurant.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(16.dp)) {

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = restaurant.name,
                        style = MaterialTheme.typography.headlineSmall
                    )

                    Row {
                        repeat(4) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_star_filled),
                                contentDescription = "Star",
                                tint = Color(0xFFFFB300),
                                modifier = Modifier.size(20.dp)
                            )
                        }
                        Icon(
                            painter = painterResource(id = R.drawable.ic_star_outline),
                            contentDescription = "Star",
                            tint = Color(0xFFFFB300),
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_location),
                            contentDescription = "Location",
                            tint = Color(0xFF4CAF50),
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = restaurant.distance, style = MaterialTheme.typography.bodyMedium)
                    }

                    Text(
                        text = "View on Google Maps",
                        color = Color(0xFF7C4DFF),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Description",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = restaurant.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Facilities",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(12.dp))

                Row(modifier = Modifier.fillMaxWidth()) {

                    Column(modifier = Modifier.weight(1f)) {
                        FacilityItem("Snack bar")
                        FacilityItem("Bikes and Car Parking")
                    }

                    Column(modifier = Modifier.weight(1f)) {
                        FacilityItem("Toilet")
                        FacilityItem("24/7 Water facility")
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))

                BestOffersSection(
                    foods = foodList.filter { it.restaurant_id == restaurant.id }
                )

                FloatingWideButton(
                    text = "View Available Tables",
                    onClick = {}
                )
            }
        }
    }
}

@Composable
fun FacilityItem(text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_check),
            contentDescription = null,
            tint = Color(0xFF4CAF50),
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(text = text, style = MaterialTheme.typography.bodyMedium)
    }
}
