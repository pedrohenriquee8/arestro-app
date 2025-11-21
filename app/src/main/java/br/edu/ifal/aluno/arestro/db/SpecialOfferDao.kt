package br.edu.ifal.aluno.arestro.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.edu.ifal.aluno.arestro.model.food.SpecialOfferEntity

@Dao
interface SpecialOfferDao {
    @Query("SELECT * FROM special_offers LIMIT 1")
    suspend fun getSpecialOffer(): SpecialOfferEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(offer: SpecialOfferEntity)
}