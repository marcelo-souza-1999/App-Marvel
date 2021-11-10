package com.marcelo.marvel.data.local.dao

import androidx.room.*
import com.marcelo.marvel.data.local.entity.CharacterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDAO {

    @Query("SELECT * FROM characters")
    suspend fun getAllCharacters(): Flow<List<CharacterEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(character: CharacterEntity)

    @Query("DELETE FROM characters")
    fun clearAllCharacters()

    @Transaction
    suspend fun updateCharacter(characterEntity: CharacterEntity) {
        clearAllCharacters()
        insertCharacter(characterEntity)
    }
}