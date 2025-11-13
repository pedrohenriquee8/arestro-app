package br.edu.ifal.aluno.arestro.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.edu.ifal.aluno.arestro.model.contact.Contact
import br.edu.ifal.aluno.arestro.model.user.User
import br.edu.ifal.aluno.arestro.model.food.Food
import br.edu.ifal.aluno.arestro.model.contact.ContactTypeConverter

@Database(
    version = 2,
    entities = [Contact::class, User::class, Food::class],
)
@TypeConverters(ContactTypeConverter::class)

abstract class DatabaseHelper : RoomDatabase() {
    abstract fun contactDao(): ContactDao
    abstract fun userDao(): UserDao
    abstract fun foodDao(): FoodDao

    companion object {
        fun getInstance(context: Context): DatabaseHelper {
            return Room.databaseBuilder(
                context,
                DatabaseHelper::class.java,
                "arestro.db"
            ).build()
        }
    }
}