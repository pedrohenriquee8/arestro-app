package br.edu.ifal.aluno.arestro.components.base

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import br.edu.ifal.aluno.arestro.data.model.Food

@Composable
fun BestOffersSection(foods: List<Food>) {
    Column(modifier = Modifier.padding(start = 16.dp, top = 8.dp)) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Best Offers",
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = "See all",
                style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.primary),
                modifier = Modifier.padding(end = 16.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        LazyRow {
            items(foods) { food ->
                FoodCircleItem(food)
            }
        }
    }
}
