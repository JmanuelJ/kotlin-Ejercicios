package com.juanma.example_flow.ui

sealed class MainUIState {
    object Loading: MainUIState()
    data class Success(val numbSuscribers:Int): MainUIState()
    data class Error(val msg: String): MainUIState()
}