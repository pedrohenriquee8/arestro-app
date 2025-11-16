package br.edu.ifal.aluno.arestro.api


import br.edu.ifal.aluno.arestro.model.food.Food
import retrofit2.http.GET
import retrofit2.http.Path

interface FoodApi {
    @GET("foods")
    suspend fun getFoods(): List<Food>

    @GET("foods/{id}")
    suspend fun getFoodById(@Path("id") id: Int): Food
}