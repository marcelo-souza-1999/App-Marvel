package com.marcelo.marvel.app

import android.app.Application
import com.marcelo.marvel.directory.DatabaseModule
import com.marcelo.marvel.directory.RetrofitModule
import com.marcelo.marvel.directory.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MarvelApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MarvelApp)
            modules(RetrofitModule.module)
            modules(DatabaseModule.modules)
            modules(ViewModelModule.modules)
        }
    }
}