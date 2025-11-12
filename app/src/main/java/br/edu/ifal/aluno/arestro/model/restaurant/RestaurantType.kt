package br.edu.ifal.aluno.arestro.model.restaurant

import androidx.room.TypeConverter

enum class RestaurantType {
    NAME,
    DESCRIPTION,
}

class RestaurantTypeConverter {
    @TypeConverter
    fun fromRestaurantType(restaurantType: RestaurantType): String {
        return restaurantType.name
    }

    @TypeConverter
    fun toRestaurantType(value: String): RestaurantType {
        return RestaurantType.valueOf(value)
    }
}