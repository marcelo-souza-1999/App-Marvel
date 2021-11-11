package com.marcelo.marvel.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comics")
data class ComicEntity(
    @PrimaryKey val id: Long,
    val title: String,
    val description: String?,
    val pageCount: Long,
    val thumbnailUrl: String,
    val characterId: Long
)