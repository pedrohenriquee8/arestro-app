package br.edu.ifal.aluno.arestro.components.base

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import br.edu.ifal.aluno.arestro.data.model.Restaurant
import coil.compose.rememberAsyncImagePainter

@Composable
fun RestaurantCard(
    restaurant: Restaurant,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(modifier = Modifier.padding(12.dp)) {

            Image(
                painter = rememberAsyncImagePainter(restaurant.imageUrl),
                contentDescription = restaurant.name,
                modifier = Modifier
                    .height(90.dp)
                    .fillMaxWidth(0.28f)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .fillMaxWidth()
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = restaurant.name,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Text(
                        text = "★★★★☆",
                        style = MaterialTheme.typography.bodySmall
                    )
                }

                Text(
                    text = restaurant.address,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary
                )

                Text(
                    text = restaurant.description,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 2
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row {
                        Text("📍 ")
                        Text(
                            text = restaurant.distance,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }

                    Text(
                        text = restaurant.status,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}
