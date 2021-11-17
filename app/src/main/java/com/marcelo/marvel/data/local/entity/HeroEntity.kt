package com.marcelo.marvel.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hero")
data class HeroEntity(
    @PrimaryKey
    val id: Long,
    val name: String,
    val description: String,
    @ColumnInfo(name = "thumbnail")
    val thumbnailUrl: String
)