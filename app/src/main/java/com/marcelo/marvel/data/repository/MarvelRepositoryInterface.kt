package com.marcelo.marvel.data.repository

import com.marcelo.marvel.data.local.entity.HeroesEntity
import com.marcelo.marvel.domain.models.ComicsResult
import com.marcelo.marvel.domain.models.HeroesResult

interface MarvelRepositoryInterface {

    suspend fun getHeroes(): HeroesResult
    suspend fun getComics(characterId: Long): ComicsResult
}