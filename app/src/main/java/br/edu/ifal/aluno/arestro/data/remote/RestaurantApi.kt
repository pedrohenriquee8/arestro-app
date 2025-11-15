package br.edu.ifal.aluno.arestro.data.remote

import br.edu.ifal.aluno.arestro.data.model.Restaurant
import retrofit2.http.GET
import retrofit2.http.Path

interface RestaurantApi {
    @GET("restaurants")
    suspend fun getAllRestaurants(): List<Restaurant>

    @GET("restaurants/{id}")
    suspend fun getRestaurantById(@Path("id") id: Int): Restaurant
}
