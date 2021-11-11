package com.marcelo.marvel.data.local.mapper

import com.marcelo.marvel.data.local.entity.HeroesEntity
import com.marcelo.marvel.domain.models.Heroes

class MarvelMapper {

    fun mapCharacterResponseToEntity(characterResponse: Heroes): HeroesEntity {
        return HeroesEntity(
            id = characterResponse.id,
            name = characterResponse.name,
            description = characterResponse.description,
            thumbnailUrl = with(characterResponse.thumbnail) {
                "${path}.${extension}"
            }
        )
    }
}