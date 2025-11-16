package br.edu.ifal.aluno.arestro.components.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifal.aluno.arestro.model.food.Food
import coil.compose.AsyncImage
import br.edu.ifal.aluno.arestro.R
import br.edu.ifal.aluno.arestro.ui.theme.Gray25
import br.edu.ifal.aluno.arestro.ui.theme.Gray75
import br.edu.ifal.aluno.arestro.ui.theme.Green10
import br.edu.ifal.aluno.arestro.ui.theme.Green75
import br.edu.ifal.aluno.arestro.ui.theme.Green90

@Composable
fun CartCard(
    restaurantName: String?,
    food: Food?,
    quantity: Int = 1,
) {
    var itemQuantity by remember { mutableIntStateOf(quantity) }

    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            AsyncImage(
                model = food?.photoUrl,
                error = painterResource(id = R.drawable.image_not_found),
                contentDescription = food?.name + "image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(Modifier.width(12.dp))
            Column(
                modifier = Modifier.weight(1f),
            ) {
                Text(
                    food?.name ?: "Food name",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    restaurantName ?: "Restaurant name",
                    fontSize = 14.sp,
                    color = Gray25,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    "Rs %.2f".format(food?.price),
                    color = Green75,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 18.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        if (itemQuantity > 1) {
                            itemQuantity--
                        }
                    },
                    modifier = Modifier.size(28.dp),
                    contentPadding = PaddingValues(0.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Green10
                    )
                ) {
                    Icon(
                        imageVector = Icons.Filled.Remove,
                        contentDescription = "Decrease quantity",
                        tint = Green90,
                        modifier = Modifier.size(12.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    itemQuantity.toString(),
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = Gray75,
                )
                Spacer(modifier = Modifier.width(16.dp))
                Button(
                    onClick = {
                        if (itemQuantity < 5) {
                            itemQuantity++
                        }
                    },
                    modifier = Modifier.size(28.dp),
                    contentPadding = PaddingValues(0.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Green90
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Increase quantity",
                        tint = Color.White,
                        modifier = Modifier.size(12.dp)
                    )
                }
            }
        }
    }
}