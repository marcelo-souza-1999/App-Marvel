package com.marcelo.marvel.network.repository

import android.content.Context
import com.marcelo.marvel.models.HeroesResult

class MarvelRepository(private val context: Context, private val marvelApiDataSource: MarvelApiDataSource): MarvelRepositoryInterface {

    override suspend fun getHeroes(): HeroesResult {
        return marvelApiDataSource.fetchHeroes()
    }
}