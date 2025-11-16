package br.edu.ifal.aluno.arestro.model.food

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "special_offers")
data class SpecialOfferEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val imageUrl: String
)