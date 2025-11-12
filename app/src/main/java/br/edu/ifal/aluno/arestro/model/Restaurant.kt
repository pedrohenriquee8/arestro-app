package br.edu.ifal.aluno.arestro.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurant")
data class Restaurant(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val description: String,
    val photo_url: String,
    val address: String,
    val rating: Double,
)