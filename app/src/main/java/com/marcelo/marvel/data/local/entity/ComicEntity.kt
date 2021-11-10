package com.marcelo.marvel.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comics")
data class ComicEntity(
    @PrimaryKey val id: Long,
    val name: String,
    val description: String?,
    val thumbnailUrl: String,
    val pageCount: Long
)