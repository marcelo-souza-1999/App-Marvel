package com.marcelo.marvel.data.local.app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.marcelo.marvel.data.local.dao.HeroesDAO
import com.marcelo.marvel.data.local.dao.ComicDao
import com.marcelo.marvel.data.local.entity.HeroesEntity
import com.marcelo.marvel.data.local.entity.ComicEntity

@Database(entities = [HeroesEntity::class, ComicEntity::class], version = 1, exportSchema = false)
abstract class MarvelDatabase : RoomDatabase() {

    abstract fun characterDAO(): HeroesDAO
    abstract fun comicDAO(): ComicDao

    companion object {
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
    }
}