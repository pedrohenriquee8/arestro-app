package br.edu.ifal.aluno.arestro.api
import br.edu.ifal.aluno.arestro.model.restaurant.Restaurant
import retrofit2.http.GET

interface RestaurantApi {
    @GET("restaurants")
    suspend fun getRestaurants(): List<Restaurant>
}