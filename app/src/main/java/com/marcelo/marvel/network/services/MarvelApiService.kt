package com.marcelo.marvel.network.services

import com.marcelo.marvel.models.ErrorResponse
import com.marcelo.marvel.models.HeroesResponse
import com.marcelo.marvel.network.services.response.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApiService {

    @GET("characters")
    suspend fun getHeroes(
        @Query("ts") timestamp: String,
        @Query("apikey") publicApiKey: String,
        @Query("hash") hash: String
    ): NetworkResponse<HeroesResponse, ErrorResponse>

}