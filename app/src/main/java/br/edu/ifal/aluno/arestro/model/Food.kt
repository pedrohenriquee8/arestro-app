package br.edu.ifal.aluno.arestro.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food")
data class Food(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val description: String,
    val photo_url: String,
    val rating: Double,
    val price: Double,
    val restaurant_id: Int,
)