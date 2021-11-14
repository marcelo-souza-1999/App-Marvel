package com.marcelo.marvel.data.local.datasource

import com.marcelo.marvel.data.local.dao.HeroDAO
import com.marcelo.marvel.data.local.entity.HeroEntity
import com.marcelo.marvel.domain.models.ComicsResult

class MarvelLocalDataSource(private val heroDAO: HeroDAO) : MarvelDatabaseDataSource {

    override suspend fun fetchHeroes(): List<HeroEntity> {
        return heroDAO.getAllHeroes()
    }

    override suspend fun insertHero(hero: HeroEntity) {
        heroDAO.insertHero(hero)
    }

    override suspend fun fetchComics(characterId: Long): ComicsResult {
        return ComicsResult.Success(listOf())
    }

}