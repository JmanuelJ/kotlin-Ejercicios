package com.juanma.juanmapokedex.ui.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.juanma.juanmapokedex.databinding.ItemPokemonBinding

class PokeViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemPokemonBinding.bind(view)

    fun bind(text: String){
        binding.pokemonText.text = text
    }
}