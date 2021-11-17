package com.marcelo.marvel.domain.models

import com.marcelo.marvel.data.local.entity.HeroEntity
import com.squareup.moshi.Json

data class Hero(
    @field:Json(name = "id") val id: Long,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "description") val description: String,
    @field:Json(name = "thumbnail") val thumbnail: Thumbs
) {
    fun toHeroEntity(): HeroEntity {
        return HeroEntity(
            id = this.id,
            name = this.name,
            description = this.description,
            thumbnailUrl = this.thumbnail.path + "." + this.thumbnail.extension
        )
    }
}