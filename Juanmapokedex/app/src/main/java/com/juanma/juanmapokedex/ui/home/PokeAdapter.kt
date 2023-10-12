package com.juanma.juanmapokedex.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.juanma.juanmapokedex.R
import com.juanma.juanmapokedex.data.model.PokeResult

class PokeAdapter(private val pokemons: List<PokeResult>): RecyclerView.Adapter<PokeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return  PokeViewHolder(layoutInflater.inflate(R.layout.item_pokemon, parent, false))
    }

    override fun getItemCount(): Int = pokemons.size

    override fun onBindViewHolder(holder: PokeViewHolder, position: Int) {
        val item: String = pokemons[position].name
        holder.bind(item)
    }
}