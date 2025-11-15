package br.edu.ifal.aluno.arestro.data.repository

import br.edu.ifal.aluno.arestro.data.local.RestaurantDao
import br.edu.ifal.aluno.arestro.data.model.Restaurant
import br.edu.ifal.aluno.arestro.data.remote.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RestaurantRepository(private val dao: RestaurantDao) {

    suspend fun getRestaurants(): List<Restaurant> = withContext(Dispatchers.IO) {
        try {
            val apiData = RetrofitInstance.api.getAllRestaurants()
            dao.insertAll(apiData)
            apiData
        } catch (e: Exception) {
            e.printStackTrace()
            dao.getAllRestaurants()
        }
    }

    suspend fun getRestaurantDetails(id: Int): Restaurant = withContext(Dispatchers.IO) {
        RetrofitInstance.api.getRestaurantById(id)
    }
}
