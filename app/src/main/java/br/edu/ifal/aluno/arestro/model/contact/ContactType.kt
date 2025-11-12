package br.edu.ifal.aluno.arestro.model.contact

import androidx.room.TypeConverter

enum class ContactType {
    EMAIL,
    PHONE,
}

class ContactTypeConverter {
    @TypeConverter
    fun fromContactType(contactType: ContactType): String {
        return contactType.name
    }

    @TypeConverter
    fun toContactType(value: String): ContactType {
        return ContactType.valueOf(value)
    }
}