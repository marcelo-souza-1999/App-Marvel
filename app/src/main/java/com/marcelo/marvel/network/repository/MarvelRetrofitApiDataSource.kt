package com.marcelo.marvel.network.repository

import android.content.Context
import com.marcelo.marvel.R
import com.marcelo.marvel.models.HeroesResult
import com.marcelo.marvel.network.services.MarvelApiService
import com.marcelo.marvel.network.services.response.NetworkResponse

class MarvelRetrofitApiDataSource(private val context: Context, private val marvelApiService: MarvelApiService): MarvelApiDataSource {

    override suspend fun fetchHeroes(): HeroesResult {
        return when (val heroesResponse = marvelApiService.getHeroes()) {
            is NetworkResponse.Success -> {
                val heroes = heroesResponse.body.results
                HeroesResult.Success(heroes)
            }
            is NetworkResponse.ApiError -> {
                HeroesResult.ApiError(heroesResponse.code, heroesResponse.body?.message)
            }
            is NetworkResponse.NetworkError -> {
                HeroesResult.NetworkError(context.getString(R.string.message_error_internet))
            }
            else -> HeroesResult.ServerError(context.getString(R.string.message_error_server))
        }
    }
}