package com.marcelo.marvel.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.marcelo.marvel.data.local.entity.ComicEntity
import com.marcelo.marvel.data.local.entity.HeroesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HeroesDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHeroes(heroes: HeroesEntity): Long

    @Query("SELECT * FROM heroes")
    fun getAllHeroes(): Flow<List<HeroesEntity>>

    @Query("delete from heroes")
    fun clearAllHeroes()

    @Transaction
    suspend fun updateCharacter(heroesEntity: HeroesEntity) {
        clearAllHeroes()
        insertHeroes(heroesEntity)
    }
}

@Dao
interface ComicDao {

    @Query("SELECT * FROM comics")
    fun getAllComic(): Flow<List<ComicEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComics(comicList: List<ComicEntity>)

    @Query("DELETE FROM comics")
    fun clearAllComics()

    @Transaction
    suspend fun updateComicsByCharacter(characterId: Long, comicList: List<ComicEntity>) {
        clearAllComics()
        insertComics(comicList)
    }
}