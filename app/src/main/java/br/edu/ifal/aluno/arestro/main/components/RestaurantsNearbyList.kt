package br.edu.ifal.aluno.arestro.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import br.edu.ifal.aluno.arestro.main.model.RestaurantItem

@Composable
fun RestaurantsNearbyList(
    items: List<RestaurantItem>,
    onItemClick: (RestaurantItem) -> Unit
) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items) { item ->
            RestaurantCard(item = item, onItemClick = onItemClick)
        }
    }
}