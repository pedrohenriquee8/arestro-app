package br.edu.ifal.aluno.arestro.main.screens

import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import br.edu.ifal.aluno.arestro.main.components.BestOffersList
import br.edu.ifal.aluno.arestro.main.api.RetrofitClient
import br.edu.ifal.aluno.arestro.main.components.SpecialOfferCard
import br.edu.ifal.aluno.arestro.main.components.SearchBarComponent
import br.edu.ifal.aluno.arestro.main.components.RestaurantsNearbyList
import br.edu.ifal.aluno.arestro.main.components.SectionHeader
import br.edu.ifal.aluno.arestro.main.model.FoodItem
import br.edu.ifal.aluno.arestro.main.model.RestaurantItem
import br.edu.ifal.aluno.arestro.main.model.SpecialOfferCard
import kotlinx.coroutines.launch

@Composable
fun DashboardScreen(onNavigateToDetail: (Int) -> Unit = {}) {

    /*val dummyItems = listOf(
        FoodItem(1, "Food 1", "Some Details", 310, ""),
        FoodItem(2, "Food 2", "Some Details", 285, ""),
        FoodItem(3, "Food 3", "Some Details", 350, ""),
        FoodItem(4, "Food 4", "Some Details", 290, ""),
    )*/

    var bestOffers by remember { mutableStateOf(emptyList<FoodItem>()) }
    var nearbyRestaurants by remember { mutableStateOf(emptyList<RestaurantItem>()) }
    var specialOffer by remember { mutableStateOf<SpecialOfferCard?>(null) }

    var isLoading by remember { mutableStateOf(true) }
    var error by remember { mutableStateOf<String?>(null) }

    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        isLoading = true
        error = null
        scope.launch {
            try {
                val fetchedOffers = RetrofitClient.foodApi.getFoods()
                bestOffers = fetchedOffers

                nearbyRestaurants = RetrofitClient.restaurantApi.getRestaurants()
            } catch (e: Exception) {
                error = "Falha ao carregar os dados: ${e.message}"
            } finally {
                isLoading = false
            }
        }
    }

    Scaffold(
        containerColor = Color.White
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {
            item {
                SpecialOfferCard(
                    offer = specialOffer,
                    onBuyNowClick = { Log.d("Dashboard", "Botão Buy Now Clicado") }
                )
            }

            item {
                SearchBarComponent(
                    onSearch = { query -> Log.d("Search", "Pesquisando por: $query") },
                    onVoiceInputClick = { Log.d("Search", "Botão de voz clicado") }
                )
            }

            if (isLoading) {
                item {
                    CircularProgressIndicator(modifier = Modifier.fillMaxWidth().wrapContentWidth(
                        Alignment.CenterHorizontally).padding(32.dp))
                }
            } else if (error != null) {
                item {
                    Text("Erro: $error", color = Color.Red, modifier = Modifier.padding(16.dp))
                }
            } else {
                item {
                    SectionHeader(
                        title = "Best Offers",
                        onSeeAllClick = { Log.d("Dashboard", "See all Best Offers clicked") }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }

                item {
                    BestOffersList(
                        items = bestOffers,
                        onItemClick = { item ->
                            onNavigateToDetail(item.id)
                            Log.d("Dashboard", "Item ${item.name} clicado")
                        }
                    )
                    Spacer(Modifier.height(24.dp))
                }

                item {
                    SectionHeader(
                        title = "Restaurants Nearby",
                        onSeeAllClick = { Log.d("Dashboard", "See all Restaurants Nearby clicked") }
                    )
                }

                item {
                    if (nearbyRestaurants.isEmpty()) {
                        Text(
                            text = "Nenhum restaurante encontrado.",
                            modifier = Modifier.padding(16.dp),
                            color = Color.Gray
                        )
                    } else {
                        RestaurantsNearbyList(
                            items = nearbyRestaurants,
                            onItemClick = { item -> onNavigateToDetail(item.id) }
                        )
                    }
                }
            }
        }
    }
}