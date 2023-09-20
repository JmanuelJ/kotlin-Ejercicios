package com.juanma.example_flow.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.juanma.example_flow.R
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var progressBar = findViewById<ProgressBar>(R.id.progressBar)

       // viewModel.example()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.uiState.collect(){uiState->
                    when(uiState){
                        is MainUIState.Error -> {
                            progressBar.isVisible = false
                            Toast.makeText(
                                this@MainActivity,
                                "Ha ocurrido un error: ${uiState.msg}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        MainUIState.Loading -> {
                            progressBar.isVisible = true
                        }

                        is MainUIState.Success -> {
                            progressBar.isVisible = false
                            Toast.makeText(
                                this@MainActivity,
                                "Numero de suscriptores: ${uiState.numbSuscribers}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }
        viewModel.example3()
    }
}