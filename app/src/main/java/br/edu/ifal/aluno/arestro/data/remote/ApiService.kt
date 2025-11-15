package br.edu.ifal.aluno.arestro.data.remote

import br.edu.ifal.aluno.arestro.data.model.Food
import br.edu.ifal.aluno.arestro.data.model.Restaurant
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("restaurants")
    suspend fun getAllRestaurants(): List<Restaurant>

    @GET("restaurants/{id}")
    suspend fun getRestaurantById(@Path("id") id: Int): Restaurant

    @GET("foods")
    suspend fun getFoods(): List<Food>

    @GET("foods")
    suspend fun getFoodsByRestaurant(@Query("restaurant_id") restaurantId: Int): List<Food>
}
