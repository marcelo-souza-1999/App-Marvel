package com.marcelo.marvel.network.repository

import com.marcelo.marvel.models.HeroesResult

interface MarvelApiDataSource {

    suspend fun fetchHeroes(): HeroesResult
}