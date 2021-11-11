package com.marcelo.marvel.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "heroes")
data class HeroesEntity(
    @ColumnInfo(name = "heroe_id")
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "heroe_name")
    val name: String,
    @ColumnInfo(name = "heroe_description")
    val description: String,
    @ColumnInfo(name = "heroe_thumbnail")
    val thumbnailUrl: String
)