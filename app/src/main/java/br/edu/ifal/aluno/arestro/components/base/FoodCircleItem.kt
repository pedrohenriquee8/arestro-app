package br.edu.ifal.aluno.arestro.components.base

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import br.edu.ifal.aluno.arestro.model.food.Food
import coil.compose.rememberAsyncImagePainter

@Composable
fun FoodCircleItem(food: Food) {
    Column(
        modifier = Modifier
            .padding(end = 12.dp)
            .width(160.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = rememberAsyncImagePainter(food.photoUrl),
            contentDescription = food.name,
            modifier = Modifier
                .size(160.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = food.name,
            style = MaterialTheme.typography.bodySmall,
            maxLines = 1
        )
    }
}
