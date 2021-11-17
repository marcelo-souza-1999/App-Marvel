package com.marcelo.marvel.directory

import androidx.room.Room
import com.marcelo.marvel.data.local.app.MarvelDatabase
import com.marcelo.marvel.data.local.datasource.MarvelLocalDataSource
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            MarvelDatabase::class.java,
            "marvel_database"
        ).build()
    }
}

val daoModule = module {
    single {get<MarvelDatabase>().heroDao()}

    single {
        MarvelLocalDataSource(get())
    }
}

object DatabaseModule {
    val modules= databaseModule + daoModule
}