package com.marcelo.marvel.response

import com.marcelo.marvel.models.DataClassComics
import com.squareup.moshi.Json

data class ComicsResponse(
    @field:Json(name = "data") val data: DataClassComics
)