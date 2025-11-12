package br.edu.ifal.aluno.arestro.main.api
import br.edu.ifal.aluno.arestro.main.model.RestaurantItem
import retrofit2.http.GET

interface RetrofitRestaurants {

    @GET("nearby-restaurants")
    suspend fun getNearbyRestaurants(): List<RestaurantItem>
}