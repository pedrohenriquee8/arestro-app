package br.edu.ifal.aluno.arestro.model.food

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "food")
data class Food(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val description: String,
    @SerializedName("photo_url")
    val photoUrl: String,
    val rating: Double,
    val price: Double,
    @SerializedName("restaurant_id")
    val restaurantId: Int,
)