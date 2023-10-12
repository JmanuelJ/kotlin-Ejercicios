package com.juanma.juanmapokedex.domain

import com.juanma.juanmapokedex.data.PokeRepository
import com.juanma.juanmapokedex.data.model.PokeResult

class GetPokemonsUseCase {
    private val repository = PokeRepository()

    suspend operator fun invoke(): List<PokeResult> = repository.getAllPokemons()
}