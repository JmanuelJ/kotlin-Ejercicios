package com.juanma.exercise.camerax

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.juanma.exercise.camerax.home.HomeScreen
import com.juanma.exercise.camerax.ui.theme.CameraXTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CameraXTheme {
                HomeScreen()
            }
        }
    }
}

