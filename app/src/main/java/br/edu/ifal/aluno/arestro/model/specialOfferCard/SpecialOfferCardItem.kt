package br.edu.ifal.aluno.arestro.model.specialOfferCard

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "specialOfferCard")
data class SpecialOfferCard(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val photo_url: String = "",
    val title: String?,
    val description: String? = null,
)