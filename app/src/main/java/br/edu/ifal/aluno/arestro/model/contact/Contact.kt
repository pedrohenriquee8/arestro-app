package br.edu.ifal.aluno.arestro.model.contact

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val type: ContactType,
    val value: String,
    val userId: Int,
)