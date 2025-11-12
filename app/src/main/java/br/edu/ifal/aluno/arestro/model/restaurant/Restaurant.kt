package br.edu.ifal.aluno.arestro.model.restaurant

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurant")
data class Restaurant(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val description: String?,
    val photo_url:  String?,
    val address: String,
    val rating: Float,
)