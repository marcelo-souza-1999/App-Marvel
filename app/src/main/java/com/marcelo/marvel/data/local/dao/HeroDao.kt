package com.marcelo.marvel.data.local.dao

import androidx.room.*
import com.marcelo.marvel.data.local.entity.ComicEntity
import com.marcelo.marvel.data.local.entity.HeroEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HeroDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHero(hero: HeroEntity): Long

    @Query("SELECT * FROM hero")
    suspend fun getAllHeroes(): List<HeroEntity>

    @Query("delete from hero")
    fun clearAllHeroes()
}