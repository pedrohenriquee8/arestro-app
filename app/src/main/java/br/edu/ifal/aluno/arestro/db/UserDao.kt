package br.edu.ifal.aluno.arestro.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.edu.ifal.aluno.arestro.model.user.User
@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * FROM user")
    suspend fun findAll(): List<User>
}