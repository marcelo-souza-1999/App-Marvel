package com.marcelo.marvel.data.repository

import com.marcelo.marvel.data.local.datasource.MarvelLocalDataSource
import com.marcelo.marvel.data.local.entity.HeroEntity
import com.marcelo.marvel.data.remote.datasource.MarvelRemoteDataSource
import com.marcelo.marvel.domain.models.ComicsResult
import com.marcelo.marvel.domain.models.Hero
import com.marcelo.marvel.domain.models.HeroesResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf

class MarvelRepository(
    private val marvelRemoteDataSource: MarvelRemoteDataSource,
    private val localDataSource: MarvelLocalDataSource
) {

    suspend fun getHeroes(): Flow<HeroesResult> {
        val heroesLocal: List<HeroEntity> = localDataSource.fetchHeroes()

        if (heroesLocal.isEmpty()) {
            val heroesFromApi: Flow<HeroesResult> = marvelRemoteDataSource.fetchHeroes()

            heroesFromApi.collect { heroe ->

                if (heroe is HeroesResult.Success) {
                    heroe.heroes.forEach { hero ->
                        localDataSource.insertHero(hero.toHeroEntity())
                    }
                }
            }
            return heroesFromApi
        } else {
            val heroList = heroesLocal.map {
                it.toHero()
            }
            return flowOf(HeroesResult.Success(heroList))
        }
    }

    suspend fun getComics(characterId: Long): ComicsResult {
        return marvelRemoteDataSource.fetchComics(characterId)
    }

}
