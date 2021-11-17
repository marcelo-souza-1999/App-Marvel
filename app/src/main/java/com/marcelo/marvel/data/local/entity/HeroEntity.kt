package com.marcelo.marvel.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.marcelo.marvel.domain.models.Hero
import com.marcelo.marvel.domain.models.Thumbs

@Entity(tableName = "hero")
data class HeroEntity(
    @PrimaryKey
    val id: Long,
    val name: String,
    val description: String,
    @ColumnInfo(name = "thumbnail")
    val thumbnailUrl: String
) {
    fun toHero(): Hero {

        val lengthUrl = this.thumbnailUrl.length

        return Hero(
            id = this.id,
            name = this.name,
            description = this.description,
            thumbnail = Thumbs(
                this.thumbnailUrl.substring(0, lengthUrl - 4),
                this.thumbnailUrl.substring(lengthUrl - 3)
            )
        )
    }
}