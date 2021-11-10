package com.marcelo.marvel.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharacterEntity(
    @PrimaryKey val id: Long,
    val name: String,
    val description: String,
    val thumbnailUrl: String
)