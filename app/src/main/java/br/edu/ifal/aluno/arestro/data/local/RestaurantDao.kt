package br.edu.ifal.aluno.arestro.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.edu.ifal.aluno.arestro.data.model.Restaurant

@Dao
interface RestaurantDao {
    @Query("SELECT * FROM restaurants")
    suspend fun getAllRestaurants(): List<Restaurant>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(restaurants: List<Restaurant>)
}
