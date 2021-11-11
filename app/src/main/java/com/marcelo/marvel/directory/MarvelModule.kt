package com.marcelo.marvel.directory

import com.marcelo.marvel.data.remote.datasource.MarvelApiDataSource
import com.marcelo.marvel.data.repository.MarvelRepository
import com.marcelo.marvel.data.remote.datasource.MarvelRetrofitApiDataSource
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

val repositoryModule = module {

    single {
        MarvelRepository(get())
    }

    single<MarvelApiDataSource> {
        MarvelRetrofitApiDataSource(get(), get())
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