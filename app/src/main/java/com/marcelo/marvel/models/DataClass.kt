package com.marcelo.marvel.models

import com.squareup.moshi.Json

data class DataClass(
    @field:Json(name = "results") val results: List<Heroes>
)