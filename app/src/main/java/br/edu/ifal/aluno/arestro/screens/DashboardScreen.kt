package br.edu.ifal.aluno.arestro.screens

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.edu.ifal.aluno.arestro.api.RetrofitClient
import br.edu.ifal.aluno.arestro.components.base.food.BestOffersList
import br.edu.ifal.aluno.arestro.components.base.restaurant.RestaurantsNearbyList
import br.edu.ifal.aluno.arestro.components.base.searchBar.SearchBarComponent
import br.edu.ifal.aluno.arestro.components.base.SectionHeader
import br.edu.ifal.aluno.arestro.model.food.Food
import br.edu.ifal.aluno.arestro.model.restaurant.Restaurant
import br.edu.ifal.aluno.arestro.model.specialOfferCard.SpecialOfferCard
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun DashboardScreen(onNavigateToDetail: (Int) -> Unit = {}) {
    var bestOffers by remember { mutableStateOf(emptyList<Food>()) }
    var nearbyRestaurants by remember { mutableStateOf(emptyList<Restaurant>()) }
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
        containerColor = Color.Companion.White,
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.Companion.padding(innerPadding)
        ) {
            item {
                br.edu.ifal.aluno.arestro.components.base.food.SpecialOfferCard(
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
                    CircularProgressIndicator(
                        modifier = Modifier.Companion
                            .fillMaxWidth()
                            .wrapContentWidth(
                                Alignment.Companion.CenterHorizontally
                            )
                            .padding(32.dp)
                    )
                }
            } else if (error != null) {
                item {
                    Text(
                        "Erro: $error",
                        color = Color.Companion.Red,
                        modifier = Modifier.Companion.padding(16.dp)
                    )
                }
            } else {
                item {
                    SectionHeader(
                        title = "Best Offers",
                        onSeeAllClick = { Log.d("Dashboard", "See all Best Offers clicked") }
                    )
                    Spacer(modifier = Modifier.Companion.height(16.dp))
                }

                item {
                    BestOffersList(
                        items = bestOffers,
                        onItemClick = { item ->
                            onNavigateToDetail(item.id)
                            Log.d("Dashboard", "Item ${item.name} clicado")
                        }
                    )
                    Spacer(Modifier.Companion.height(24.dp))
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
                            modifier = Modifier.Companion.padding(16.dp),
                            color = Color.Companion.Gray
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