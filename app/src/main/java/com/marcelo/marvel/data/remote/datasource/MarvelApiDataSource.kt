package com.marcelo.marvel.data.remote.datasource

import com.marcelo.marvel.domain.models.ComicsResult
import com.marcelo.marvel.domain.models.HeroesResult

interface MarvelApiDataSource {

    suspend fun fetchHeroes(): HeroesResult

    suspend fun fetchComics(characterId: Long): ComicsResult
}