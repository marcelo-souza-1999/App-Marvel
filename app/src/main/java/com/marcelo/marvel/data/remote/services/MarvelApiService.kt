package com.marcelo.marvel.data.remote.services

import com.marcelo.marvel.data.remote.services.response.NetworkResponse
import com.marcelo.marvel.response.ComicsResponse
import com.marcelo.marvel.response.ErrorResponse
import com.marcelo.marvel.response.HeroesResponse
import retrofit2.http.GET
import retrofit2.http.Path
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

    @GET("characters/{characterId}/comics")
    suspend fun getComics(
        @Path(value = "characterId", encoded = true) characterId: Long,
        @Query("format") format: String = "comic",
        @Query("formatType") formatType: String = "comic",
        @Query("orderBy") orderBy: String = "title",
        @Query("ts") timestamp: String,
        @Query("apikey") publicApiKey: String,
        @Query("hash") hash: String
    ): NetworkResponse<ComicsResponse, ErrorResponse>
}