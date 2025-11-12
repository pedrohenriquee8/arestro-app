package br.edu.ifal.aluno.arestro.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://my-json-server.typicode.com/pedrohenriquee8/arestro-api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val foodApi: FoodApi = retrofit.create(FoodApi::class.java)
    val restaurantApi: RestaurantApi = retrofit.create(RestaurantApi::class.java)
}