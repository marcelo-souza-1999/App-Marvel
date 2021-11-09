package com.marcelo.marvel.response

import com.marcelo.marvel.models.DataClass
import com.squareup.moshi.Json

data class HeroesResponse(
    @field:Json(name = "data") val data: DataClass
)