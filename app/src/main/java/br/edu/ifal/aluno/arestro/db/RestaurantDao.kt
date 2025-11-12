package br.edu.ifal.aluno.arestro.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.edu.ifal.aluno.arestro.model.restaurant.Restaurant

@Dao
interface RestaurantDao {
    @Insert
    suspend fun insertAll(RestaurantCard: List<Restaurant>)

    @Query("SELECT * FROM restaurant")
    suspend fun findAll(): List<Restaurant>
}