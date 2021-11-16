package com.marcelo.marvel.data.repository

import android.util.Log
import com.marcelo.marvel.data.local.datasource.MarvelLocalDataSource
import com.marcelo.marvel.data.local.entity.HeroEntity
import com.marcelo.marvel.data.remote.datasource.MarvelRemoteDataSource
import com.marcelo.marvel.domain.models.ComicsResult
import com.marcelo.marvel.domain.models.Hero
import com.marcelo.marvel.domain.models.HeroesResult
import com.marcelo.marvel.domain.models.Thumbs
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach

class MarvelRepository(
    private val marvelRemoteDataSource: MarvelRemoteDataSource,
    private val localDataSource: MarvelLocalDataSource
) {

    suspend fun getHeroes(): Flow<HeroesResult> {
        val heroesLocal : List<HeroEntity> = localDataSource.fetchHeroes()

        if (heroesLocal.isEmpty()) {
            Log.d("testeDatabase", "Banco ta vazio")
            val heroesFromApi: Flow<HeroesResult> = marvelRemoteDataSource.fetchHeroes()

            Log.d("testeDatabase", "HeroesApi: "+heroesFromApi.toString())

            heroesFromApi.onEach {heroe->
                Log.d("testeDatabase", "Banco ta vazio, dentro do foreach $heroesFromApi")

                if (heroe is HeroesResult.Success) {
                    heroe.heroes.forEach { hero ->
                        Log.d("testeDatabase", "Salvando Heroe no banco: $hero")
                        localDataSource.insertHero(hero.toHeroEntity())
                        Log.d("testeDatabase", "Salvando HeroeEntity no banco:" + hero.toHeroEntity())
                    }
                }
            }
            return heroesFromApi
        }
        else {
            Log.d("testeDatabase", "Banco não ta vazio")
            val heroList = heroesLocal.map {
                it.toHero()
            }
            Log.d("testeDatabase", "Salvando Heroe no banco: $heroList")
            return flowOf(HeroesResult.Success(heroList))
        }
    }

    suspend fun getComics(characterId: Long): ComicsResult {
        return marvelRemoteDataSource.fetchComics(characterId)
    }

}

private fun HeroEntity.toHero() : Hero {
    return Hero(
        id = this.id,
        name = this.name,
        description = this.description,
        thumbnail = Thumbs(this.toHero().thumbnail.path, "."+this.toHero().thumbnail.extension)
    )
}

private fun Hero.toHeroEntity(): HeroEntity {
    return HeroEntity(
        id = this.id,
        name = this.name,
        description = this.description,
        thumbnailUrl = this.thumbnail.path + "." + this.thumbnail.extension
    )
}
