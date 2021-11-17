package com.marcelo.marvel.directory

import com.marcelo.marvel.data.remote.datasource.MarvelRemoteDataSource
import com.marcelo.marvel.data.remote.datasource.MarvelRetrofitRemoteDataSource
import com.marcelo.marvel.data.repository.MarvelRepository
import com.marcelo.marvel.presentation.viewmodel.ComicsViewModel
import com.marcelo.marvel.presentation.viewmodel.HeroesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelHeroesModule = module {

    single<MarvelRemoteDataSource> {
        MarvelRetrofitRemoteDataSource(get(), get())
    }

    single {
        MarvelRepository(get(), get())
    }

    viewModel {
        HeroesViewModel(get())
    }
}
val viewModelComicsModule = module {

    viewModel {
        ComicsViewModel(get())
    }
}

object ViewModelModule {
    val modules= viewModelHeroesModule + viewModelComicsModule
}

