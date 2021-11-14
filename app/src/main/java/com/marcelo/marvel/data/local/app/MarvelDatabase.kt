package com.marcelo.marvel.data.local.app

import androidx.room.Database
import androidx.room.RoomDatabase
import com.marcelo.marvel.data.local.dao.HeroDAO
import com.marcelo.marvel.data.local.entity.HeroEntity

@Database(entities = [HeroEntity::class], version = 1, exportSchema = false)
abstract class MarvelDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDAO

    /*companion object {
        @Volatile
        private var INSTANCE: MarvelDatabase? = null

        fun getInstance(context: Context): MarvelDatabase {
            synchronized(this){
                var instance:MarvelDatabase? = INSTANCE
                if (instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MarvelDatabase::class.java,
                        "marvel_database"
                    ).build()
                }
                return instance
            }
        }
    }*/
}