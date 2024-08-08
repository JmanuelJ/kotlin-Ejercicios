package com.juanma.exercise.notifications

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.juanma.exercise.notifications.home.HomeScreen
import com.juanma.exercise.notifications.home.HomeViewModel
import com.juanma.exercise.notifications.ui.theme.NotificationsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: HomeViewModel by viewModels()
        enableEdgeToEdge()
        setContent {
            NotificationsTheme {
                HomeScreen(viewModel = viewModel)
            }
        }
    }
}
