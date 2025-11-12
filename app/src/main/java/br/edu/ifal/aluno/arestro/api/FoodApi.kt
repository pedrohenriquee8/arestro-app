package br.edu.ifal.aluno.arestro.api

import br.edu.ifal.aluno.arestro.model.Food
import retrofit2.http.GET
import retrofit2.http.Path

interface FoodApi {
    @GET("foods/{id}")
    suspend fun getFoodById(@Path("id") id: Int): Food
}