package com.juanma.juanmapokedex.data

import com.juanma.juanmapokedex.data.model.PokeProvider
import com.juanma.juanmapokedex.data.model.PokeResult
import com.juanma.juanmapokedex.data.model.remote.PokeService

class PokeRepository {
    private val api = PokeService()

    suspend fun getAllPokemons(): List<PokeResult>{
        val response = api.getPokemons()
        PokeProvider.pokemons = response
        return response
    }
}