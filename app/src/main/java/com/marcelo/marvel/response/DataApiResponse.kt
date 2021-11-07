package com.marcelo.marvel.response

import com.marcelo.marvel.models.Heroes
import com.squareup.moshi.Json

data class DataApiResponse(
    @field:Json(name = "results") val results: List<Heroes>
)