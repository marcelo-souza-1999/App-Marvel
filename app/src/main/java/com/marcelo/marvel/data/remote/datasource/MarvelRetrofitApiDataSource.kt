package com.marcelo.marvel.data.remote.datasource

import android.content.Context
import com.marcelo.marvel.BuildConfig
import com.marcelo.marvel.R
import com.marcelo.marvel.domain.models.ComicsResult
import com.marcelo.marvel.domain.models.HeroesResult
import com.marcelo.marvel.data.remote.services.MarvelApiService
import com.marcelo.marvel.data.remote.response.NetworkResponse
import com.marcelo.marvel.utils.HashMD5

class MarvelRetrofitApiDataSource(private val context: Context, private val marvelApiService: MarvelApiService) :
    MarvelApiDataSource {

    override suspend fun fetchHeroes(): HeroesResult {
        val timestamp = System.currentTimeMillis().toString()
        val publicApiKey = BuildConfig.PUBLIC_API_KEY
        val privateApiKey = BuildConfig.PRIVATE_API_KEY
        val hash = HashMD5.convertMD5(
            timestamp + privateApiKey + publicApiKey
        )
        return when (val heroesResponse = marvelApiService.getHeroes(
            timestamp = timestamp,
            publicApiKey = publicApiKey,
            hash = hash
        )) {
            is NetworkResponse.Success -> {
                val heroes = heroesResponse.body.dataHeroes.heroes

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

    override suspend fun fetchComics(characterId: Long): ComicsResult {
        val timestamp = System.currentTimeMillis().toString()
        val publicApiKey = BuildConfig.PUBLIC_API_KEY
        val privateApiKey = BuildConfig.PRIVATE_API_KEY
        val hash = HashMD5.convertMD5(
            timestamp + privateApiKey + publicApiKey
        )
        return when (val comicsResponse = marvelApiService.getComics(
            characterId,
            timestamp = timestamp,
            publicApiKey = publicApiKey,
            hash = hash
        )) {
            is NetworkResponse.Success -> {
                val comics = comicsResponse.body.data.comics

                ComicsResult.Success(comics)
            }
            is NetworkResponse.ApiError -> {
                ComicsResult.ApiError(comicsResponse.code, comicsResponse.body?.message)
            }
            is NetworkResponse.NetworkError -> {
                ComicsResult.NetworkError(context.getString(R.string.message_error_internet))
            }
            else -> ComicsResult.ServerError(context.getString(R.string.message_error_server))
        }
    }
}