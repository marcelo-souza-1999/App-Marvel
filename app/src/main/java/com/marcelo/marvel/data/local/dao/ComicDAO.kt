package com.marcelo.marvel.data.local.dao

import androidx.room.*
import com.marcelo.marvel.data.local.entity.ComicEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ComicDAO {

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