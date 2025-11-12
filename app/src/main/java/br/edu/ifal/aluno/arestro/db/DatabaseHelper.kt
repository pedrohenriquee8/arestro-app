package br.edu.ifal.aluno.arestro.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.edu.ifal.aluno.arestro.model.contact.Contact
import br.edu.ifal.aluno.arestro.model.contact.ContactTypeConverter
import br.edu.ifal.aluno.arestro.model.food.SpecialOfferEntity

@Database(
    version = 2,
    entities = [Contact::class, SpecialOfferEntity::class],
)
@TypeConverters(ContactTypeConverter::class)

abstract class DatabaseHelper : RoomDatabase() {
    abstract fun contactDao(): ContactDao
    abstract fun specialOfferDao() : SpecialOfferDao

    companion object {
        private var INSTANCE: DatabaseHelper? = null
        fun getInstance(context: Context): DatabaseHelper {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseHelper::class.java,
                    "arestro_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}