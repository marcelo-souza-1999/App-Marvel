package com.marcelo.marvel.directory

import com.marcelo.marvel.data.remote.repository.MarvelApiDataSource
import com.marcelo.marvel.data.remote.repository.MarvelRepository
import com.marcelo.marvel.data.remote.repository.MarvelRetrofitApiDataSource
import com.marcelo.marvel.data.remote.services.ApiService.serviceMarvel
import com.marcelo.marvel.ui.viewmodel.ComicsViewModel
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