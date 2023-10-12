package com.juanma.juanmapokedex.data.model.remote

import com.juanma.juanmapokedex.core.RetrofitHelper
import com.juanma.juanmapokedex.data.model.PokeResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokeService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getPokemons(): List<PokeResult>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(PokeApiClient::class.java).getPokemonList(251,0)
            response.results ?: emptyList()
        }
    }

}