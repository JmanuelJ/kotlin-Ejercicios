package com.juanma.juanmapokedex.ui.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.juanma.juanmapokedex.databinding.ActivityMainBinding
import com.juanma.juanmapokedex.ui.home.HomeViewModel
import com.juanma.juanmapokedex.ui.home.PokeAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PokeAdapter
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initHomeViewModel()
    }

    private fun initView() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initHomeViewModel() {
        binding.pokelistRecyclerView.layoutManager = LinearLayoutManager(this)
        homeViewModel.onCreate()
        homeViewModel.pokeList.observe(this, Observer {currentPokemons ->
            adapter = PokeAdapter(currentPokemons)
            binding.pokelistRecyclerView.adapter = adapter
        })

    }
}