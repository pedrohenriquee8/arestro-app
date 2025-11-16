package br.edu.ifal.aluno.arestro.db

import androidx.room.Dao
import androidx.room.Query
import br.edu.ifal.aluno.arestro.model.restaurant.Restaurant

@Dao
interface RestaurantDao {
    @Query("SELECT * FROM restaurant")
    suspend fun findAll(): List<Restaurant>
}