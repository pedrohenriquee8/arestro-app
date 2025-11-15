package br.edu.ifal.aluno.arestro.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "http://192.168.2.5:3000"

    val api: RestaurantApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RestaurantApi::class.java)
    }
}
