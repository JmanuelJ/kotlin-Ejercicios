package com.juanma.example_flow.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juanma.example_flow.data.SuscribeteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val suscribeteRepository = SuscribeteRepository()

    private val _uiState = MutableStateFlow <MainUIState> (MainUIState.Loading)
    val uiState: StateFlow<MainUIState> = _uiState


     fun example(){
        viewModelScope.launch{
            suscribeteRepository.counter.collect{
                Log.i("Jmanuel", it.toString())
            }
        }
    }

    fun example2(){
        viewModelScope.launch{
            suscribeteRepository.counter
                .map { it.toString()  } //numSuscriptores
                .onEach { save(it) }
                .catch {error ->
                    Log.i("JuanMa", "Error: ${error.message}")
                }
                .collect{ bombitas: String ->
                    Log.i("Jmanuel", bombitas)
            }
        }
    }

    fun example3(){
        viewModelScope.launch {
            suscribeteRepository.counter
                .catch { _uiState.value = MainUIState.Error(it.message.orEmpty()) }
                .flowOn(Dispatchers.IO)
                .collect{
                    _uiState.value = MainUIState.Success(it)
                }
        }
    }

    private fun save(info: String) {

    }

}