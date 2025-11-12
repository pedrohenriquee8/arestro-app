package br.edu.ifal.aluno.arestro.main.model

data class SpecialOffer(
    val id: Int,
    val photo_url: String,
    val title: String? = null,
    val description: String? = null,
)