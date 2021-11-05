package com.marcelo.marvel.models

import com.squareup.moshi.Json

data class HeroesResponse(
    @field:Json(name = "results") val results: List<Heroes>,
    @field:Json(name = "status") val status: String,
)