package br.edu.ifal.aluno.arestro.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.edu.ifal.aluno.arestro.model.food.Food

@Dao
interface FoodDao {
    @Insert
    suspend fun insertAll(FoodCard: List<Food>)

    @Query("SELECT * FROM food")
    suspend fun findAll(): List<Food>
}