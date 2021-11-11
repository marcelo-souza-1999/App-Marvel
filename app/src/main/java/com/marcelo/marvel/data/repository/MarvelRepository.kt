package com.marcelo.marvel.data.repository

import com.marcelo.marvel.data.local.datasource.MarvelLocalDataSource
import com.marcelo.marvel.data.remote.datasource.MarvelApiDataSource
import com.marcelo.marvel.domain.models.ComicsResult
import com.marcelo.marvel.domain.models.HeroesResult

class MarvelRepository(
    private val marvelApiDataSource: MarvelApiDataSource,
    private val localDataSource: MarvelLocalDataSource,
) : MarvelRepositoryInterface {

    override suspend fun getHeroes(): HeroesResult {

        return marvelApiDataSource.fetchHeroes()
    }

    override suspend fun getComics(characterId: Long): ComicsResult {
        return marvelApiDataSource.fetchComics(characterId)
    }


}