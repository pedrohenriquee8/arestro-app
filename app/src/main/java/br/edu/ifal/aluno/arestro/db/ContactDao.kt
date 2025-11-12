package br.edu.ifal.aluno.arestro.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.edu.ifal.aluno.arestro.model.contact.Contact

@Dao
interface ContactDao {
    @Query("SELECT * FROM contact WHERE userId = :userId")
    suspend fun findAllByUserId(userId: Int): List<Contact>

    @Insert
    suspend fun create(contact: Contact)
}