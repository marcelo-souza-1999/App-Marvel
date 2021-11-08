package com.marcelo.marvel.network.services

import com.marcelo.marvel.response.HeroesResponse
import com.marcelo.marvel.network.services.response.NetworkResponse
import com.marcelo.marvel.response.ErrorResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApiService {

    @GET("characters")
    suspend fun getHeroes(
        @Query("orderBy") orderBy: String = "name",
        @Query("limit") limit: Int = 100,
        @Query("ts") timestamp: String,
        @Query("apikey") publicApiKey: String,
        @Query("hash") hash: String
    ): NetworkResponse<HeroesResponse, ErrorResponse>

}