package com.marcelo.marvel.domain.response

import com.marcelo.marvel.domain.models.DataClassComics
import com.squareup.moshi.Json

data class ComicsResponse(
    @field:Json(name = "data") val data: DataClassComics
)