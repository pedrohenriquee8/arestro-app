package br.edu.ifal.aluno.arestro.main.components
import android.R.attr.clickable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import br.edu.ifal.aluno.arestro.main.model.FoodItem
import coil.compose.AsyncImage

@Composable
fun FoodCardItem(
    item: FoodItem,
    scale: Float,
    onItemClick: (FoodItem) -> Unit,
    modifier: Modifier = Modifier
) {

    val cardWidth = 150.dp
    val imageSize = 120.dp
    val imageOffset = imageSize / 2

    Box(
        modifier = modifier
            .width(cardWidth)
            .height(260.dp)
            .padding(horizontal = 8.dp)
            .graphicsLayer(scaleX = scale, scaleY = scale)
            .clickable { onItemClick(item) },
        contentAlignment = Alignment.TopCenter
    ) {
        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(top = imageOffset)
                .align(Alignment.Center)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .padding(top = imageOffset + 8.dp, bottom = 12.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(item.name, fontWeight = FontWeight.SemiBold)
                Text(item.description, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
                Spacer(Modifier.height(4.dp))
                Text("R$ ${item.price}", color = Color(0xFF4CAF50), fontWeight = FontWeight.Bold)
            }
        }

        Box(
            modifier = Modifier
                .size(imageSize)
                .clip(CircleShape)
                .background(Color.White)
                .padding(4.dp)
                .clip(CircleShape)
                .align(Alignment.TopCenter)
                .zIndex(1f)
        ) {
            AsyncImage(
                model = item.photo_url,
                contentDescription = item.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}