package com.marcelo.marvel.directory

import com.marcelo.marvel.network.repository.MarvelApiDataSource
import com.marcelo.marvel.network.repository.MarvelRepository
import com.marcelo.marvel.network.repository.MarvelRetrofitApiDataSource
import com.marcelo.marvel.network.services.ApiService.serviceMarvel
import com.marcelo.marvel.ui.viewmodel.HeroesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val retrofitModule = module {
    single {
        serviceMarvel()
    }
}

val repositoryModule = module {

    single {
        MarvelRepository(get(), get())
    }

    single<MarvelApiDataSource> {
        MarvelRetrofitApiDataSource(get(), get())
    }
}

val viewModelModule = module {

    viewModel {
        HeroesViewModel(get())
    }
}