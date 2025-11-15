package br.edu.ifal.aluno.arestro.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurants")
data class Restaurant(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val address: String,
    val description: String,
    val imageUrl: String,
    val status: String,
    val distance: String
)
