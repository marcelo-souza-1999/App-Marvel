package com.marcelo.marvel.network.services

import com.marcelo.marvel.BuildConfig
import com.marcelo.marvel.models.ErrorResponse
import com.marcelo.marvel.models.HeroesResponse
import com.marcelo.marvel.network.services.response.NetworkResponse
import com.marcelo.marvel.utils.HashMD5
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApiService {

    @GET("characters")
    suspend fun getHeroes(
        @Query("apikey") apikey: String = HashMD5.convertMD5(
            BuildConfig.HASH_API + BuildConfig.PRIVATE_API_KEY +
                  BuildConfig.PUBLIC_API_KEY)
    ): NetworkResponse<HeroesResponse, ErrorResponse>
}