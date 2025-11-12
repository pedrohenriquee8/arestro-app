/*package br.edu.ifal.aluno.arestro.main.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.edu.ifal.aluno.arestro.main.model.SpecialOfferCard

@Dao
interface SpecialOfferCardDao {

    @Insert
    suspend fun insertAll(specialOfferCard: List<SpecialOfferCard>)

    @Query("SELECT * FROM specialOfferCard")
    suspend fun findAll(): List<SpecialOfferCard>

}*/