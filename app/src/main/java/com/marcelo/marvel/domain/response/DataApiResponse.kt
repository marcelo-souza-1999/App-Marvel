package com.marcelo.marvel.domain.response

import com.marcelo.marvel.domain.models.Heroes
import com.squareup.moshi.Json

data class DataApiResponse(
    @field:Json(name = "results") val results: List<Heroes>
)