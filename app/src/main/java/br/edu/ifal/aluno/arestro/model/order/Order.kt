package br.edu.ifal.aluno.arestro.model.order

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "order")
data class Order(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val userId: Int,
    val restaurantId: Int,
    val totalPrice: Double,
)