package com.marcelo.marvel.data.remote.services

import com.marcelo.marvel.BuildConfig
import com.marcelo.marvel.data.remote.response.NetworkResponseAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiService {

    private fun startRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .build()
    }

    fun serviceMarvel(): MarvelApiService = startRetrofit().create(MarvelApiService::class.java)
}