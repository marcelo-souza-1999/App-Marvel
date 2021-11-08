package com.marcelo.marvel.response

import com.squareup.moshi.Json

data class HeroesBodyResponse(
    @field:Json(name = "data")
    val data: List<DataApiResponse>,
    //@field:Json(name = "results") val results: List<Heroes>
)