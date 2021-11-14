package com.marcelo.marvel.data.local.datasource

import com.marcelo.marvel.data.local.entity.HeroEntity
import com.marcelo.marvel.domain.models.ComicsResult
import com.marcelo.marvel.domain.models.HeroesResult
import kotlinx.coroutines.flow.Flow

interface MarvelDatabaseDataSource {

    suspend fun fetchHeroes(): List<HeroEntity>
    suspend fun insertHero(hero: HeroEntity)

    suspend fun fetchComics(characterId: Long): ComicsResult
}