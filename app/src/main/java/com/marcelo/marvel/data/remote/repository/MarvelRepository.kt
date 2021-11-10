package com.marcelo.marvel.data.remote.repository

import com.marcelo.marvel.models.ComicsResult
import com.marcelo.marvel.models.HeroesResult

class MarvelRepository( private val marvelApiDataSource: MarvelApiDataSource): MarvelRepositoryInterface {

    override suspend fun getHeroes(): HeroesResult {
        return marvelApiDataSource.fetchHeroes()
    }

    override suspend fun getComics(characterId: Long): ComicsResult {
        return marvelApiDataSource.fetchComics(characterId)
    }
}