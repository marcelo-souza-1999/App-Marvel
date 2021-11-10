package com.marcelo.marvel.models

import com.squareup.moshi.Json

data class DataClassHeroes(
    @field:Json(name = "results") val heroes: List<Heroes>
)