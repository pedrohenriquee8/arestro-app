package br.edu.ifal.aluno.arestro.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import br.edu.ifal.aluno.arestro.ui.theme.Typography
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import br.edu.ifal.aluno.arestro.api.RetrofitClient
import br.edu.ifal.aluno.arestro.components.cart.CartCard
import br.edu.ifal.aluno.arestro.components.cart.Summary
import br.edu.ifal.aluno.arestro.db.DatabaseHelper
import br.edu.ifal.aluno.arestro.model.food.Food
import br.edu.ifal.aluno.arestro.model.order.OrderWithItems
import br.edu.ifal.aluno.arestro.model.restaurant.Restaurant

@Composable
fun CartScreen() {
    val dao = DatabaseHelper.getInstance(context = LocalContext.current).orderDao()

    var orders by remember { mutableStateOf<List<OrderWithItems?>>(emptyList()) }
    var foods by remember { mutableStateOf<Map<Int, Food>>(emptyMap()) }
    var restaurants by remember { mutableStateOf<Map<Int, Restaurant>>(emptyMap()) }

    var isLoading by remember { mutableStateOf(true) }

    val subtotal by remember(orders) {
        derivedStateOf {
            orders.sumOf { it?.order?.totalPrice ?: 0.0 }
        }
    }

    LaunchedEffect(Unit) {
        isLoading = true

        val ordersByUserIdFound = dao.findOrdersByUserId(1)
        orders = ordersByUserIdFound

        val restaurantIds = ordersByUserIdFound.mapNotNull { it?.order?.restaurantId }.distinct()
        val restaurantsFound = restaurantIds.associateWith { id ->
            RetrofitClient.restaurantApi.getRestaurantById(id)
        }
        restaurants = restaurantsFound

        val foodIds = ordersByUserIdFound
            .flatMap { it?.items ?: emptyList() }
            .map { it.foodId }
            .distinct()
        val foodsFound = foodIds.associateWith { id ->
            RetrofitClient.foodApi.getFoodById(id)
        }
        foods = foodsFound

        isLoading = false
    }

    if (isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.systemBars),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }

        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .windowInsetsPadding(WindowInsets.systemBars),
    ) {
        Text("Order Details", style = Typography.headlineSmall)

        if (orders.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("No items in the cart.")
            }
            return
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            orders.forEach { orderItem ->
                val restaurant = restaurants[orderItem?.order?.restaurantId]

                orderItem?.items?.forEach { item ->
                    val food = foods[item.foodId]

                    item {
                        CartCard(restaurant?.name, food)
                    }
                }
            }
        }

        Summary(subtotal)
    }
}