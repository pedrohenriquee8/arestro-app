package br.edu.ifal.aluno.arestro.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://my-json-server.typicode.com/pedrohenriquee8/arestro-api/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val foodApi: FoodApi = retrofit.create(FoodApi::class.java)
    val restaurantApi: RestaurantApi = retrofit.create(RestaurantApi::class.java)
}