package com.marcelo.marvel.network.services

import com.marcelo.marvel.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

object ApiService {

    private fun startRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    fun serviceMarvel(): MarvelApiService = startRetrofit().create(MarvelApiService::class.java)
}