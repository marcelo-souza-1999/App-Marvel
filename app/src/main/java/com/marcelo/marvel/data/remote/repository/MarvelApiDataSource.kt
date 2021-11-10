package com.marcelo.marvel.data.remote.repository

import com.marcelo.marvel.models.ComicsResult
import com.marcelo.marvel.models.HeroesResult

interface MarvelApiDataSource {

    suspend fun fetchHeroes(): HeroesResult

    suspend fun fetchComics(characterId: Long): ComicsResult
}