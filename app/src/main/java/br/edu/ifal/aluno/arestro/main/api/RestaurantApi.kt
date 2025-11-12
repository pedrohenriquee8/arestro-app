package br.edu.ifal.aluno.arestro.main.api
import br.edu.ifal.aluno.arestro.main.model.RestaurantItem
import retrofit2.http.GET

interface RestaurantApi {

    @GET("restaurants")
    suspend fun getRestaurants(): List<RestaurantItem>
}