package com.marcelo.marvel.data.remote.datasource

import com.marcelo.marvel.domain.models.ComicsResult
import com.marcelo.marvel.domain.models.HeroesResult
import kotlinx.coroutines.flow.Flow

interface MarvelRemoteDataSource {

    suspend fun fetchHeroes(): Flow<HeroesResult>

    suspend fun fetchComics(characterId: Long): ComicsResult
}