package br.edu.ifal.aluno.arestro.api

import br.edu.ifal.aluno.arestro.model.user.User
import retrofit2.http.GET

interface UserApi {
    @GET("user")
    suspend fun getUser(): User
}