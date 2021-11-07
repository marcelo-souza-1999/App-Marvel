package com.marcelo.marvel.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class HeroesResponse(
    @field:Json(name = "status") val status: String,
    @field:Json(name = "data") val data: DataClass
)