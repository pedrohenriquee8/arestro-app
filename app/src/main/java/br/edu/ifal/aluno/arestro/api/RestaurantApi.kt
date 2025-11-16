package br.edu.ifal.aluno.arestro.api

import br.edu.ifal.aluno.arestro.model.restaurant.Restaurant
import retrofit2.http.GET
import retrofit2.http.Path

interface RestaurantApi {
    @GET("restaurants")
    suspend fun getRestaurants(): List<Restaurant>

    @GET("restaurants/{id}")
    suspend fun getRestaurantById(@Path("id") id: Int): Restaurant
}