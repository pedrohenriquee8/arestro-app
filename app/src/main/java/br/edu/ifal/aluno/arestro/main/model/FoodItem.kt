package br.edu.ifal.aluno.arestro.main.model

data class FoodItem(
    val id: Int,
    val name: String,
    val description: String,
    val photo_url: String?,
    val rating: Float,
    val price: Float,
    val restaurant_id: Int
)