package com.marcelo.marvel.data.local.app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.marcelo.marvel.data.local.dao.CharacterDAO
import com.marcelo.marvel.data.local.dao.ComicDAO
import com.marcelo.marvel.data.local.entity.CharacterEntity
import com.marcelo.marvel.data.local.entity.ComicEntity

@Database(entities = [CharacterEntity::class, ComicEntity::class], version = 1, exportSchema = false)
abstract class MarvelDatabase : RoomDatabase() {

    abstract fun characterDAO(): CharacterDAO
    abstract fun comicDAO(): ComicDAO

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