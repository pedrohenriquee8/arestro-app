package br.edu.ifal.aluno.arestro.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifal.aluno.arestro.R
import br.edu.ifal.aluno.arestro.api.RetrofitClient
import br.edu.ifal.aluno.arestro.db.DatabaseHelper
import br.edu.ifal.aluno.arestro.model.food.Food
import br.edu.ifal.aluno.arestro.model.restaurant.Restaurant
import br.edu.ifal.aluno.arestro.model.order.OrderWithItems
import br.edu.ifal.aluno.arestro.model.order.orderItemList
import br.edu.ifal.aluno.arestro.model.order.orderList
import br.edu.ifal.aluno.arestro.ui.theme.Typography
import br.edu.ifal.aluno.arestro.model.order.OrderItem
import br.edu.ifal.aluno.arestro.ui.theme.Gray25
import br.edu.ifal.aluno.arestro.ui.theme.Green90
import coil.compose.AsyncImage

@Composable
fun OrderDetailsScreen() {
    val dao = DatabaseHelper.getInstance(context = LocalContext.current).orderDao()

    var orderWithItems by remember { mutableStateOf<OrderWithItems?>(null) }

    LaunchedEffect(Unit) {
        dao.createOrderWithItems(orderList, orderItemList)
        orderWithItems = dao.findOrderByUserId(1, 1)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {
            Text(
                "Order Details",
                style = Typography.headlineSmall,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Column {
                var restaurant by remember { mutableStateOf<Restaurant?>(null) }

                LaunchedEffect(Unit) {
                    restaurant = RetrofitClient.restaurantApi.getRestaurantById(
                        orderWithItems?.order?.restaurantId ?: 1
                    )
                }

                orderWithItems?.items?.forEach {
                    OrderDetailsItemCard(
                        restaurant = restaurant,
                        item = it,
                        onIncrease = { },
                        onDecrease = { }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
        Column(
            Modifier
                .padding(16.dp)
                .background(
                    color = Green90,
                    shape = RoundedCornerShape(12.dp)
                ),
        ) {
            val subtotal = orderWithItems?.order?.totalPrice ?: 0.0
            val deliveryCharge = 50.00
            val total = subtotal + deliveryCharge

            Spacer(Modifier.height(12.dp))
            SummaryRow("Sub-Total", "Rs ${orderWithItems?.order?.totalPrice ?: 0}")
            Spacer(Modifier.height(4.dp))
            SummaryRow("Delivery Charge", "Rs ${deliveryCharge}")
            Spacer(Modifier.height(4.dp))
            SummaryRow("Discount", "Rs $0")

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp),
                thickness = 1.dp,
                color = Color.White.copy(alpha = 0.3f)
            )

            SummaryRow("Total", "Rs ${total}", bold = true, size = 18)

            Spacer(Modifier.height(8.dp))

            Button(
                onClick = { Log.d("OrderDetailsScreen", "Place My Order clicked") },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                modifier = Modifier.fillMaxWidth().padding(12.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    "Place My Order",
                    color = Green90,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }
}

@Composable
fun OrderDetailsItemCard(
    restaurant: Restaurant?,
    item: OrderItem,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit
) {
    var food by remember { mutableStateOf<Food?>(null) }

    LaunchedEffect(Unit) {
        food = RetrofitClient.foodApi.getFoodById(item.foodId)
    }

    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(12.dp).fillMaxWidth(),
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
                    food?.name ?: "",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    restaurant?.name ?: "",
                    fontSize = 14.sp,
                    color = Gray25,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    "Rs ${item.price}",
                    color = Color(0xFF0D6E3E),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 18.sp
                )
            }
            Spacer(Modifier.width(12.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onDecrease) {
                    Icon(
                        Icons.Default.Delete,
                        contentDescription = "Decrease",
                        modifier = Modifier.size(24.dp),
                        tint = Color(0xFF0D6E3E),
                    )
                }
                Text(
                    item.quantity.toString(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                )
                IconButton(onClick = onIncrease) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "Increase",
                        modifier = Modifier.size(24.dp),
                        tint = Color(0xFF0D6E3E)
                    )
                }
            }
        }
    }
}

@Composable
fun SummaryRow(
    label: String,
    value: String,
    bold: Boolean = false,
    size: Int = 14
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, color = Color.White, fontSize = size.sp)
        Text(
            value,
            color = Color.White,
            fontWeight = if (bold) FontWeight.Bold else FontWeight.Normal,
            fontSize = size.sp
        )
    }
}