package br.edu.ifal.aluno.arestro.db

import androidx.room.Insert
import androidx.room.Query
import br.edu.ifal.aluno.arestro.model.user.User

interface UserDao {
    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * FROM food")
    suspend fun findAll(): List<User>
}