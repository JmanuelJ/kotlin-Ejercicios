package com.juanma.juanmapokedex.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juanma.juanmapokedex.data.model.PokeResult
import com.juanma.juanmapokedex.domain.GetPokemonsUseCase
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    val pokeList = MutableLiveData<List<PokeResult>>()
    val isLoading = MutableLiveData<Boolean>()
    var getPokemonsUseCase = GetPokemonsUseCase()

    fun onCreate(){
        viewModelScope.launch{
            isLoading.postValue(true)
            val result = getPokemonsUseCase()
            if(result.isNotEmpty()){
                pokeList.postValue(result)
                isLoading.postValue(false)
            }
        }
    }
}