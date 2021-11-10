package com.marcelo.marvel.models

import com.squareup.moshi.Json

data class DataClassComics(
    @field:Json(name = "results") val comics: List<Comics>
)