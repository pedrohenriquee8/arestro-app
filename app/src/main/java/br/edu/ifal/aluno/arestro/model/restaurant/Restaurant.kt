package br.edu.ifal.aluno.arestro.model.restaurant

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "restaurant")
data class Restaurant(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val description: String,
    @SerializedName("photo_url")
    val photoUrl: String,
    val address: String,
    val rating: Double,
)