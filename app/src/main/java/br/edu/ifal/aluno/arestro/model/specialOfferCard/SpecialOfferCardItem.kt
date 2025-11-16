package br.edu.ifal.aluno.arestro.model.specialOfferCard

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "specialOfferCard")
data class SpecialOfferCard(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @SerializedName("photo_url")
    val photoUrl: String = "",
    val title: String?,
    val description: String? = null,
)