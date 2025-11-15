package br.edu.ifal.aluno.arestro.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.edu.ifal.aluno.arestro.data.model.Restaurant

@Database(entities = [Restaurant::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun restaurantDao(): RestaurantDao


    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "arestro_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}