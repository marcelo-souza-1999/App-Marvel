package com.marcelo.marvel.network.repository

import com.marcelo.marvel.models.ComicsResult
import com.marcelo.marvel.models.HeroesResult

interface MarvelRepositoryInterface {

    suspend fun getHeroes(): HeroesResult
    suspend fun getComics(characterId: Long): ComicsResult
}