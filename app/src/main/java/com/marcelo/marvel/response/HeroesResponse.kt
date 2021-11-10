package com.marcelo.marvel.response

import com.marcelo.marvel.models.DataClassHeroes
import com.squareup.moshi.Json

data class HeroesResponse(
    @field:Json(name = "data") val dataHeroes: DataClassHeroes
)