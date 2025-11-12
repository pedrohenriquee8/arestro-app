/*package br.edu.ifal.aluno.arestro.main.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.edu.ifal.aluno.arestro.main.model.SpecialOfferCard

@Database(
    version = 1, entities = [SpecialOfferCard::class]
)
abstract class DatabaseHelper : RoomDatabase() {

    abstract fun specialOfferCardDao() : SpecialOfferCard

    companion object {
        fun getInstance(context: Context): DatabaseHelper {
            return Room.databaseBuilder(
                context,
                DatabaseHelper::class.java,
                "arestro.db"
            ).build()
        }

    }
}*/