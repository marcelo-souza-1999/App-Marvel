package com.marcelo.marvel.network.repository

import android.content.Context
import android.util.Log
import androidx.core.content.PackageManagerCompat.LOG_TAG
import com.marcelo.marvel.BuildConfig
import com.marcelo.marvel.R
import com.marcelo.marvel.models.Heroes
import com.marcelo.marvel.models.HeroesResult
import com.marcelo.marvel.network.services.MarvelApiService
import com.marcelo.marvel.network.services.response.NetworkResponse
import com.marcelo.marvel.utils.HashMD5

class MarvelRetrofitApiDataSource(
    private val context: Context,
    private val marvelApiService: MarvelApiService
) : MarvelApiDataSource {

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

                val heroes: MutableList<Heroes> = mutableListOf()

                heroesResponse.body.let { heroesBodyResponse ->
                    for (result in heroesBodyResponse.data) {
                        val heroe = result.results[0].getHeroeModel()
                        heroes.add(heroe)

                        Log.d("testeHeroi", "Lista: "+ heroes)
                    }
                }

                //val heroes = heroesResponse.body.data

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