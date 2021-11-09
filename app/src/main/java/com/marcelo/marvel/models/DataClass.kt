package com.marcelo.marvel.models

import com.squareup.moshi.Json

data class DataClass(
    @field:Json(name = "results") val heroes: List<Heroes>,
    @field:Json(name = "results") val comics: List<Comics>
)