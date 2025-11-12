package br.edu.ifal.aluno.arestro.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.edu.ifal.aluno.arestro.model.contact.Contact
import br.edu.ifal.aluno.arestro.model.contact.ContactTypeConverter

@Database(
    version = 1,
    entities = [Contact::class],
)
@TypeConverters(ContactTypeConverter::class)

abstract class DatabaseHelper : RoomDatabase() {
    abstract fun contactDao(): ContactDao
    abstract fun userDao(): UserDao

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