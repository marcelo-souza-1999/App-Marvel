package com.marcelo.marvel.data.local.datasource

import android.util.Log
import com.marcelo.marvel.data.local.dao.HeroDAO
import com.marcelo.marvel.data.local.entity.HeroEntity

class MarvelLocalDataSource(private val heroDAO: HeroDAO) : MarvelDatabaseDataSource {

    override suspend fun fetchHeroes(): List<HeroEntity> {
        return heroDAO.getAllHeroes()
    }

    override suspend fun insertHero(hero: HeroEntity) {
        Log.d("testeDatabase", "Insert foi chamado")
        heroDAO.insertHero(hero)
    }
}