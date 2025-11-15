package br.edu.ifal.aluno.arestro.data.model

data class Food(
    val id: Int,
    val name: String,
    val restaurant_id: Int,
    val rating: Double,
    val imageUrl: String
)
