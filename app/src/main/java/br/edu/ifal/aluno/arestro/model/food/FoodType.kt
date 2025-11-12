package br.edu.ifal.aluno.arestro.model.food

import androidx.room.TypeConverter

enum class FoodType {
    NAME,
    DESCRIPTION,
    PRICE
}

class FoodTypeConverter {
    @TypeConverter
    fun fromFoodType(foodType: FoodType): String {
        return foodType.name
    }

    @TypeConverter
    fun toFoodType(value: String): FoodType {
        return FoodType.valueOf(value)
    }
}