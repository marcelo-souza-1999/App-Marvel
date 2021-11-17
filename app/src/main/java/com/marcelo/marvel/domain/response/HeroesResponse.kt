package com.marcelo.marvel.domain.response

import com.marcelo.marvel.domain.models.DataClassHeroes
import com.squareup.moshi.Json

data class HeroesResponse(
    @field:Json(name = "data") val dataHeroes: DataClassHeroes
)