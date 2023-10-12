package com.juanma.juanmapokedex.data.model.remote

import com.juanma.juanmapokedex.data.model.PokeApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeApiClient {
    @GET("pokemon")
    suspend fun getPokemonList(@Query("limit") limit: Int, @Query("offset") offset: Int): PokeApiResponse
}