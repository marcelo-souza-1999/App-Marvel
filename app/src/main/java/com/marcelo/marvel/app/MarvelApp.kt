package com.marcelo.marvel.app

import android.app.Application
import com.marcelo.marvel.directory.repositoryModule
import com.marcelo.marvel.directory.retrofitModule
import com.marcelo.marvel.directory.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MarvelApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MarvelApp)
            modules(listOf(
                retrofitModule,
                repositoryModule,
                viewModelModule
            ))
        }
    }
}