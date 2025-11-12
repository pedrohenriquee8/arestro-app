package br.edu.ifal.aluno.arestro.main.model

data class RestaurantItem(
    val id: Int,
    val name: String,
    val description: String?,
    val photo_url:  String?,
    val address: String,
    val rating: Float,
)