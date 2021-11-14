package com.marcelo.marvel.directory

import androidx.room.Room
import com.marcelo.marvel.data.local.app.MarvelDatabase
import com.marcelo.marvel.data.local.datasource.MarvelDatabaseDataSource
import com.marcelo.marvel.data.local.datasource.MarvelLocalDataSource
import com.marcelo.marvel.data.remote.datasource.MarvelRemoteDataSource
import com.marcelo.marvel.data.repository.MarvelRepository
import com.marcelo.marvel.data.remote.datasource.MarvelRetrofitRemoteDataSource
import com.marcelo.marvel.data.remote.services.ApiService.serviceMarvel
import com.marcelo.marvel.presentation.viewmodel.ComicsViewModel
import com.marcelo.marvel.presentation.viewmodel.HeroesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val retrofitModule = module {
    single {
        serviceMarvel()
    }
}

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
        MarvelRepository(get(), get())
    }

    single<MarvelRemoteDataSource> {
        MarvelRetrofitRemoteDataSource(get(), get())
    }

    single<MarvelDatabaseDataSource> {
        MarvelLocalDataSource(get())
    }
}

val viewModelHeroesModule = module {

    viewModel {
        HeroesViewModel(get())
    }
}
val viewModelComicsModule = module {

    viewModel {
        ComicsViewModel(get())
    }
}